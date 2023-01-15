package com.baktiyar11.domain.repository

import com.baktiyar11.domain.model.CoinInfoDomain

interface CoinRepository {
    suspend fun getCoinInfoList(): List<CoinInfoDomain>
    suspend fun getCoinInfo(fSym: String): CoinInfoDomain
    suspend fun loadData()
}