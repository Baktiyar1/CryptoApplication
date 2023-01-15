package com.baktiyar11.domain.usecase

import com.baktiyar11.domain.repository.CoinRepository

class GetCoinInfoListUseCaseImpl(private val repository: CoinRepository) : GetCoinInfoListUseCase {
    override suspend operator fun invoke() = repository.getCoinInfoList()
}