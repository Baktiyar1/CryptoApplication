package com.baktiyar11.domain.usecase

import com.baktiyar11.domain.model.CoinInfoDomain

interface GetCoinInfoListUseCase {
    suspend operator fun invoke(): List<CoinInfoDomain>
}