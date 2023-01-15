package com.baktiyar11.data.mappers

import com.baktiyar11.data.model.CoinInfoData
import com.baktiyar11.domain.base.Mapper
import com.baktiyar11.domain.model.CoinInfoDomain

class MapCoinListFromDataToDomain(private val mapper: Mapper<CoinInfoData, CoinInfoDomain>) :
    Mapper<List<CoinInfoData>, List<CoinInfoDomain>> {
    override fun map(from: List<CoinInfoData>) = from.map { mapper.map(it) }
}