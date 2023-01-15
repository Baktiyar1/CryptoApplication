package com.baktiyar11.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "full_price_list")
data class CoinInfoStorage(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val fromSymbol: String,
    val toSymbol: String?,
    val price: String?,
    val lastUpdate: String?,
    val highDay: String?,
    val lowDay: String?,
    val lastMarket: String?,
    val imageUrl: String?,
)