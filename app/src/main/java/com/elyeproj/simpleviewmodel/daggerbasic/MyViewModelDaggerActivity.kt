package com.elyeproj.simpleviewmodel.daggerbasic

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.elyeproj.simpleviewmodel.MainApplication
import com.elyeproj.simpleviewmodel.databinding.ActivityDemoBinding

class MyViewModelDaggerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDemoBinding

    private val viewModel: MyViewModel by viewModels()

    private val textDataObserver =
        Observer<String> { data -> binding.textView.text = data }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDemoBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        (application as MainApplication).basicComponent.inject(viewModel)

        lifecycle.addObserver(viewModel)
        viewModel.showTextDataNotifier.observe(this, textDataObserver)
        binding.btnFetch.setOnClickListener { viewModel.fetchValue() }
    }
}
