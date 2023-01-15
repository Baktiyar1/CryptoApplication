package com.baktiyar11.cryptoapplication.di

import android.content.Context
import com.baktiyar11.data.database.CoinInfoDao
import com.baktiyar11.data.database.CoinInfoStorage
import com.baktiyar11.data.model.CoinInfoData
import com.baktiyar11.data.network.source.CloudCoinInfoRepository
import com.baktiyar11.data.network.source.CloudCoinInfoRepositoryImp
import com.baktiyar11.domain.base.Mapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CloudRepositoryModule {
    @Provides
    @Singleton
    fun provideCloudCoinInfoRepository(
        @ApplicationContext context: Context, coinInfoDao: CoinInfoDao,
        mapCoinListFromStorageToData: Mapper<List<CoinInfoStorage>, List<CoinInfoData>>,
        mapCoinFromStorageToData: Mapper<CoinInfoStorage, CoinInfoData>,
    ): CloudCoinInfoRepository = CloudCoinInfoRepositoryImp(
        coinInfoDao = coinInfoDao, mapCoinListFromStorageToData = mapCoinListFromStorageToData,
        mapCoinFromStorageToData = mapCoinFromStorageToData, context = context,
    )
}