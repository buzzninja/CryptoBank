package com.example.cryptobank.utils


import java.text.SimpleDateFormat
import java.util.*

fun convertTimestampToTime(time: Int?): String {
    if (time == null) return ""
    val localeDate = Date(time.toLong()*1000)
    val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    sdf.timeZone = Calendar.getInstance().timeZone
    val date = sdf.format(localeDate)
    return date
}