package com.github.johnnysc.practicetdd.task029

/**
 * @author Demitrist on 08.02.2023
 **/

data class ServerException(
    override val message: String?,
    private val errorType: String = "",
) : Exception()
