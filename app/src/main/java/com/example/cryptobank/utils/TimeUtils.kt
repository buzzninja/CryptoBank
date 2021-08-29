package com.example.cryptobank.utils

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

fun convertTimetampToTIme(time:Int?):String{
    if (time==null) return ""
    val stamp = Timestamp((time*1000).toLong())
    val date = Date(stamp.time)
    val pattern = "HH:mm:ss"
    val sdf=SimpleDateFormat(pattern,Locale.getDefault())
    sdf.timeZone = TimeZone.getDefault()
    return sdf.format(date)
}