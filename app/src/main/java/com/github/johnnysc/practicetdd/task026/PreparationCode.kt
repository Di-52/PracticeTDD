package com.github.johnnysc.practicetdd.task026

/**
 * @author Demitrist on 17.01.2023
 **/

class PreparationCode : CleanBrackets, CleanFunctions, ValidVariables {

    override fun bracketsClean(input: String): String =
        input.replace("(", " ").replace(")", " ")

    override fun removeValid(input: String): String =
        input.replace("private va", "")
            .replace("protected va", "")
            .replace("protected abstract va", "")

    override fun functionBlocksClean(input: String): String {
        var temp = input
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
        return temp
    }
}