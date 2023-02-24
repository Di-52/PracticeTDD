package com.github.johnnysc.practicetdd.task030

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan

/**
 * @author Demitrist on 05.02.2023
 **/

interface MarkDown {

    fun parse(string: String): ResultItem

    interface Parser : MarkDown {

        abstract class Abstract(
            private val colorHex: String,
            private val delimiter: String,
        ) : Parser {

            override fun parse(string: String): ResultItem {
                val resultItems: MutableList<ResultItem.StringAndIndex> = mutableListOf()
                var finalString = string
                while (finalString.substringAfter(delimiter).contains(delimiter)) {
                    val part = finalString.substringAfter(delimiter).substringBefore(delimiter)
                    if (part.isNotEmpty()) resultItems.add(ResultItem.StringAndIndex(string = part,
                        index = finalString.indexOf(delimiter + part + delimiter)))
                    finalString = finalString
                        .replaceFirst(delimiter, "")
                        .replaceFirst(delimiter, "")
                }
                return ResultItem.Base(colorHex, finalString, resultItems.toList())
            }
        }

        class Base(colorHex: String, delimiter: String) : Abstract(colorHex, delimiter)
        class OneSignDelimiter(colorHex: String, delimiter: Char) :
            Abstract(colorHex, delimiter.toString())
    }

    interface ResultItem {

        fun formattedText(): CharSequence

        interface Mapper {
            fun map(colorHex: String, text: Spannable)
        }

        data class Base(
            private val colorHex: String,
            private val text: String,
            private val parts: List<StringAndIndex>,
        ) : ResultItem {

            override fun formattedText(): CharSequence {
                val resultText = SpannableString(text)
                parts.forEach { part ->
                    part.map(colorHex, resultText)
                }
                return resultText
            }
        }

        data class StringAndIndex(private val string: String, private val index: Int) :
            Mapper {

            override fun map(colorHex: String, text: Spannable) {
                text.setSpan(
                    ForegroundColorSpan(Color.parseColor(colorHex)),
                    index,
                    index + string.length,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
        }
    }
}