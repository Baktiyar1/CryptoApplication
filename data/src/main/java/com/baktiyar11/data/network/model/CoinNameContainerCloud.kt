package com.baktiyar11.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinNameContainerCloud(
    @SerializedName("CoinInfo")
    @Expose
    val coinInfo: CoinNameCloud? = null,
)