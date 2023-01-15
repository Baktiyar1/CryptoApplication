package com.baktiyar11.data.database.mappers

import com.baktiyar11.data.database.CoinInfoStorage
import com.baktiyar11.data.model.CoinInfoData
import com.baktiyar11.domain.base.Mapper

class MapCoinFromStorageToData : Mapper<CoinInfoStorage, CoinInfoData> {
    override fun map(from: CoinInfoStorage) = from.run {
        CoinInfoData(
            id = id, fromSymbol = fromSymbol, toSymbol = toSymbol, price = price, lowDay = lowDay,
            lastUpdate = lastUpdate, highDay = highDay, lastMarket = lastMarket, imageUrl = imageUrl
        )
    }
}