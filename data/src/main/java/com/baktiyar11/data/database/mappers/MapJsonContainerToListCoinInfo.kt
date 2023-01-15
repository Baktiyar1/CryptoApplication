package com.baktiyar11.data.database.mappers

import com.baktiyar11.data.network.model.CoinInfoCloud
import com.baktiyar11.data.network.model.CoinInfoJsonContainerCloud
import com.baktiyar11.domain.base.Mapper
import com.google.gson.Gson

class MapJsonContainerToListCoinInfo : Mapper<CoinInfoJsonContainerCloud, List<CoinInfoCloud>> {
    override fun map(from: CoinInfoJsonContainerCloud): List<CoinInfoCloud> {
        val result = mutableListOf<CoinInfoCloud>()
        val jsonObject = from.json ?: return result
        for (coinKey in jsonObject.keySet()) {
            val currencyJson = jsonObject.getAsJsonObject(coinKey)
            for (currencyKey in currencyJson.keySet()) result.add(
                Gson().fromJson(
                    currencyJson.getAsJsonObject(currencyKey), CoinInfoCloud::class.java
                )
            )
        }
        return result
    }
}