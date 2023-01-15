package com.baktiyar11.data.network.source

import com.baktiyar11.data.database.CoinInfoDao
import com.baktiyar11.data.database.CoinInfoStorage
import com.baktiyar11.data.model.CoinInfoData
import com.baktiyar11.data.network.api.ApiService
import com.baktiyar11.data.network.model.CoinInfoCloud
import com.baktiyar11.data.network.model.CoinInfoJsonContainerCloud
import com.baktiyar11.data.network.model.CoinNamesListCloud
import com.baktiyar11.domain.base.Mapper
import kotlinx.coroutines.delay

class CloudCoinInfoRepositoryImp(
    private val api: ApiService,
    private val coinInfoDao: CoinInfoDao,
    private val mapCoinListFromStorageToData: Mapper<List<CoinInfoStorage>, List<CoinInfoData>>,
    private val mapCoinFromStorageToData: Mapper<CoinInfoStorage, CoinInfoData>,
    private val mapJsonContainerToListCoinInfo: Mapper<CoinInfoJsonContainerCloud, List<CoinInfoCloud>>,
    private val mapCoinNameFromListCloudToString: Mapper<CoinNamesListCloud, String>,
    private val mapCoinInfoFromCloudToStorage: Mapper<CoinInfoCloud, CoinInfoStorage>,
) : CloudCoinInfoRepository {
    override suspend fun getCoinInfoList(): List<CoinInfoData> =
        mapCoinListFromStorageToData.map(coinInfoDao.getPriceList())

    override suspend fun getCoinInfo(fSym: String): CoinInfoData =
        mapCoinFromStorageToData.map(coinInfoDao.getPriceInfoAboutCoin(fSym = fSym))

    override suspend fun loadData() {
        while (true) {
            try {
                coinInfoDao.insertPriceList(mapJsonContainerToListCoinInfo.map(
                    api.getFullPriceList(
                        fSyms = mapCoinNameFromListCloudToString.map(api.getTopCoinsInfo(limit = 50))
                    )
                ).map { mapCoinInfoFromCloudToStorage.map(it) })
            } catch (e: Exception) {
            }
            delay(10000)
        }
    }
}