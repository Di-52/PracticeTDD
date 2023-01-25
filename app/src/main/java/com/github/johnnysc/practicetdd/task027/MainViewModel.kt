package com.github.johnnysc.practicetdd.task027

/**
 * @author Demitrist on 20.01.2023
 **/

class MainViewModel(private val liveData: MyObservable<String>) {

    private var count = 0

    fun updateObserver(observer: MyObserver<String>){
        liveData.observer(observer)
    }

    fun notifyChanges() {
        liveData.notifyChanges()
    }

    fun go(){
        count++
        liveData.update(count.toString())
    }


}