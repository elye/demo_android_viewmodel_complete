package com.elyeproj.simpleviewmodel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.elyeproj.simpleviewmodel.basic.MyActivity
import com.elyeproj.simpleviewmodel.basicviewmodel.MyViewModelActivity
import com.elyeproj.simpleviewmodel.daggerandroid.MyViewModelAndroidDaggerActivity
import com.elyeproj.simpleviewmodel.daggerbasic.MyViewModelDaggerActivity
import com.elyeproj.simpleviewmodel.databinding.ActivityMainBinding
import com.elyeproj.simpleviewmodel.koin.MyViewModelKoinActivity
import com.elyeproj.simpleviewmodel.manuallocator.MyViewModelLocatorActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        const val KEY = "DefaultKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        binding.btnActivityBased.setOnClickListener {
            val intent = Intent(this, MyActivity::class.java)
            intent.putExtra(KEY, "From Default Act")
            startActivity(intent)
        }

        binding.btnViewmodelBased.setOnClickListener {
            val intent = Intent(this, MyViewModelActivity::class.java)
            intent.putExtra(KEY, "From Default Vmd")
            startActivity(intent)
        }

        binding.btnViewmodelAndroidDaggerBased.setOnClickListener {
            val intent = Intent(this, MyViewModelAndroidDaggerActivity::class.java)
            intent.putExtra(KEY, "From Vmd AndDag")
            startActivity(intent)
        }

        binding.btnViewmodelDaggerBased.setOnClickListener {
            val intent = Intent(this, MyViewModelDaggerActivity::class.java)
            intent.putExtra(KEY, "From Vmd Dagger")
            startActivity(intent)
        }

        binding.btnViewmodelKoinBased.setOnClickListener {
            val intent = Intent(this, MyViewModelKoinActivity::class.java)
            intent.putExtra(KEY, "From Vmd Koin")
            startActivity(intent)
        }

        binding.btnViewmodelLocatorBased.setOnClickListener {
            val intent = Intent(this, MyViewModelLocatorActivity::class.java)
            intent.putExtra(KEY, "From Vmd Manual")
            startActivity(intent)
        }
    }
}
