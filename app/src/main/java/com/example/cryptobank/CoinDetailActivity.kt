package com.example.cryptobank

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_coin_detail.*
import kotlinx.android.synthetic.main.item_coin_info.*

class CoinDetailActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_detail)
        val fromSymbol = intent.getStringExtra(EXTRA_FROM_SYMBOL)
        if (fromSymbol==null) {
            finish()
            return
        }

        viewModel = ViewModelProvider(
            ViewModelStore(),
            ViewModelProvider.AndroidViewModelFactory(application)
        )[CoinViewModel::class.java]
        viewModel.getDetailInfo(fromSymbol).observe(this, Observer {
            tvDetailFromSymbol.text = it.fromSymbol
            tvDetailToSymbol.text = it.toSymbol
            tvDetailedPrice.text = it.price.toString()
            tvDetailedMinPrice.text = it.lowDay.toString()
            tvDetailedMaxPrice.text = it.highDay.toString()
            tvDetailedLastMarket.text = it.lastMarket

            tvDetailedLastUpdate.text = it.getFormattedUpdateTime()
            Picasso.get().load(it.getFullTimageUrl()).into(ivBigIcon)
        })


    }

    companion object {
       private const val EXTRA_FROM_SYMBOL = "fSym"
        fun newIntent(context: Context, fromSymbol:String):Intent{
            val intent = Intent(context,CoinDetailActivity::class.java)
            intent.putExtra(EXTRA_FROM_SYMBOL,fromSymbol)
            return intent
        }
    }
}