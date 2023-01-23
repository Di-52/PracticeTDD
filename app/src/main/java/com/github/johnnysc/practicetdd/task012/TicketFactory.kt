package com.github.johnnysc.practicetdd.task012

/**
 * @author Demitrist on 03.01.2023
 */

interface TicketFactory {

    fun ticket(number: Int): LotteryTicket

    class Base() : TicketFactory {
        override fun ticket(number: Int): LotteryTicket {
            val strNum = number.toString()
            if (number < 0 || strNum.length % 2 != 0 || strNum.length > 8)
                return LotteryTicket.Fake()
            return LotteryTicket.Ticket(number)
        }
    }
}