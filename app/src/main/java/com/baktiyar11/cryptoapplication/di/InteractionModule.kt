package com.baktiyar11.cryptoapplication.di

import com.baktiyar11.domain.repository.CoinRepository
import com.baktiyar11.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object InteractionModule {

    @Provides
    fun provideGetCoinInfoListUseCaseDomain(repository: CoinRepository): GetCoinInfoListUseCase =
        GetCoinInfoListUseCaseImpl(repository = repository)

    @Provides
    fun provideGetCoinInfoUseCase(repository: CoinRepository): GetCoinInfoUseCase =
        GetCoinInfoUseCaseImpl(repository = repository)

    @Provides
    fun provideLoadDataUseCase(repository: CoinRepository): LoadDataUseCase =
        LoadDataUseCaseImpl(repository = repository)
}