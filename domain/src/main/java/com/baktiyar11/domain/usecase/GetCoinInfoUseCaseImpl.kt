package com.baktiyar11.domain.usecase

import com.baktiyar11.domain.model.CoinInfoDomain
import com.baktiyar11.domain.repository.CoinRepository

class GetCoinInfoUseCaseImpl(private val repository: CoinRepository) : GetCoinInfoUseCase {
    override suspend fun invoke(fSym: String): CoinInfoDomain = repository.getCoinInfo(fSym = fSym)
}