package com.github.johnnysc.practicetdd.task021

/**
 * @author Demitrist on 01.02.2023
 **/

interface Command<I, U> {

    fun canHandle(message: String): Boolean
    suspend fun handle(useCase: U): MessageUI

    abstract class Abstract<I, U>(private val parser: Parser<U>) : Command<I, U> {
        private var msg: String = ""

        override fun canHandle(message: String): Boolean {
            msg = message
            return message.isNotEmpty()
        }

        override suspend fun handle(useCase: U): MessageUI {
            return parser.map(msg).handle(useCase)
        }
    }
}