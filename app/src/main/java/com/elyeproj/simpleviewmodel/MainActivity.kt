package com.elyeproj.simpleviewmodel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.elyeproj.simpleviewmodel.basic.MyActivity
import com.elyeproj.simpleviewmodel.basicviewmodel.MyViewModelActivity
import com.elyeproj.simpleviewmodel.daggerandroid.MyViewModelAndroidDaggerActivity
import com.elyeproj.simpleviewmodel.koin.MyViewModelKoinActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val KEY = "DefaultKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_activity_based.setOnClickListener {
            val intent = Intent(this, MyActivity::class.java)
            intent.putExtra(KEY, "From Default Act")
            startActivity(intent)
        }

        btn_viewmodel_based.setOnClickListener {
            val intent = Intent(this, MyViewModelActivity::class.java)
            intent.putExtra(KEY, "From Default Vmd")
            startActivity(intent)
        }

        btn_viewmodel_android_dagger_based.setOnClickListener {
            val intent = Intent(this, MyViewModelAndroidDaggerActivity::class.java)
            intent.putExtra(KEY, "From Vmd AndDag")
            startActivity(intent)
        }

        btn_viewmodel_koin_based.setOnClickListener {
            val intent = Intent(this, MyViewModelKoinActivity::class.java)
            intent.putExtra(KEY, "From Vmd Koin")
            startActivity(intent)
        }
    }
}
