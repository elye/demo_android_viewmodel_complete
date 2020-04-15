package com.elyeproj.simpleviewmodel

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor() {
    fun getMessage() = "From Repository"
}
