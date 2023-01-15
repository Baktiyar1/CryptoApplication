package com.baktiyar11.cryptoapplication.presentation.mapper

import com.baktiyar11.cryptoapplication.presentation.model.CoinInfoPresentation
import com.baktiyar11.domain.base.Mapper
import com.baktiyar11.domain.model.CoinInfoDomain

class MapCoinListFromDomainToPresentation(private val mapper: Mapper<CoinInfoDomain, CoinInfoPresentation>) :
    Mapper<List<CoinInfoDomain>, List<CoinInfoPresentation>> {
    override fun map(from: List<CoinInfoDomain>) = from.map { mapper.map(it) }
}