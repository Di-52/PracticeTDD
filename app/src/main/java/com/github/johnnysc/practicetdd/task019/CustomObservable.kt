package com.github.johnnysc.practicetdd.task019


/**
 * @author Demitrist on 03.01.2023
 */

interface CustomObservable<T : CustomObject, R : CustomObserver<T>> {

    fun addObserver(observer: CustomObserver.Usual<T>)
    fun addObserver(observer: CustomObserver.Premium<T>)

    fun update(obj: CustomObject.Premium)
    fun update(obj: CustomObject.Usual)

    class Base<T : CustomObject, R : CustomObserver<T>> : CustomObservable<T, R> {
        private val premiumListeners = mutableListOf<CustomObserver.Premium<T>>()
        private val usualListeners = mutableListOf<CustomObserver.Usual<T>>()

        override fun addObserver(observer: CustomObserver.Usual<T>) {
            usualListeners.add(observer)
        }

        override fun addObserver(observer: CustomObserver.Premium<T>) {
            premiumListeners.add(observer)
        }

        override fun update(obj: CustomObject.Premium) {
            premiumListeners.forEach { it.update(obj as T) }
        }

        override fun update(obj: CustomObject.Usual) {
            premiumListeners.forEach { it.update(obj as T) }
            usualListeners.forEach { it.update(obj as T) }
        }
    }
}