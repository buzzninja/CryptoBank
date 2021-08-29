package com.example.cryptobank


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*

class CoinPriceListActivity : AppCompatActivity() {


    private lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_price_list)
        viewModel = ViewModelProvider(
            ViewModelStore(),
            ViewModelProvider.AndroidViewModelFactory(application)
        )[CoinViewModel::class.java]
        viewModel.priceList.observe(this, Observer {
            Log.d("TEST_MAINACT_LOADING", "Success: $it")
        })
        viewModel.getDetailInfo("BTC").observe(this, Observer {
            Log.d("TEST_DETAIL_LOADING", "SuccessDetail: $it")
        })
    }


}




