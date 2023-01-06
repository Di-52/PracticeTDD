package com.github.johnnysc.practicetdd.task007

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/**
 * @author Demitrist on 05.01.2023
 */

interface Communication<T> {

    fun observe(owner: LifecycleOwner, observer: Observer<T>)
    fun map(source: T)

    class Base<T>(private val data: MutableLiveData<T>) : Communication<T> {
        override fun observe(owner: LifecycleOwner, observer: Observer<T>) {
            data.observe(owner,observer)
        }

        override fun map(source: T) {
            data.value = source
        }
    }
}