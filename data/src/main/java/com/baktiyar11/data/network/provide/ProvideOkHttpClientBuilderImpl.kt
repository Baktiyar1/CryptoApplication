package com.baktiyar11.data.network.provide

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class ProvideOkHttpClientBuilderImpl(
    private val provideInterceptor: ProvideInterceptor, private val timeOutSeconds: Long = 600L,
) : ProvideOkHttpClientBuilder {
    override fun httpOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(provideInterceptor.requestInterceptor())
            .addInterceptor(provideInterceptor.loggingInterceptor())
            .connectTimeout(timeOutSeconds, TimeUnit.SECONDS)
            .readTimeout(timeOutSeconds, TimeUnit.SECONDS).build()
}