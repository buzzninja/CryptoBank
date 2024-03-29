package com.example.cryptobank.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cryptobank.pojo.getCryptInfo.CoinPriceInfo

@Database(entities = [CoinPriceInfo::class],version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        private var db: AppDatabase? = null
        private const val DB_NAME = "main.db"
        private val LOCK = Any()

        fun getInstance(context: Context): AppDatabase {
            synchronized(LOCK) {
                //хитрый обман для избежания !! и проверок
                db?.let { return it }

                val instance: AppDatabase =
                    Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        DB_NAME
                    ).build()
                return instance

            }
        }
    }
    abstract fun coinPriceInfoDao():CoinPriceInfoDao
}