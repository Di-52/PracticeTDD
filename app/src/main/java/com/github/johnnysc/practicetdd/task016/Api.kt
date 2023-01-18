package com.github.johnnysc.practicetdd.task016

/**
 * @author Demitrist on 08.01.2023
 **/

interface Api {

    fun fetch(body: Api.RequestBody, callback: Api.Callback)

    interface RequestBody {

        fun isEmpty(): Boolean

        class Base(private val body: String) : RequestBody {
            override fun isEmpty(): Boolean = body.isNotEmpty()
        }
    }

    interface Callback {
        fun provideSuccess(data: Result)
        fun provideError(data: Result)
    }

    interface Mapper<String> {
        fun map(): String
    }

    interface Result : Mapper<String> {
        data class Success(private val data: String) : Result {
            override fun map() = data
        }

        data class Error(private val e: Exception) : Result {
            override fun map() = e.message.toString()
        }
    }
}