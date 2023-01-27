package com.github.johnnysc.practicetdd.task023

/**
 * @author Demitrist on 27.01.2023
 **/

class Legacy(private val text: String, private val interaction: Interaction) {
    fun map(): LegacyObject = LegacyObject(text, HandleInteraction(text, interaction))
}