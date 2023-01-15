package com.baktiyar11.cryptoapplication.di

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.baktiyar11.data.database.CoinInfoDao
import com.baktiyar11.data.database.CoinInfoStorage
import com.baktiyar11.data.network.api.ApiService
import com.baktiyar11.data.network.model.CoinInfoCloud
import com.baktiyar11.data.network.model.CoinInfoJsonContainerCloud
import com.baktiyar11.data.network.model.CoinNamesListCloud
import com.baktiyar11.data.network.worker.RefreshDataWorker
import com.baktiyar11.domain.base.Mapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WorkerModule {
    @Provides
    @Singleton
    fun provideRefreshDataWorkerImpl(
        @ApplicationContext context: Context, workerParameters: WorkerParameters,
        api: ApiService, coinInfoDao: CoinInfoDao,
        mapJsonContainerToListCoinInfo: Mapper<CoinInfoJsonContainerCloud, List<CoinInfoCloud>>,
        mapCoinNameFromListCloudToString: Mapper<CoinNamesListCloud, String>,
        mapCoinInfoFromCloudToStorage: Mapper<CoinInfoCloud, CoinInfoStorage>,
    ): CoroutineWorker = RefreshDataWorker(
        context = context, workerParameters = workerParameters, api = api,
        coinInfoDao = coinInfoDao, mapJsonContainerToListCoinInfo = mapJsonContainerToListCoinInfo,
        mapCoinNameFromListCloudToString = mapCoinNameFromListCloudToString,
        mapCoinInfoFromCloudToStorage = mapCoinInfoFromCloudToStorage
    )
}