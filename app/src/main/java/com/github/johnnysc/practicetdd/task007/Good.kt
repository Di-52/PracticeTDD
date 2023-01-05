package com.github.johnnysc.practicetdd.task007

/**
 * @author Demitrist on 05.01.2023
 */

interface Good {

    interface Mapper<T> {
        fun map(ram: Int, os: OS, displaySize: Double, processor: ProcessorType, price: Double): T
    }

    fun <T> map(mapper: Mapper<T>): T

    class Base(
        private val ram: Int,
        private val os: OS,
        private val displaySize: Double,
        private val processorType: ProcessorType,
        private val price: Double,
    ) : Good {

        override fun <T> map(mapper: Mapper<T>): T = mapper.map(
            ram = ram,
            os = os,
            displaySize = displaySize,
            processor = processorType,
            price = price)
    }
}