package com.baktiyar11.cryptoapplication.di

import com.baktiyar11.data.database.CoinInfoDao
import com.baktiyar11.data.database.CoinInfoStorage
import com.baktiyar11.data.model.CoinInfoData
import com.baktiyar11.data.network.api.ApiService
import com.baktiyar11.data.network.model.CoinInfoCloud
import com.baktiyar11.data.network.model.CoinInfoJsonContainerCloud
import com.baktiyar11.data.network.model.CoinNamesListCloud
import com.baktiyar11.data.network.source.CloudCoinInfoRepository
import com.baktiyar11.data.network.source.CloudCoinInfoRepositoryImp
import com.baktiyar11.domain.base.Mapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CloudRepositoryModule {
    @Provides
    @Singleton
    fun provideCloudCoinInfoRepository(
        api: ApiService, coinInfoDao: CoinInfoDao,
        mapCoinListFromStorageToData: Mapper<List<CoinInfoStorage>, List<CoinInfoData>>,
        mapCoinFromStorageToData: Mapper<CoinInfoStorage, CoinInfoData>,
        mapJsonContainerToListCoinInfo: Mapper<CoinInfoJsonContainerCloud, List<CoinInfoCloud>>,
        mapCoinNameFromListCloudToString: Mapper<CoinNamesListCloud, String>,
        mapCoinInfoFromCloudToStorage: Mapper<CoinInfoCloud, CoinInfoStorage>,
    ): CloudCoinInfoRepository = CloudCoinInfoRepositoryImp(
        coinInfoDao = coinInfoDao, mapCoinListFromStorageToData = mapCoinListFromStorageToData,
        mapCoinFromStorageToData = mapCoinFromStorageToData, api = api,
        mapJsonContainerToListCoinInfo = mapJsonContainerToListCoinInfo,
        mapCoinNameFromListCloudToString = mapCoinNameFromListCloudToString,
        mapCoinInfoFromCloudToStorage = mapCoinInfoFromCloudToStorage
    )
}