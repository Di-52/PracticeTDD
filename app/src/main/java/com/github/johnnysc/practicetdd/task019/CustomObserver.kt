package com.github.johnnysc.practicetdd.task019

/**
 * @author Demitrist on 03.01.2023
 */

interface CustomObserver<T> {

    fun update(obj: T)

    open class Premium<T : CustomObject> : CustomObserver<T> {
        private lateinit var data: T

        override fun update(obj: T) {
            data = obj
        }
    }

    open class Usual<T : CustomObject> : CustomObserver<T> {
        private lateinit var data: T

        override fun update(obj: T) {
            data = obj
        }
    }
}