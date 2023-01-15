package com.baktiyar11.data.network.source

import android.content.Context
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.baktiyar11.data.database.CoinInfoDao
import com.baktiyar11.data.database.CoinInfoStorage
import com.baktiyar11.data.model.CoinInfoData
import com.baktiyar11.data.network.worker.RefreshDataWorker
import com.baktiyar11.domain.base.Mapper

class CloudCoinInfoRepositoryImp(
    private val context: Context, private val coinInfoDao: CoinInfoDao,
    private val mapCoinListFromStorageToData: Mapper<List<CoinInfoStorage>, List<CoinInfoData>>,
    private val mapCoinFromStorageToData: Mapper<CoinInfoStorage, CoinInfoData>,
) : CloudCoinInfoRepository {
    override suspend fun getCoinInfoList(): List<CoinInfoData> =
        mapCoinListFromStorageToData.map(coinInfoDao.getPriceList())

    override suspend fun getCoinInfo(fSym: String): CoinInfoData =
        mapCoinFromStorageToData.map(coinInfoDao.getPriceInfoAboutCoin(fSym = fSym))

    override fun loadData() {
        WorkManager.getInstance(context).enqueueUniqueWork(
            RefreshDataWorker.NAME, ExistingWorkPolicy.REPLACE, RefreshDataWorker.makeRequest()
        )
    }
}