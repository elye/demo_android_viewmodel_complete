package com.elyeproj.simpleviewmodel

import androidx.lifecycle.SavedStateHandle
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val KoinModule =
    module {
        single { Repository() }
        viewModel { (handle: SavedStateHandle) -> MyViewModel(handle, get()) }
    }
