package com.github.johnnysc.practicetdd.task028

/**
 * @author Demitrist on 25.01.2023
 **/

interface GoodCodeRule {

    fun isValid(text: String): Boolean

    class Inheritance : GoodCodeRule {
        override fun isValid(text: String) = ParseType.Base().parse(text).validation()
    }
}


interface ValidationType {

    fun validation(): Boolean

    class Interface() : ValidationType {
        override fun validation(): Boolean = true
    }

    class Clazz(private val text: String) : ValidationType {
        override fun validation(): Boolean = text.contains(':')
    }

    class Abstract(private val text: String) : ValidationType {
        override fun validation(): Boolean {
            val inheritances = text.split(":")
            if (inheritances.size > 1 && inheritances[1].contains("("))
                return (inheritances[1].contains("Activity") || inheritances[1].contains("Fragment"))
            return true
        }
    }
}

interface ParseType {

    fun parse(text: String): ValidationType

    class Base() : ParseType {
        override fun parse(text: String): ValidationType {
            if (text.contains("interface ")) return ValidationType.Interface()
            if (text.contains("abstract "))
                return ValidationType.Abstract(text.substringAfter("abstract "))
            return ValidationType.Clazz(text.substringAfter("class "))
        }
    }
}
