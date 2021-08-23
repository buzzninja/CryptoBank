package com.example.cryptobank.api

import com.example.cryptobank.pojo.getCryptInfo.CoinPriceInfoRawData
import com.example.cryptobank.pojo.getListOfCrypts.CoinInfoListOfData
//import io.reactivex.Single
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top/totalvolfull")
    fun getTopCoinsInfo(
        @Query(QUERY_PARAM_API_KEY) apiKey:String = API_KEY,
        @Query(QUERY_PARAM_LIMIT) limit:Int = 1,
        @Query(QUERY_PARAM_TO_SYMBOL) tSym:String = CURRENCY

    ): Single<CoinInfoListOfData>

    @GET("pricemultifull")
    fun getFullPriceList(
        @Query(QUERY_PARAM_API_KEY) apiKey:String = API_KEY,
        @Query(QUERY_PARAM_FROM_SYMBOLS) fSyms:String,
        @Query(QUERY_PARAM_TO_SYMBOLS) tSyms:String = CURRENCY

    ):Single<CoinPriceInfoRawData>

    companion object{
        //для получения листа
        private const val QUERY_PARAM_LIMIT = "limit"
        private const val QUERY_PARAM_TO_SYMBOL = "tsym"
        private const val QUERY_PARAM_API_KEY = "api_key"
        //для получения информации по отдельным валютам
        private const val QUERY_PARAM_TO_SYMBOLS = "tsyms"
        private const val QUERY_PARAM_FROM_SYMBOLS = "fsyms"

        private const val CURRENCY = "USD"
        private const val API_KEY = "85d9471088fb0cfc5e8f0c89ed1ea228def1f7e3b3ce32bfea8a35ae7b92c8e2"
    }
}