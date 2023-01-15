package com.baktiyar11.data.database.mappers

import com.baktiyar11.data.database.CoinInfoStorage
import com.baktiyar11.data.network.model.CoinInfoCloud
import com.baktiyar11.domain.base.Mapper
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

class MapCoinInfoFromCloudToStorage : Mapper<CoinInfoCloud, CoinInfoStorage> {
    override fun map(from: CoinInfoCloud) = from.run {
        CoinInfoStorage(
            id = id, fromSymbol = fromSymbol, toSymbol = toSymbol, price = price,
            lastMarket = lastMarket, lastUpdate = convertTimestampToTimeString(lastUpdate),
            highDay = highDay, lowDay = lowDay, imageUrl = BASE_IMAGE_URL + imageUrl
        )
    }

    private fun convertTimestampToTimeString(timestamp: Long?): String {
        if (timestamp == null) return ""
        val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        sdf.timeZone = TimeZone.getDefault()
        return sdf.format(Date(Timestamp(timestamp * 1000).time))
    }

    companion object {
        private const val BASE_IMAGE_URL = "https://cryptocompare.com"
    }
}