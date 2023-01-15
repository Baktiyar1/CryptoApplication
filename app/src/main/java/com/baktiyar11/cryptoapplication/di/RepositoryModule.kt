package com.baktiyar11.cryptoapplication.di

import com.baktiyar11.data.domain_repository_impl.CoinRepositoryImpl
import com.baktiyar11.data.model.CoinInfoData
import com.baktiyar11.data.network.source.CloudCoinInfoRepository
import com.baktiyar11.domain.base.Mapper
import com.baktiyar11.domain.model.CoinInfoDomain
import com.baktiyar11.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun coinInfoRepository(
        dataSource: CloudCoinInfoRepository,
        mapCoinListFromDataToDomain: Mapper<List<CoinInfoData>, List<CoinInfoDomain>>,
        mapCoinFromDataToDomain: Mapper<CoinInfoData, CoinInfoDomain>,
    ): CoinRepository = CoinRepositoryImpl(
        dataSource = dataSource, mapCoinListFromDataToDomain = mapCoinListFromDataToDomain,
        mapCoinFromDataToDomain = mapCoinFromDataToDomain
    )
}