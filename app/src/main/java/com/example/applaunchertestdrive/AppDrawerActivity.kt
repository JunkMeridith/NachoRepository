package com.example.applaunchertestdrive

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.app_drawer_layout.*

class AppDrawerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_drawer_layout)

        appDrawerList.adapter = AppDrawerAdapter()
        appDrawerList.layoutManager = LinearLayoutManager(this)
    }

}




