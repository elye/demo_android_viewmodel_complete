package com.elyeproj.simpleviewmodel.koin

import androidx.lifecycle.SavedStateHandle
import com.elyeproj.simpleviewmodel.Repository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val KoinModule =
    module {
        single { Repository() }
        viewModel { (handle: SavedStateHandle) ->
            MyViewModel(
                handle,
                get()
            )
        }
    }
