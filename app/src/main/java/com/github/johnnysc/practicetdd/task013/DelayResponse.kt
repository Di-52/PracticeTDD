package com.github.johnnysc.practicetdd.task013

import kotlinx.coroutines.delay

interface DelayResponse {

    suspend fun <T> delayAfter(delayInMillis: Long, block: suspend () -> T): T

    class Base(private val now: Now) : DelayResponse {

        override suspend fun <T> delayAfter(delayInMillis: Long, block: suspend () -> T): T {
            val timeBefore = now.time()
            val result = block.invoke()
            val timeAfter = now.time()
            val deltaTime = timeAfter - timeBefore
            if (deltaTime < delayInMillis) delay(delayInMillis - deltaTime + 5)
            return result
        }
    }
}