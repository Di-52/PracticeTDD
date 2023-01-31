package com.github.johnnysc.practicetdd.task021

/**
 * @author Demitrist on 01.02.2023
 **/

interface IsEmptyHandleUseCase<U> {

    suspend fun handle(useCase: U): MessageUI

    class Empty<U> : IsEmptyHandleUseCase<U> {
        override suspend fun handle(useCase: U): MessageUI = MessageUI.Empty
    }
}