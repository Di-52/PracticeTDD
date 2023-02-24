package com.github.johnnysc.practicetdd.task025

/**
 * @author Demitrist on 14.02.2023
 **/

class PagingViewModel(
    private val repository:PagingRepository,
    private val communication:Communication
) {

    fun init(isFirstRun:Boolean){
        if(isFirstRun){
            val result = repository.messages(PagingRepository.Strategy.INIT)
            val res = mutableListOf<MessageUi>()

            result.forEach {
                res.add(it.map())
            }
            communication.map(res)
        }
    }

    fun loadMore(){
        val result = repository.messages(PagingRepository.Strategy.NEXT)
        val res = mutableListOf<MessageUi>()

        result.forEach {
            res.add(it.map())
        }
        communication.map(res)
    }

    fun loadPrevious(){
        val result = repository.messages(PagingRepository.Strategy.PREVIOUS)
        val res = mutableListOf<MessageUi>()

        result.forEach {
            res.add(it.map())
        }
        communication.map(res)
    }

}