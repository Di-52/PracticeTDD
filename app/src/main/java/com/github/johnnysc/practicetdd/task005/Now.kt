package com.github.johnnysc.practicetdd.task005

/**
 * @author Demitrist on 06.01.2023
 */

interface Now {

    fun now(): Long

    class Base() : Now {
        private val timeStart = System.currentTimeMillis()
        override fun now(): Long = System.currentTimeMillis() - timeStart
    }
}