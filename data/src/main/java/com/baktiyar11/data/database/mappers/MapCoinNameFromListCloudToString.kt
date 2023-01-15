package com.baktiyar11.data.database.mappers

import com.baktiyar11.data.network.model.CoinNamesListCloud
import com.baktiyar11.domain.base.Mapper

class MapCoinNameFromListCloudToString : Mapper<CoinNamesListCloud, String> {
    override fun map(from: CoinNamesListCloud): String =
        from.names?.map { it.coinInfo?.name }?.joinToString(",") ?: ""
}