package com.elyeproj.simpleviewmodel.daggerbasic

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.elyeproj.simpleviewmodel.MainApplication
import com.elyeproj.simpleviewmodel.R
import com.elyeproj.simpleviewmodel.Repository
import kotlinx.android.synthetic.main.activity_demo.*

class MyViewModelDaggerActivity : AppCompatActivity() {

    private val viewModel: MyViewModel by viewModels()

    private val textDataObserver =
        Observer<String> { data -> text_view.text = data }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)

        (application as MainApplication).basicComponent.inject(viewModel)

        lifecycle.addObserver(viewModel)
        viewModel.showTextDataNotifier.observe(this, textDataObserver)
        btn_fetch.setOnClickListener { viewModel.fetchValue() }
    }
}
