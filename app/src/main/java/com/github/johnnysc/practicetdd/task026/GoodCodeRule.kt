package com.github.johnnysc.practicetdd.task026

/**
 * @author Demitrist on 16.01.2023
 **/

fun main() {

    val str = "...place you code here..."
    val inc = GoodCodeRule.Encapsulation()
    println(inc.isValid(str))
}

interface GoodCodeRule {
    fun isValid(text: String): Boolean

    class Encapsulation : GoodCodeRule {
        private val preparationCode = PreparationCode()

        override fun isValid(text: String): Boolean {
            var temp = preparationCode.bracketsClean(text)
            temp = preparationCode.removeValid(temp)
            if (temp.contains(" val ") || temp.contains(" var "))
                temp = preparationCode.functionBlocksClean(temp)

            return !temp.contains(" val ") && !temp.contains(" var ")
        }
    }
}