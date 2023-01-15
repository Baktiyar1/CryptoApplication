package com.baktiyar11.domain.usecase

import com.baktiyar11.domain.repository.CoinRepository

class LoadDataUseCaseImpl(private val repository: CoinRepository) : LoadDataUseCase {
    override suspend fun invoke() = repository.loadData()
}