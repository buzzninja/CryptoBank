package com.example.cryptobank

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.cryptobank.api.ApiFactory
import com.example.cryptobank.database.AppDatabase
import com.example.cryptobank.pojo.getCryptInfo.CoinPriceInfo
import com.example.cryptobank.pojo.getCryptInfo.CoinPriceInfoRawData
import com.google.gson.Gson
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    init{
        loadData()
    }

    private val db = AppDatabase.getInstance(application)
    private val compositeDisposable = CompositeDisposable()

    val priceList = db.coinPriceInfoDao().getPriceList()

    fun getDetailInfo(fSym: String): LiveData<CoinPriceInfo> {
        return db.coinPriceInfoDao().getPriceInfoAboutCoin(fSym)
    }

    private fun loadData() {
        val disposable = ApiFactory.apiService.getTopCoinsInfo(limit = 20)
            .map { it.data?.map { it.coinInfo?.name }?.joinToString(",") as String }
            .flatMap { ApiFactory.apiService.getFullPriceList(fSyms = it) }
            .map { getPriceListFromRawData(it) }
            .delaySubscription(10,TimeUnit.SECONDS)//Задержка
            .repeat()//Повторяет загрузку, пока она не станет невозможна. После не возобновляется
            .retry()//Выполнит попытку загрузки после неудачи
            .subscribeOn(Schedulers.io())
            .subscribe(/*успешная загрузка*/{
                db.coinPriceInfoDao().insertPriceList(it)
                Log.d("TESTLOADING", "Success $it", null)
            },/*неуспешная загрузка*/{
                Log.d("TESTNOTLOADING", "Fail ${it.message.toString()}")
            })

    }

    private fun getPriceListFromRawData(coinPriceInfoRawData: CoinPriceInfoRawData)
            : List<CoinPriceInfo> {
        val result = ArrayList<CoinPriceInfo>()
        val jsonObject = coinPriceInfoRawData.coinPriceInfoJsonObject ?: return result
        val coinKeySet = jsonObject.keySet()
        for (coinKey in coinKeySet) {
            val currencyJson = jsonObject.getAsJsonObject(coinKey)
            val currencyKeySet = currencyJson.keySet()
            for (currencyKey in currencyKeySet) {
                val priceInfo = Gson().fromJson(
                    currencyJson.getAsJsonObject(currencyKey),
                    CoinPriceInfo::class.java
                )
                result.add(priceInfo)
            }
        }
        return result
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}