package com.baktiyar11.data.network.provide

import okhttp3.OkHttpClient

interface ProvideOkHttpClientBuilder {
    fun httpOkHttpClient(): OkHttpClient
}