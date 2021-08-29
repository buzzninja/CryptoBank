package com.example.cryptobank.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.cryptobank.R
import com.example.cryptobank.pojo.getCryptInfo.CoinPriceInfo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_coin_info.view.*

class CoinInfoAdapter(private val context: Context) : RecyclerView.Adapter<CoinInfoAdapter.CoinInfoViewHolder>() {

    var onCoinClickListener: OnCoinClickListener?=null


    var coinInfoList:List<CoinPriceInfo> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_coin_info, parent, false)
        return CoinInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coin = coinInfoList[position]
        with(holder) {
            val symbolsTeamplate = context.resources.getString(R.string.symbols_teamplate)
            val updateTime = context.resources.getString(R.string.update_time_teamplate)
            tvSymbols.text = String.format(symbolsTeamplate, coin.fromSymbol,coin.toSymbol)
            tvPrice.text = coin.price.toString()
            tvUpdateTime.text = String.format(updateTime,coin.getFormattedTime())
            Picasso.get().load(coin.getFullTimageUrl()).into(ivLogoCoin)
            itemView.setOnClickListener {
                onCoinClickListener?.onCoinClick(coin)
            }
        }

    }

    override fun getItemCount() = coinInfoList.size

    inner class CoinInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivLogoCoin = itemView.ivCoinLogo
        val tvSymbols = itemView.tvSymbols
        val tvPrice = itemView.tvPrice
        val tvUpdateTime = itemView.tvUpdateTime
    }

    interface OnCoinClickListener {
        fun onCoinClick(coinPriceInfo: CoinPriceInfo)
    }

}