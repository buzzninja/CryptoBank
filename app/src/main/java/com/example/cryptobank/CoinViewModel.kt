package com.example.cryptobank

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.cryptobank.api.ApiFactory
import com.example.cryptobank.database.AppDatabase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlin.Exception

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getInstance(application)
    private val compositeDisposable = CompositeDisposable()

    val priceList = db.coinPriceInfoDao().getPriceList()

    fun loadData() {//РЕШИТЬ ВОПРОС!
        val disposable = ApiFactory.apiService.getTopCoinsInfo(limit = 10)
            .map { it.data?.map { it.coinInfo?.name }?.joinToString(",") }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(/*успешная загрузка*/{
                Log.d("TESTLOADING",it,java.lang.Exception("sux"))
            },/*неуспешная загрузка*/{
                Log.d("TESTLOADING", it.message.toString())
            })

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}