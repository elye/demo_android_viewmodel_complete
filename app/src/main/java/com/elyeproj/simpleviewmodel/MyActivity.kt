package com.elyeproj.simpleviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.elyeproj.simpleviewmodel.MainActivity.Companion.KEY
import kotlinx.android.synthetic.main.activity_demo.*

class MyActivity : AppCompatActivity() {

    private val repository = Repository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)
        btn_fetch.setOnClickListener { fetchValue() }

        if (savedInstanceState != null) {
            text_view.text = savedInstanceState.getString(KEY)
        } else {
            text_view.text = intent.getStringExtra(KEY)
        }
    }

    private fun fetchValue() {
        text_view.text = repository.getMessage()
    }

    override fun onPause() {
        super.onPause()
        text_view.text =  "From onPaused"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY, text_view.text.toString())
    }
}
