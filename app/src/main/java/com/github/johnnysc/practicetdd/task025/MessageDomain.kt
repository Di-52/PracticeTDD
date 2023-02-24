package com.github.johnnysc.practicetdd.task025

/**
 * @author Demitrist on 14.02.2023
 **/

interface MessageDomain {

    fun map():MessageUi

    data class Base(private var id: Int, private var text: String) : MessageDomain {
        override fun map(): MessageUi {
            return MessageUi.Base(id,text)
        }
    }

    object LoadPrevious : MessageDomain {
        override fun map()=MessageUi.LoadPrevious
    }

    object LoadMore : MessageDomain {
        override fun map() = MessageUi.LoadMore
    }
}