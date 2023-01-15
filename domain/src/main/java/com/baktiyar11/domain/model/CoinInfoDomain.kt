package com.baktiyar11.domain.model

class CoinInfoDomain(
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