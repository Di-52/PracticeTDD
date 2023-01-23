package com.github.johnnysc.practicetdd.task020

/**
 * @author Demitrist on 04.01.2023
 */

interface FeatureChain {

    interface Handle {
        suspend fun handle(message: String): MessageUI
    }

    interface Check {
        fun canHandle(message: String): Boolean
    }

    interface CheckAndHandle : Check, Handle

}