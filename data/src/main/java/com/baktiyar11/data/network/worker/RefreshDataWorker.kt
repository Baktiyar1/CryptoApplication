package com.baktiyar11.data.network.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkerParameters
import com.baktiyar11.data.database.CoinInfoDao
import com.baktiyar11.data.database.CoinInfoStorage
import com.baktiyar11.data.network.api.ApiService
import com.baktiyar11.data.network.model.CoinInfoCloud
import com.baktiyar11.data.network.model.CoinInfoJsonContainerCloud
import com.baktiyar11.data.network.model.CoinNamesListCloud
import com.baktiyar11.domain.base.Mapper
import kotlinx.coroutines.delay

class RefreshDataWorker(
    context: Context, workerParameters: WorkerParameters,
    private val api: ApiService, private val coinInfoDao: CoinInfoDao,
    private val mapJsonContainerToListCoinInfo: Mapper<CoinInfoJsonContainerCloud, List<CoinInfoCloud>>,
    private val mapCoinNameFromListCloudToString: Mapper<CoinNamesListCloud, String>,
    private val mapCoinInfoFromCloudToStorage: Mapper<CoinInfoCloud, CoinInfoStorage>,
) : CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {
        while (true) {
            try {
                coinInfoDao.insertPriceList(mapJsonContainerToListCoinInfo.map(api.getFullPriceList(
                    fSym = mapCoinNameFromListCloudToString.map(api.getTopCoinsInfo(limit = 50))))
                    .map { mapCoinInfoFromCloudToStorage.map(it) })
            } catch (e: Exception) {
            }
            delay(10000)
        }
    }

    companion object {
        const val NAME = "RefreshDataWorker"
        fun makeRequest() = OneTimeWorkRequestBuilder<RefreshDataWorker>().build()
    }
}