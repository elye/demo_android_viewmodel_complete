package com.elyeproj.simpleviewmodel.daggerandroid

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MyViewModelAndroidDaggerActivityModule {
    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeHomeActivity(): MyViewModelAndroidDaggerActivity

}
