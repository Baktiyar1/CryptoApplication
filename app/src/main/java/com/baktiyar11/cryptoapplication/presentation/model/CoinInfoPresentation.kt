package com.baktiyar11.cryptoapplication.presentation.model

data class CoinInfoPresentation(
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
