package com.github.johnnysc.practicetdd.task014

/**
 * @author Demitrist on 07.01.2023
 **/

interface Numbers {

    fun isSumLong(): Boolean
    fun sumLong(): Long
    fun sumInt(): Int
    fun difference(): Int
    fun divide(): Double

    class Base(private val number1: Int, private val number2: Int) : Numbers {
        private var isNotCheced: Boolean = true
        private var isLong: Boolean = false

        override fun isSumLong(): Boolean {
            val r: Long = number1.toLong() + number2.toLong()
            isLong = r !in Int.MIN_VALUE..Int.MAX_VALUE
            isNotCheced = false
            return isLong
        }

        override fun sumLong(): Long {
            if (isNotCheced) throw IllegalAccessException()
            if (!isLong) throw IllegalStateException()
            return number1.toLong() + number2.toLong()
        }

        override fun sumInt(): Int {
            if (isNotCheced) throw IllegalAccessException()
            if (isLong) throw IllegalStateException()
            return number1 + number2
        }

        override fun divide(): Double {
            if (number2 == 0) throw IllegalArgumentException()
            return number1 / number2.toDouble()
        }

        override fun difference(): Int = number1 - number2
    }
}