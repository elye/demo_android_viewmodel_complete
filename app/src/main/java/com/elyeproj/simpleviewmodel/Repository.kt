package com.elyeproj.simpleviewmodel

import javax.inject.Inject

class Repository @Inject constructor() {
    fun getMessage() = "From Repository"
}
