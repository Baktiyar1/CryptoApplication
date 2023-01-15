package com.baktiyar11.data.network.provide

import retrofit2.Converter

interface ProvideConverterFactory {
    fun converterFactory(): Converter.Factory
}