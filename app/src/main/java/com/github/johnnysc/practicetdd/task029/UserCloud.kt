package com.github.johnnysc.practicetdd.task029

/**
 * @author Demitrist on 08.02.2023
 **/

interface UserCloud {
    data class Base(private val name: String, private val id: Int) : UserCloud
}