package com.github.johnnysc.practicetdd.task027

/**
 * @author Demitrist on 20.01.2023
 **/

interface MyObservable<T> {

    fun update(data: T)
    fun observer(observer: MyObserver<T>)
    fun notifyChanges()

    class Base<T> : MyObservable<T> {
        private var myObserver: MyObserver<T> = MyObserver.Empty()
        private var value: T? = null

        override fun update(data: T) {
            value = data
            myObserver.update(data)
        }

        override fun observer(observer: MyObserver<T>) {
            myObserver = observer
        }

        override fun notifyChanges() {
            value?.let {
                myObserver.update(it)
            }
        }
    }

    class SingleLiveEvent<T> : MyObservable<T> {
        private var myObserver: MyObserver<T> = MyObserver.Empty()
        private var value: T? = null

        override fun update(data: T) {
            if (myObserver.isEmpty()) {
                value = data
            } else {
                myObserver.update(data)
            }
        }

        override fun observer(observer: MyObserver<T>) {
            myObserver = observer
        }

        override fun notifyChanges() {
            value?.let {
                myObserver.update(it)
                value = null
            }
        }
    }


}