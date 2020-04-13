package com.elyeproj.simpleviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.elyeproj.simpleviewmodel.MainActivity.Companion.KEY
import kotlinx.android.synthetic.main.activity_demo.*

class MyViewModelActivity : AppCompatActivity() {

    private val viewModel: MyViewModel by viewModels{
        val bundle = Bundle().apply {
            putString(KEY, "From Default")
        }
        MyViewModelFactory(this, Repository(), intent.extras)
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
