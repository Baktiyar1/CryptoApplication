package com.baktiyar11.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinNamesListCloud(
    @SerializedName("Data")
    @Expose
    val names: List<CoinNameContainerCloud>? = null,
)