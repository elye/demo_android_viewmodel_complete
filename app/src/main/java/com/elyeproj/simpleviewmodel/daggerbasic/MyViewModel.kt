package com.elyeproj.simpleviewmodel.daggerbasic

import androidx.lifecycle.*
import com.elyeproj.simpleviewmodel.MainActivity.Companion.KEY
import com.elyeproj.simpleviewmodel.Repository
import javax.inject.Inject

class MyViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel(), LifecycleObserver {

    @Inject
    lateinit var repository: Repository

    private val showTextLiveData = savedStateHandle.getLiveData<String>(KEY)

    val showTextDataNotifier: LiveData<String>
        get() = showTextLiveData

    fun fetchValue() {
        showTextLiveData.value = repository.getMessage()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        // This is just to demo onPaused is called.
        // To save, we don't need to `set`. It is just same as set directly to textLiveData.value
        // Refer https://medium.com/@elye.project/unintuitive-livedata-savedstatehandle-3d01fbdbfc01
        savedStateHandle.set(KEY, "From onPaused")
    }
}
