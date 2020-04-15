package com.elyeproj.simpleviewmodel.daggerandroid

import androidx.lifecycle.SavedStateHandle
import com.elyeproj.simpleviewmodel.Repository
import javax.inject.Inject

class MyViewModelFactory @Inject constructor(
    private val repository: Repository
) : ViewModelAssistedFactory<MyViewModel> {
    override fun create(handle: SavedStateHandle): MyViewModel {
        return MyViewModel(handle, repository)
    }
}
