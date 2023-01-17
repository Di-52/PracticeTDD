package com.github.johnnysc.practicetdd.task026

/**
 * @author Demitrist on 16.01.2023
 **/

fun main() {

    var str = "...place you code here..."
    val inc = GoodCodeRule.Incapsulation()
    println(inc.isValid(str))
}

interface GoodCodeRule {
    fun isValid(text: String): Boolean

    class Incapsulation : GoodCodeRule {
        override fun isValid(text: String): Boolean {
            var temp = text
                .replace("(", " ")
                .replace(")", " ")
                .replace("private va", "")
                .replace("protected va", "")
                .replace("protected abstract va", "")
            if (temp.contains(" val ") || temp.contains(" var "))
                while (temp.contains("fun")) {
                    var positionStart = temp.indexOf("fun")
                    var positionEnd = positionStart + 3
                    var pointer = temp.indexOf("{", positionStart)
                    var pointerClass = temp.indexOf(" class ", positionEnd)
                    var pointerInterface = temp.indexOf(" interface ", positionEnd)
                    var pointerFun = temp.indexOf(" fun ", positionEnd)
                    if ((pointer < pointerClass || pointerClass < 0)
                        && (pointer < pointerInterface || pointerInterface < 0)
                        && (pointer < pointerFun || pointerFun < 0)
                    ) {
                        var bracketCount = 1
                        while (bracketCount > 0) {
                            pointer++
                            if (temp[pointer] == '{') bracketCount++
                            if (temp[pointer] == '}') bracketCount--
                        }
                        temp = temp.removeRange(positionStart, pointer)
                    } else {
                        temp = temp.removeRange(positionStart, positionEnd)
                    }
                }
            return !temp.contains(" val ") && !temp.contains(" var ")
        }
    }
}