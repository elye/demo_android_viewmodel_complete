package com.elyeproj.simpleviewmodel.daggerbasic

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface BasicComponent {
    fun inject(viewModel: MyViewModel)
}
