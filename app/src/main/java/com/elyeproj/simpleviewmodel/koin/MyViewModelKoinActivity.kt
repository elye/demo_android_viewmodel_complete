package com.elyeproj.simpleviewmodel.koin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.elyeproj.simpleviewmodel.R
import com.elyeproj.simpleviewmodel.databinding.ActivityDemoBinding
import org.koin.androidx.viewmodel.ext.android.getStateViewModel
import org.koin.androidx.viewmodel.scope.BundleDefinition

class MyViewModelKoinActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDemoBinding

    private val viewModel by lazy {
        getStateViewModel<MyViewModel> (state = object: BundleDefinition {
            override fun invoke(): Bundle {
                return intent.extras ?: Bundle.EMPTY
            }
        })
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
