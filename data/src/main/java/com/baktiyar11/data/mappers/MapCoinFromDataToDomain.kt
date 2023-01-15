package com.baktiyar11.data.mappers

import com.baktiyar11.data.model.CoinInfoData
import com.baktiyar11.domain.base.Mapper
import com.baktiyar11.domain.model.CoinInfoDomain

class MapCoinFromDataToDomain : Mapper<CoinInfoData, CoinInfoDomain> {
    override fun map(from: CoinInfoData) = from.run {
        CoinInfoDomain(
            id = id, fromSymbol = fromSymbol, toSymbol = toSymbol, price = price,
            lastUpdate = lastUpdate, highDay = highDay, lowDay = lowDay, lastMarket = lastMarket,
            imageUrl = imageUrl
        )
    }
}