package com.github.johnnysc.practicetdd.task027

/**
 * @author Demitrist on 20.01.2023
 **/

interface MyObserver<T> {

    fun update(value: T)
    fun isEmpty(): Boolean = false

    class Empty<T> : MyObserver<T> {
        override fun update(value: T) = Unit
        override fun isEmpty(): Boolean = true
    }
}