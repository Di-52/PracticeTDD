package com.github.johnnysc.practicetdd.task026

/**
 * @author Demitrist on 15.01.2023
 **/

interface GoodCodeRule {

    fun isValid(text: String):Boolean

    class Incapsulation : GoodCodeRule {
        override fun isValid(text: String): Boolean =
            !text.contains(Regex("""(?<!(protected|private)\s)(val|var)"""))
    }
}