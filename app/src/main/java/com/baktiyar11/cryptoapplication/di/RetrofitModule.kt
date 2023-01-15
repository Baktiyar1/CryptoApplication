package com.baktiyar11.cryptoapplication.di

import com.baktiyar11.data.network.api.ApiService
import com.baktiyar11.data.network.provide.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    fun provideMakeService(retrofitBuilder: ProvideRetrofitBuilder): MakeService =
        MakeServiceImpl(retrofitBuilder = retrofitBuilder)

    @Provides
    fun provideService(makeService: MakeService): ApiService =
        makeService.service(ApiService::class.java)

    @Provides
    fun provideProvideConverterFactory(): ProvideConverterFactory = ProvideConverterFactoryImpl()

    @Provides
    fun provideProvideInterceptor(): ProvideInterceptor = ProvideInterceptorImpl.Debug()

    @Provides
    fun provideProvideOkHttpClientBuilder(provideInterceptor: ProvideInterceptor)
            : ProvideOkHttpClientBuilder = ProvideOkHttpClientBuilderImpl(
        provideInterceptor = provideInterceptor, timeOutSeconds = 600L
    )

    @Provides
    fun provideProvideRetrofitBuilder(
        provideConverterFactory: ProvideConverterFactory,
        provideOkHttpClientBuilder: ProvideOkHttpClientBuilder,
    ): ProvideRetrofitBuilder = ProvideRetrofitBuilderImpl(
        provideConverterFactory = provideConverterFactory,
        provideOkHttpClientBuilder = provideOkHttpClientBuilder
    )
}