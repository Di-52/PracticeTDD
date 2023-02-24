package com.github.johnnysc.practicetdd.task025

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

/**
 * @author Demitrist on 14.02.2023
 **/

interface Communication {

    fun map(data: List<MessageUi>)
    fun observe(owner: LifecycleOwner, observer: Observer<List<MessageUi>>)
}