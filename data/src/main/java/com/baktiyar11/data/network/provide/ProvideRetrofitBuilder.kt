package com.baktiyar11.data.network.provide

import retrofit2.Retrofit

interface ProvideRetrofitBuilder {
    fun provideRetrofitBuilder(): Retrofit.Builder
}