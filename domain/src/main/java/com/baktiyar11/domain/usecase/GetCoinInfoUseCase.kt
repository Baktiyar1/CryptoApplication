package com.baktiyar11.domain.usecase

import com.baktiyar11.domain.model.CoinInfoDomain

interface GetCoinInfoUseCase {
    suspend operator fun invoke(fSym: String): CoinInfoDomain
}