package com.github.johnnysc.practicetdd.task007

/**
 * @author Demitrist on 05.01.2023
 */

interface GoodFilter: Good.Mapper<Boolean> {

    abstract class Abstract() : GoodFilter

    class Os(private val filterOs: OS) : Abstract() {
        override fun map(
            ram: Int,
            os: OS,
            displaySize: Double,
            processor: ProcessorType,
            price: Double,
        ): Boolean = filterOs == os
    }

    class Ram(private val filterRam: Int) : Abstract() {
        override fun map(
            ram: Int,
            os: OS,
            displaySize: Double,
            processor: ProcessorType,
            price: Double,
        ): Boolean = filterRam == ram
    }

    class DisplaySize(private val filterDisplay: Double) : Abstract() {
        override fun map(
            ram: Int,
            os: OS,
            displaySize: Double,
            processor: ProcessorType,
            price: Double,
        ): Boolean = filterDisplay == displaySize
    }

    class Processor(private val filterProcessorType: ProcessorType) : Abstract() {
        override fun map(
            ram: Int,
            os: OS,
            displaySize: Double,
            processor: ProcessorType,
            price: Double,
        ): Boolean = filterProcessorType == processor
    }

    class PriceUnder(private val filterPrice: Double) : Abstract() {
        override fun map(
            ram: Int,
            os: OS,
            displaySize: Double,
            processor: ProcessorType,
            price: Double,
        ): Boolean = price < filterPrice
    }
}