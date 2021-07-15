package com.elyeproj.simpleviewmodel.basicviewmodel

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.elyeproj.simpleviewmodel.R
import com.elyeproj.simpleviewmodel.Repository
import com.elyeproj.simpleviewmodel.databinding.ActivityDemoBinding

class MyViewModelActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDemoBinding

    private val viewModel: MyViewModel by viewModels{
        MyViewModelFactory(
            this,
            Repository(),
            intent.extras
        )
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
