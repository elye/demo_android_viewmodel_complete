package com.elyeproj.simpleviewmodel.daggerandroid

import com.elyeproj.simpleviewmodel.MainApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ApplicationModule::class,
    MyViewModelAndroidDaggerActivityModule::class
])
interface ApplicationComponent : AndroidInjector<MainApplication> {
    @Component.Factory
    interface Factory : AndroidInjector.Factory<MainApplication>
}
