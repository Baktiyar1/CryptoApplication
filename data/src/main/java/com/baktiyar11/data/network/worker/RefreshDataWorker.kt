package com.baktiyar11.data.network.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.OneTimeWorkRequest
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
                val topCoins = api.getTopCoinsInfo(limit = 50)
                val fSym = mapCoinNameFromListCloudToString.map(topCoins)
                val jsonContainer = api.getFullPriceList(fSym = fSym)
                val coinInfoDtoList = mapJsonContainerToListCoinInfo.map(jsonContainer)
                val dbModelList = coinInfoDtoList.map { mapCoinInfoFromCloudToStorage.map(it) }
                coinInfoDao.insertPriceList(dbModelList)
            } catch (e: Exception) {
            }
            delay(10000)
        }
    }

    companion object {
        const val NAME = "RefreshDataWorker"

        fun makeRequest(): OneTimeWorkRequest =
            OneTimeWorkRequestBuilder<RefreshDataWorker>().build()
    }
}