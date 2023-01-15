package com.baktiyar11.data.network.provide

class MakeServiceImpl(private val retrofitBuilder: ProvideRetrofitBuilder) : MakeService {

    private val retrofit by lazy(LazyThreadSafetyMode.NONE) {
        retrofitBuilder.provideRetrofitBuilder().baseUrl(BASE_URL).build()
    }

    override fun <T> service(classZ: Class<T>): T = retrofit.create(classZ)

    companion object {
        private const val BASE_URL = "https://min-api.cryptocompare.com/data/"
    }
}