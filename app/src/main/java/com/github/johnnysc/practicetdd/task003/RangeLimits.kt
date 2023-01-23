package com.github.johnnysc.practicetdd.task003

interface RangeLimits {

    fun pair(number: Int): RangePair

    class Base(private val list: List<Int>) : RangeLimits {

        override fun pair(number: Int): RangePair {
            var left: Int = Int.MIN_VALUE
            var right: Int = Int.MAX_VALUE
            if (list.isNotEmpty()) {
                list.forEach {
                    if (left < it && it < number) left = it
                    if (right > it && it > number) right = it
                }
            }
            return RangePair(left, right)
        }
    }


}