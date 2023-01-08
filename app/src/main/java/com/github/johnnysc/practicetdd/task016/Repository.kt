package com.github.johnnysc.practicetdd.task016

/**
 * @author Demitrist on 08.01.2023
 **/

interface Repository {

    fun fetch(body: String, callback: DataCallback)

    interface DataCallback {
        fun provideSuccess(data: String)
        fun provideError(message: String)
    }

    class Base(private val api: Api) : Repository {
        override fun fetch(body: String, callback: DataCallback) {
            api.fetch(Api.RequestBody.Base(body), object : Api.Callback {
                override fun provideSuccess(data: Api.Result) {
                    callback.provideSuccess(data = data.map())
                }

                override fun provideError(data: Api.Result) {
                    callback.provideError(message = data.map())
                }
            })
        }
    }
}