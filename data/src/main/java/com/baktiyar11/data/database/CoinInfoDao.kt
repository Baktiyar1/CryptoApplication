package com.baktiyar11.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CoinInfoDao {
    @Query("SELECT * FROM full_price_list ORDER BY lastUpdate DESC")
    suspend fun getPriceList(): List<CoinInfoStorage>

    @Query("SELECT * FROM full_price_list WHERE fromSymbol == :fSym LIMIT 1")
    suspend fun getPriceInfoAboutCoin(fSym: String): CoinInfoStorage

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPriceList(priceList: List<CoinInfoStorage>)
}