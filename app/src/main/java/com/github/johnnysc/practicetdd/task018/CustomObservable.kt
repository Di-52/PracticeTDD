package com.github.johnnysc.practicetdd.task018

interface CustomObservable<T, R : CustomObserver<T>> {

    fun addObserver(observer: R)
    fun removeObserver(observer: R)
    fun update(argument: T)

    class Base<T, R>(private val maxCount: Int) : CustomObservable<T, CustomObserver<T>> {
        private val listeners = mutableListOf<CustomObserver<T>>()

        override fun addObserver(observer: CustomObserver<T>) {
            listeners.add(observer)
        }

        override fun removeObserver(observer: CustomObserver<T>) {
            listeners.remove(observer)
        }

        override fun update(argument: T) {
            listeners.takeLast(maxCount).forEach {
                it.update(argument)
            }
        }
    }
}