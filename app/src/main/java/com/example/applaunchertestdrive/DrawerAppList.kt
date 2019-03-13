package com.example.applaunchertestdrive

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_drawer_app_list.*

class DrawerAppList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer_app_list)
        setSupportActionBar(toolbar)

    }

}
