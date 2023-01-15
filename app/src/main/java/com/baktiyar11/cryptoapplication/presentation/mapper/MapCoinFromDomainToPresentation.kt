package com.baktiyar11.cryptoapplication.presentation.mapper

import com.baktiyar11.cryptoapplication.presentation.model.CoinInfoPresentation
import com.baktiyar11.domain.base.Mapper
import com.baktiyar11.domain.model.CoinInfoDomain

class MapCoinFromDomainToPresentation : Mapper<CoinInfoDomain, CoinInfoPresentation> {
    override fun map(from: CoinInfoDomain) = from.run {
        CoinInfoPresentation(
            id = id, fromSymbol = fromSymbol, toSymbol = toSymbol, price = price,
            lastUpdate = lastUpdate, highDay = highDay, lowDay = lowDay, lastMarket = lastMarket,
            imageUrl = imageUrl
        )
    }
}