package com.github.johnnysc.practicetdd.task029

/**
 * @author Demitrist on 08.02.2023
 **/

interface CloudDataSource {

    suspend fun fetch(): UserCloud

    class Base(private val apiService: ApiService) : CloudDataSource {
        override suspend fun fetch(): UserCloud {
            val result = apiService.fetch()
            when (result.code()) {
                200 -> return result.body()!!
                401 -> throw ServerException(message = "Unauthorized user",
                    errorType = "UNAUTHORIZED")
                else -> throw ServerException(message = "not found")
            }
        }
    }
}