package com.baktiyar11.domain.usecase

import com.baktiyar11.domain.repository.CoinRepository

class GetCoinInfoUseCaseImpl(private val repository: CoinRepository) : GetCoinInfoUseCase {
    override suspend operator fun invoke(fSym: String) = repository.getCoinInfo(fSym)
}