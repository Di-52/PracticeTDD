package com.github.johnnysc.practicetdd.task021

/**
 * @author Demitrist on 01.02.2023
 **/

interface Parser<U> {

    fun map(data: String): IsEmptyHandleUseCase<U>
}