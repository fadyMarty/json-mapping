package com.fadymarty.jsonmapping.common.util

suspend fun <T> safeCall(
    execute: suspend () -> T,
): Result<T> {
    try {
        val response = execute()
        return Result.success(response)
    } catch (e: Exception) {
        return Result.failure(e)
    }
}