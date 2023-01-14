package com.github.johnnysc.practicetdd.task012

/**
 * @author Demitrist on 03.01.2023
 */

interface LotteryTicket {

    fun isWinner(): Boolean
    fun isFake(): Boolean

    class Ticket(private val number: Int) : LotteryTicket {
        override fun isWinner(): Boolean {
            val strNum = number.toString()
            var left = 0
            var right = 0
            strNum.toCharArray().forEachIndexed { index, c ->
                if (index < strNum.count() / 2) left += c.toString().toInt()
                else right += c.toString().toInt()
            }
            return left == right
        }

        override fun isFake(): Boolean = false
    }

    class Fake() : LotteryTicket {
        override fun isWinner(): Boolean = false
        override fun isFake(): Boolean = true
    }
}