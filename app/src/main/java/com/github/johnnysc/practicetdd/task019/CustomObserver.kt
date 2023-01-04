package com.github.johnnysc.practicetdd.task019

/**
 * @author Demitrist on 03.01.2023
 */

interface CustomObserver<T : CustomObject> {

    fun update(obj: CustomObject.Premium)
    fun update(obj: CustomObject.Usual)

    open class Premium<T> : CustomObserver<CustomObject.Premium> {
        override fun update(obj: CustomObject.Premium) {
            TODO("Not yet implemented")
        }

        override fun update(obj: CustomObject.Usual) {
            TODO("Not yet implemented")
        }

    }

    open class Usual<T> : CustomObserver<CustomObject.Usual> {
        override fun update(obj: CustomObject.Usual) {

        }
    }

}