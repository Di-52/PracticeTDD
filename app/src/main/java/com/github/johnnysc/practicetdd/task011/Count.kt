package com.github.johnnysc.practicetdd.task011

interface Count {

    fun click()

    interface Callback {
        fun provide(value: String)
    }

    class Base(private val callaback: Callback) : Count {
        private var clickCount: Int = 0

        override fun click() = callaback.provide((++clickCount).toString())
    }
}