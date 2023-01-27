package com.github.johnnysc.practicetdd.task023

/**
 * @author Demitrist on 27.01.2023
 **/

data class HandleInteraction(
    private val text: String,
    private val interaction: Interaction,
) : () -> Unit {

    override fun invoke() = interaction.print(text)
}