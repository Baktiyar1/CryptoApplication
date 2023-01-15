package com.baktiyar11.data.database.mappers

import com.baktiyar11.data.database.CoinInfoStorage
import com.baktiyar11.data.model.CoinInfoData
import com.baktiyar11.domain.base.Mapper

class MapCoinListFromStorageToData(private val mapper: Mapper<CoinInfoStorage, CoinInfoData>) :
    Mapper<List<CoinInfoStorage>, List<CoinInfoData>> {
    override fun map(from: List<CoinInfoStorage>) = from.map { mapper.map(it) }
}