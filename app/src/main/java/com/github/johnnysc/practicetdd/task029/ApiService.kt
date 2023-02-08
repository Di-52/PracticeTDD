package com.github.johnnysc.practicetdd.task029

import retrofit2.Response

/**
 * @author Demitrist on 08.02.2023
 **/

interface ApiService {
    suspend fun fetch(): Response<UserCloud>
}