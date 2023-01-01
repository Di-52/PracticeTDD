package com.github.johnnysc.practicetdd.task013

/**
 * @author Asatryan on 26.12.2022
 */
interface Now {

    fun time(): Long

    class Base : Now {
        override fun time(): Long = System.currentTimeMillis()
    }
}