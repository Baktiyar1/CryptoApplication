package com.baktiyar11.data.network.provide

interface MakeService {
    fun <T> service(classZ: Class<T>): T
}