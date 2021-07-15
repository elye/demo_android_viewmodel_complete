package com.elyeproj.simpleviewmodel.basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.elyeproj.simpleviewmodel.MainActivity.Companion.KEY
import com.elyeproj.simpleviewmodel.R
import com.elyeproj.simpleviewmodel.Repository
import com.elyeproj.simpleviewmodel.databinding.ActivityDemoBinding

class MyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDemoBinding

    private val repository = Repository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemoBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        binding.btnFetch.setOnClickListener { fetchValue() }

        if (savedInstanceState != null) {
            binding.textView.text = savedInstanceState.getString(KEY)
        } else {
            binding.textView.text = intent.getStringExtra(KEY)
        }
    }

    private fun fetchValue() {
        binding.textView.text = repository.getMessage()
    }

    override fun onPause() {
        super.onPause()
        binding.textView.text =  "From onPaused"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY, binding.textView.text.toString())
    }
}
