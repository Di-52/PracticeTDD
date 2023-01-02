package com.github.johnnysc.practicetdd

import androidx.core.text.isDigitsOnly
import kotlin.jvm.internal.Intrinsics.Kotlin
import kotlin.math.pow

interface ParserHandler {
    fun handle(): Any
}

interface ParserChainFragment : ParserHandler {
    fun canHandle(): Boolean
}

class ParserChainLink(
    private val chain: ParserChainFragment,
    private val nextChain: ParserHandler
) : ParserHandler {

    override fun handle(): Any = if (chain.canHandle())
        chain.handle()
    else
        nextChain.handle()
}

class EmptyParser : ParserChainFragment {
    override fun canHandle(): Boolean = true
    override fun handle(): Any {
        throw IllegalAccessException("This line is unreachable.")
    }
}

class BoolenParser(
    private val part: String
) : ParserChainFragment {
    override fun canHandle(): Boolean = part == "true" || part == "false"
    override fun handle(): Any = part == "true"
}

class CharParser(
    private val part: String
) : ParserChainFragment {
    override fun canHandle(): Boolean = part.length == 1
    override fun handle(): Any = part[0]
}

class StringParser(
    private val part: String
) : ParserChainFragment {
    override fun canHandle(): Boolean = true
    override fun handle(): Any = part
}

class NumberParser(
    private val part: String
) : ParserChainFragment {
    override fun canHandle(): Boolean =
        part.replace("-", "")
            .replace(".", "")
            .replace("f", "")
            .isDigitsOnly()

    override fun handle(): Any {
        val presentNumber = PresentNumber.Base(part)
        return presentNumber.number()
    }
}

interface PresentNumber {

    fun number(): Number

    class Base(private val part: String) : PresentNumber {
        private val isNegative = part.contains('-')
        private val isFloat = part.contains('.') || part.contains('f')
        private val raw = part.replace("f", "").replace("-", "")
        private val integerPart = mutableListOf<Int>()
        private val floatPart = mutableListOf<Int>()

        init {
            var pointer = integerPart
            raw.toCharArray().forEach {
                when (it) {
                    '1' -> pointer.add(1)
                    '2' -> pointer.add(2)
                    '3' -> pointer.add(3)
                    '4' -> pointer.add(4)
                    '5' -> pointer.add(5)
                    '6' -> pointer.add(6)
                    '7' -> pointer.add(7)
                    '8' -> pointer.add(8)
                    '9' -> pointer.add(9)
                    '0' -> pointer.add(0)
                    '.' -> pointer = floatPart
                }
            }
        }

        override fun number(): Number {
            return 0
        }
    }
}

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
                if (it.isNotEmpty()) result.add(
                    ParserChainLink(
                        CharParser(it),
                        ParserChainLink(
                            BoolenParser(it),
                            ParserChainLink(
                                NumberParser(it),
                                ParserChainLink(
                                    StringParser(it),
                                    EmptyParser()
                                )
                            )
                        )
                    ).handle()
                )
            }
            return result
        }
    }
}