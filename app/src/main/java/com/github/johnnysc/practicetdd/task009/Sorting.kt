package com.github.johnnysc.practicetdd.task009

/**
 * @author Demitrist on 05.01.2023
 */

interface Sorting {

    fun sort(list: List<Int>): List<Int>

    class Base(private val forOut: For, private val forIn: For) : Sorting {

        override fun sort(list: List<Int>): List<Int> {
            val result: MutableList<Int> = list.toMutableList()
            var mutations = 0
            var temp = 0
            forOut.repeat(start = 0, max = list.size) {
                mutations = 0
                forIn.repeat(start = 1, max = list.size) {
                    if (result[it] < result[it - 1]) {
                        mutations++
                        temp = result[it]
                        result[it] = result[it - 1]
                        result[it - 1] = temp
                    }
                    it == list.size
                }
                mutations == 0
            }
            return result
        }
    }
}