package com.elyeproj.simpleviewmodel.daggerandroid

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.elyeproj.simpleviewmodel.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_demo.*
import javax.inject.Inject

class MyViewModelAndroidDaggerActivity : DaggerAppCompatActivity() {

    @Inject
    internal lateinit var viewModelFactory: MyViewModelFactory

    private val viewModel: MyViewModel by viewModels {
        GenericSavedStateViewModelFactory(viewModelFactory, this, intent.extras)
    }

    private val textDataObserver =
        Observer<String> { data -> text_view.text = data }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)
        lifecycle.addObserver(viewModel)
        viewModel.showTextDataNotifier.observe(this, textDataObserver)
        btn_fetch.setOnClickListener { viewModel.fetchValue() }
    }
}
