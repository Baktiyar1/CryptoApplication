package com.baktiyar11.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CoinInfoStorage::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun coinPriceInfoDao(): CoinInfoDao
}