package com.baktiyar11.domain.base

interface Mapper<From, To> {
    fun map(from: From): To
}