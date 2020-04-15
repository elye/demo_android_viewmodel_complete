package com.elyeproj.simpleviewmodel.basicviewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.elyeproj.simpleviewmodel.MainActivity.Companion.KEY
import com.elyeproj.simpleviewmodel.Repository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class MyViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Test
    fun `test init with default value`() {
        val savedStateHandle = mockk<SavedStateHandle>()
        val repository = mockk<Repository>()
        val liveData = mockk<MutableLiveData<String>>()
        every { liveData.value } returns "Default Value"
        every { savedStateHandle.getLiveData<String>(KEY) } returns liveData

        val viewModel = MyViewModel(
            savedStateHandle,
            repository
        )
        verify { savedStateHandle.getLiveData<String>(KEY) }
        Assert.assertEquals(viewModel.showTextDataNotifier.value, "Default Value")
    }

    @Test
    fun `test fetchValue with repository value`() {
        val savedStateHandle = mockk<SavedStateHandle>()
        val repository = mockk<Repository>()
        every { repository.getMessage() } returns "Repository Value"
        every { savedStateHandle.getLiveData<String>(any()) } returns MutableLiveData()

        val viewModel = MyViewModel(
            savedStateHandle,
            repository
        )
        viewModel.fetchValue()

        verify { repository.getMessage() }
        Assert.assertEquals(viewModel.showTextDataNotifier.value, "Repository Value")
    }

    @Test
    fun `test onPause with default value`() {
        val savedStateHandle = mockk<SavedStateHandle>()
        val repository = mockk<Repository>()
        every { savedStateHandle.set(KEY, "From onPaused") } returns Unit
        every { savedStateHandle.getLiveData<String>(KEY) } returns MutableLiveData()

        val viewModel = MyViewModel(
            savedStateHandle,
            repository
        )
        viewModel.onPause()

        verify(exactly = 0) { repository.getMessage() }
        verify { savedStateHandle.set(KEY, "From onPaused") }
    }
}
