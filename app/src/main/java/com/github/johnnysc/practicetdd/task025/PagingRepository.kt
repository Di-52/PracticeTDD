package com.github.johnnysc.practicetdd.task025

/**
 * @author Demitrist on 14.02.2023
 **/

interface PagingRepository {

    fun messages(strategy: Strategy): List<MessageDomain>

    interface Strategy{
        object INIT:Strategy
        object NEXT:Strategy
        object PREVIOUS:Strategy
    }
}