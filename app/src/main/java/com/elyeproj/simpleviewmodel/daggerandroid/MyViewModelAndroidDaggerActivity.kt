package com.elyeproj.simpleviewmodel.daggerandroid

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.elyeproj.simpleviewmodel.R
import com.elyeproj.simpleviewmodel.databinding.ActivityDemoBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MyViewModelAndroidDaggerActivity : DaggerAppCompatActivity() {
    private lateinit var binding: ActivityDemoBinding

    @Inject
    internal lateinit var viewModelFactory: MyViewModelFactory

    private val viewModel: MyViewModel by viewModels {
        GenericSavedStateViewModelFactory(viewModelFactory, this, intent.extras)
    }

    private val textDataObserver =
        Observer<String> { data -> binding.textView.text = data }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDemoBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
        lifecycle.addObserver(viewModel)
        viewModel.showTextDataNotifier.observe(this, textDataObserver)
        binding.btnFetch.setOnClickListener { viewModel.fetchValue() }
    }
}
