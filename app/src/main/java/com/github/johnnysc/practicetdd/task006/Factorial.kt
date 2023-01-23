package com.github.johnnysc.practicetdd.task006

import java.math.BigInteger

/**
 * @author Demitrist on 07.01.2023
 **/

interface Factorial<T> {

    fun value(item: T): T

    class Int : Factorial<kotlin.Int> {
        override fun value(item: kotlin.Int): kotlin.Int =
            if (item < 2) 1 else item * Int().value(item - 1)
    }

    class Double : Factorial<kotlin.Double> {
        override fun value(item: kotlin.Double): kotlin.Double =
            if (item < 2) 1.0 else item * Double().value(item - 1)
    }

    class BigInteger : Factorial<java.math.BigInteger> {
        override fun value(item: java.math.BigInteger): java.math.BigInteger =
            if (item < BigInteger("2")) java.math.BigInteger.ONE
            else item * BigInteger().value(item - java.math.BigInteger.ONE)
    }

    class Factory(
        private val int: Factorial<kotlin.Int>,
        private val double: Factorial<kotlin.Double>,
        private val bigInteger: Factorial<java.math.BigInteger>,
    ) {
        fun value(number: kotlin.Int): kotlin.Int {
            if (number < 0) throw java.lang.IllegalArgumentException()
            if (number > 11000) throw java.lang.IllegalStateException()

            return if (number < 13) int.value(number)
            else if (number in 13..170) double.value(number.toDouble()).toInt()
            else bigInteger.value(java.math.BigInteger(number.toString())).toInt()
        }
    }
}