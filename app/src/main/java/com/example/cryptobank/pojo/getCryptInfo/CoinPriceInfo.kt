package com.example.cryptobank.pojo.getCryptInfo

import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "full_price_list")
data class CoinPriceInfo(
    @SerializedName("TYPE")
    @Expose
    val type: String?,
    @SerializedName("MARKET")
    @Expose
    val market: String?,
    @PrimaryKey
    @SerializedName("FROMSYMBOL")
    @Expose
    val fromSymbol: String,
    @SerializedName("TOSYMBOL")
    @Expose
    val toSymbol: String?,
    @SerializedName("FLAGS")
    @Expose
    val flags: String?,
    @SerializedName("PRICE")
    @Expose
    val price: Double?,
    @SerializedName("LASTUPDATE")
    @Expose
    val lastUpdate: Int?,
    @SerializedName("LASTVOLUME")
    @Expose
    val lastVolume: Double?,
    @SerializedName("LASTVOLUMETO")
    @Expose
    val lastVolumeTo: Double?,
    @SerializedName("LASTTRADEID")
    @Expose
    val lastTradeId: String?,
    @SerializedName("VOLUMEDAY")
    @Expose
    val volumeDay: Double?,
    @SerializedName("VOLUMEDAYTO")
    @Expose
    val volumeDayTo: Double?,
    @SerializedName("VOLUME24HOUR")
    @Expose
    val volume24Hour: Double?,
    @SerializedName("VOLUME24HOURTO")
    @Expose
    val volume24HourTo: Double?,
    @SerializedName("OPENDAY")
    @Expose
    val openDay: Double?,
    @SerializedName("HIGHDAY")
    @Expose
    val highDay: Double?,
    @SerializedName("LOWDAY")
    @Expose
    val lowDay: Double?,
    @SerializedName("OPEN24HOUR")
    @Expose
    val open24Hour: Double,
    @SerializedName("HIGH24HOUR")
    @Expose
    val high24Hour: Double?,
    @SerializedName("LOW24HOUR")
    @Expose
    val low24Hour: Double?,
    @SerializedName("LASTMARKET")
    @Expose
    val lastMarket: String?,
    @SerializedName("IMAGEURL")
    @Expose
    val imageUrl: String?
    //@SerializedName("MEDIAN")
    //@Expose
    //val median:Double?,
//@SerializedName("VOLUMEHOUR")
//@Expose
//Double volumehour;
//@SerializedName("VOLUMEHOURTO")
//@Expose
//Double volumehourto;
//@SerializedName("OPENHOUR")
//@Expose
//Double openhour;
//@SerializedName("HIGHHOUR")
//@Expose
//Double highhour;
//@SerializedName("LOWHOUR")
//@Expose
//Double lowhour;
//@SerializedName("TOPTIERVOLUME24HOUR")
//@Expose
//Double toptiervolume24hour;
//@SerializedName("TOPTIERVOLUME24HOURTO")
//@Expose
//Double toptiervolume24hourto;
//@SerializedName("CHANGE24HOUR")
//@Expose
//Double change24hour;
//@SerializedName("CHANGEPCT24HOUR")
//@Expose
//Double changepct24hour;
//@SerializedName("CHANGEDAY")
//@Expose
//Double changeday;
//@SerializedName("CHANGEPCTDAY")
//@Expose
//Double changepctday;
//@SerializedName("CHANGEHOUR")
//@Expose
//Double changehour;
//@SerializedName("CHANGEPCTHOUR")
//@Expose
//Double changepcthour;
//@SerializedName("CONVERSIONTYPE")
//@Expose
//String conversiontype;
//@SerializedName("CONVERSIONSYMBOL")
//@Expose
//String conversionsymbol;
//@SerializedName("SUPPLY")
//@Expose
//Integer supply;
//@SerializedName("MKTCAP")
//@Expose
//Double mktcap;
//@SerializedName("MKTCAPPENALTY")
//@Expose
//Integer mktcappenalty;
//@SerializedName("TOTALVOLUME24H")
//@Expose
//Double totalvolume24h;
//@SerializedName("TOTALVOLUME24HTO")
//@Expose
//Double totalvolume24hto;
//@SerializedName("TOTALTOPTIERVOLUME24H")
//@Expose
//Double totaltoptiervolume24h;
//@SerializedName("TOTALTOPTIERVOLUME24HTO")
//@Expose
//Double totaltoptiervolume24hto;

)