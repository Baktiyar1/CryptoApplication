package com.baktiyar11.data.domain_repository_impl

import com.baktiyar11.data.model.CoinInfoData
import com.baktiyar11.data.network.source.CloudCoinInfoRepository
import com.baktiyar11.domain.base.Mapper
import com.baktiyar11.domain.model.CoinInfoDomain
import com.baktiyar11.domain.repository.CoinRepository

class CoinRepositoryImpl(
    private val dataSource: CloudCoinInfoRepository,
    private val mapCoinListFromDataToDomain: Mapper<List<CoinInfoData>, List<CoinInfoDomain>>,
    private val mapCoinFromDataToDomain: Mapper<CoinInfoData, CoinInfoDomain>,
) : CoinRepository {

    override suspend fun getCoinInfoList(): List<CoinInfoDomain> =
        mapCoinListFromDataToDomain.map(dataSource.getCoinInfoList())

    override suspend fun getCoinInfo(fSym: String): CoinInfoDomain =
        mapCoinFromDataToDomain.map(dataSource.getCoinInfo(fSym))

    override fun loadData() = dataSource.loadData()
}