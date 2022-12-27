package com.github.johnnysc.practicetdd

import kotlin.math.pow

interface Parser {

    fun parse(raw: String): List<Any>

    class Base(private val delimiter: String) : Parser {
        init {
            if (delimiter.isEmpty())
                throw IllegalStateException("Empty delimiter!")
        }

        override fun parse(raw: String): List<Any> {
            val result: MutableList<Any> = mutableListOf()
            if (raw.isEmpty()) return result
            val parts: List<String> = raw.split(delimiter)
            parts.forEach {
                if (it.isNotEmpty()) result.add(parsPart(it))
            }
            return result
        }

        private fun parsPart(part: String): Any {
            if (part.length == 1) {
                val c = part.single()
                if (c in '0'..'9')
                    return c as Byte
                return c
            }
            when (part) {
                "false" -> return false
                "true" -> return true
            }
            if (isNumber(part)) return parseNumber(part)
            return part
        }

        private fun isNumber(s: String): Boolean {
            s.forEach {
                if (!isDigit(it) && it != '-' && it != '.' && it != 'f') return false
            }
            return true
        }

        private fun isDigit(c: Char): Boolean = if (c in '0'..'9') true else false

        private fun parseNumber(s: String): Number {
            var intResult: Long = 0
            var floatResult: Double = 0.0
            val isFloat = s.contains('.') || s.length > 18

            val intPart = (if (isFloat) s.split('.')[0] else s).reversed()
            if (!isFloat){
                intPart.toCharArray().forEachIndexed { index, c ->
                    intResult += getDigit(c) * Math.round(10.0.pow(index * 1.0))
                }
                if (intPart.contains('-')) intResult *= -1
                when (intResult){
                    in Byte.MIN_VALUE..Byte.MAX_VALUE -> return intResult.toByte()
                    in Short.MIN_VALUE..Short.MAX_VALUE -> return intResult.toShort()
                    in Int.MIN_VALUE..Int.MAX_VALUE -> return intResult.toInt()
                    else -> return intResult
                }
            }
            else {
                intPart.toCharArray().forEachIndexed { index, c ->
                    floatResult += getDigit(c) * 10.0.pow(index * 1.0)
                }
                if (s.contains('.')) {
                    var floatPart = s.split('.')[1].reversed()
                    floatPart.toCharArray().forEachIndexed { index, c ->
                        floatResult += getDigit(c) * 0.1.pow(index * 1.0)
                    }
                }
                floatResult += intResult
                when(floatResult){
                    in Float.MIN_VALUE..Float.MAX_VALUE -> return floatResult.toFloat()
                    else -> return floatResult
                }
            }

        }

        private fun getDigit(c: Char): Int =
            when (c) {
                '0' -> 0
                '1' -> 1
                '2' -> 2
                '3' -> 3
                '4' -> 4
                '5' -> 5
                '6' -> 6
                '7' -> 7
                '8' -> 8
                '9' -> 9
                else -> 0
            }
    }
}