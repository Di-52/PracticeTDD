package com.github.johnnysc.practicetdd.task010

/**
 * @author Demitrist on 07.01.2023
 **/

interface NewInt {

    fun isValid(number: Int): Boolean

    class Positive(private val int: NewInt = Empty()) : NewInt {
        override fun isValid(number: Int): Boolean = number >= 0 && int.isValid(number)
    }

    class Negative(private val int: NewInt = Empty()) : NewInt {
        override fun isValid(number: Int): Boolean = number < 0 && int.isValid(number)
    }

    class Odd(private val int: NewInt = Empty()) : NewInt {
        override fun isValid(number: Int): Boolean = number % 2 != 0 && int.isValid(number)
    }

    class Less(private val limit: Int) : NewInt {
        override fun isValid(number: Int): Boolean = number < limit
    }

    class Empty : NewInt {
        override fun isValid(number: Int): Boolean = true
    }
}