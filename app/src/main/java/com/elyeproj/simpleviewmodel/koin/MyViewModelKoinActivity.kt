package com.elyeproj.simpleviewmodel.koin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.elyeproj.simpleviewmodel.R
import kotlinx.android.synthetic.main.activity_demo.*
import org.koin.androidx.viewmodel.ext.android.getStateViewModel

class MyViewModelKoinActivity : AppCompatActivity() {

    private val viewModel by lazy {
        getStateViewModel<MyViewModel> (bundle = intent.extras)
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
