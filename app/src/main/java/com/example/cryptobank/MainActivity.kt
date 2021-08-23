package com.example.cryptobank

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.cryptobank.api.ApiFactory
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

private val compositeDisposable = CompositeDisposable()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val disposable = ApiFactory.apiService.getFullPriceList(fSyms = "BTC")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(/*успешная загрузка*/{
                Log.d("TESTLOADING",it.toString())
            },/*неуспешная загрузка*/{
                Log.d("TESTLOADING",it.message.toString())
            })
        compositeDisposable.addAll(disposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}