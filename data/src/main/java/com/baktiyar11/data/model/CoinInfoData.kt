package com.baktiyar11.data.model

data class CoinInfoData(
    val id: Int,
    val fromSymbol: String,
    val toSymbol: String?,
    val price: String?,
    val lastUpdate: String?,
    val highDay: String?,
    val lowDay: String?,
    val lastMarket: String?,
    val imageUrl: String?,
)