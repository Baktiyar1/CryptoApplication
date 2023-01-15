package com.baktiyar11.data.network.source

import com.baktiyar11.data.model.CoinInfoData

interface CloudCoinInfoRepository {
    suspend fun getCoinInfoList(): List<CoinInfoData>
    suspend fun getCoinInfo(fSym: String): CoinInfoData
    suspend fun loadData()
}