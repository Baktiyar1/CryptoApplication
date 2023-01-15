package com.baktiyar11.cryptoapplication.di

import com.baktiyar11.cryptoapplication.presentation.mapper.MapCoinFromDomainToPresentation
import com.baktiyar11.cryptoapplication.presentation.mapper.MapCoinListFromDomainToPresentation
import com.baktiyar11.cryptoapplication.presentation.model.CoinInfoPresentation
import com.baktiyar11.data.database.CoinInfoStorage
import com.baktiyar11.data.database.mappers.*
import com.baktiyar11.data.mappers.MapCoinFromDataToDomain
import com.baktiyar11.data.mappers.MapCoinListFromDataToDomain
import com.baktiyar11.data.model.CoinInfoData
import com.baktiyar11.data.network.model.CoinInfoCloud
import com.baktiyar11.data.network.model.CoinInfoJsonContainerCloud
import com.baktiyar11.data.network.model.CoinNamesListCloud
import com.baktiyar11.domain.base.Mapper
import com.baktiyar11.domain.model.CoinInfoDomain
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    fun provideMapCoinFromStorageToData(): Mapper<CoinInfoStorage, CoinInfoData> =
        MapCoinFromStorageToData()

    @Provides
    fun provideMapCoinInfoFromCloudToStorage(): Mapper<CoinInfoCloud, CoinInfoStorage> =
        MapCoinInfoFromCloudToStorage()

    @Provides
    fun provideMapCoinListFromStorageToData(mapper: Mapper<CoinInfoStorage, CoinInfoData>):
            Mapper<List<CoinInfoStorage>, List<CoinInfoData>> = MapCoinListFromStorageToData(mapper)

    @Provides
    fun provideMapCoinNameFromListCloudToString(): Mapper<CoinNamesListCloud, String> =
        MapCoinNameFromListCloudToString()

    @Provides
    fun provideMapJsonContainerToListCoinInfo(): Mapper<CoinInfoJsonContainerCloud, List<CoinInfoCloud>> =
        MapJsonContainerToListCoinInfo()

    @Provides
    fun provideMapCoinFromDataToDomain(): Mapper<CoinInfoData, CoinInfoDomain> =
        MapCoinFromDataToDomain()

    @Provides
    fun provideMapCoinListFromDataToDomain(mapper: Mapper<CoinInfoData, CoinInfoDomain>)
            : Mapper<List<CoinInfoData>, List<CoinInfoDomain>> = MapCoinListFromDataToDomain(mapper)

    @Provides
    fun provideMapCoinFromDomainToPresentation(): Mapper<CoinInfoDomain, CoinInfoPresentation> =
        MapCoinFromDomainToPresentation()

    @Provides
    fun provideMapCoinListFromDomainToPresentation(mapper: Mapper<CoinInfoDomain, CoinInfoPresentation>)
            : Mapper<List<CoinInfoDomain>, List<CoinInfoPresentation>> =
        MapCoinListFromDomainToPresentation(mapper)
}