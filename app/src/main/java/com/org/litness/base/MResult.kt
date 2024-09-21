package com.org.litness.base

sealed class MResult<out T> {
    data class Success<T>(val data: T? = null): MResult<T>()
    data class Error<T>(val msg: String): MResult<T>()
}