package com.github.johnnysc.practicetdd.task023

/**
 * @author Demitrist on 27.01.2023
 **/

data class LegacyObject(private val text: String, private val lambda: () -> Unit) {
    fun go() = lambda.invoke()
}