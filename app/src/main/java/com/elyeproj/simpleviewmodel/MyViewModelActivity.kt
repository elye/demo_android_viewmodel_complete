package com.elyeproj.simpleviewmodel

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_demo.*
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.stateViewModel

class MyViewModelActivity : AppCompatActivity() {

    private val viewModel: MyViewModel by stateViewModel()

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
