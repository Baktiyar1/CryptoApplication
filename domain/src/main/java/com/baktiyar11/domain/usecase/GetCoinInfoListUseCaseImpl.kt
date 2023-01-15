package com.baktiyar11.domain.usecase

import com.baktiyar11.domain.model.CoinInfoDomain
import com.baktiyar11.domain.repository.CoinRepository

class GetCoinInfoListUseCaseImpl(private val repository: CoinRepository) : GetCoinInfoListUseCase {
    override suspend fun invoke(): List<CoinInfoDomain> = repository.getCoinInfoList()
}