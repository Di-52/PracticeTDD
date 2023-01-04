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


    }

/*
    class Base<T, R>() : CustomObservable<CustomObject,CustomObserver<CustomObject>> {
        private val premiumListeners = mutableListOf<CustomObserver.Premium<CustomObject>>()
        private val usualListeners = mutableListOf<CustomObserver.Usual<CustomObject>>()

        override fun addObserver(observer: CustomObserver.Premium<CustomObject>) {
            premiumListeners.add(observer)
        }

        override fun addObserver(observer: CustomObserver.Usual<CustomObject>) {
            usualListeners.add(observer)
        }

        override fun update(obj: CustomObject.Premium) {
            premiumListeners.forEach {
                it.update(obj)
            }
        }

        override fun update(obj: CustomObject.Usual) {
            usualListeners.forEach { it.update(obj) }
            premiumListeners.forEach { it.update(obj) }
        }
    }*/
}