package com.github.johnnysc.practicetdd.task025

/**
 * @author Demitrist on 14.02.2023
 **/

interface MessageUi {

    data class Base(private var id: Int, private var text: String) : MessageUi
    object LoadMore : MessageUi
    object LoadPrevious : MessageUi
}