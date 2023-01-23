package com.github.johnnysc.practicetdd.task008

/**
 * @author Demitrist on 05.01.2023
 */

interface Contains {

    fun contains(collection: List<String>, item: String): Boolean

    class Base(private val forWrapper: For) : Contains {
        override fun contains(collection: List<String>, item: String): Boolean {
            forWrapper.repeat(max = collection.size) {
                return@repeat collection[it] == item
            }
            return false
        }
    }
}