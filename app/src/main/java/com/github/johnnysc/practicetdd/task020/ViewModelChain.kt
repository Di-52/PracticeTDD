package com.github.johnnysc.practicetdd.task020

/**
 * @author Demitrist on 04.01.2023
 */

class ViewModelChain(private val featureChain: FeatureChain.CheckAndHandle) : FeatureChain.Handle {
    private lateinit var nextChain: FeatureChain.Handle
    private var nextChainNotSet = true

    fun nextFeatureChain(nextFeatureChain: FeatureChain.Handle) {
        nextChain = nextFeatureChain
        nextChainNotSet = false
    }

    override suspend fun handle(message: String): MessageUI =
        if (featureChain.canHandle(message = message))
            featureChain.handle(message = message)
        else if (nextChainNotSet)
            MessageUI.Empty
        else nextChain.handle(message)
}