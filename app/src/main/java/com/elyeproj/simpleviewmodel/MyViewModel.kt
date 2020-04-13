package com.elyeproj.simpleviewmodel

import androidx.lifecycle.*
import com.elyeproj.simpleviewmodel.MainActivity.Companion.KEY

class MyViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val repository: Repository) :
    ViewModel(), LifecycleObserver {

    private val showTextLiveData: MutableLiveData<String> = savedStateHandle.getLiveData(KEY)

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
