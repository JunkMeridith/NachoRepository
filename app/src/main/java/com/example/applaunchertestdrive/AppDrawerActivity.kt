package com.example.applaunchertestdrive

import android.content.pm.ApplicationInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.app_drawer_layout.*

class AppDrawerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_drawer_layout)

        val installedApps = this.packageManager.getInstalledApplications(0)
        val installedAppNames = installedApps.map{ ApplicationInfo(it).name }.toList()

        appDrawerList.adapter = AppDrawerAdapter(installedAppNames)
        appDrawerList.layoutManager = LinearLayoutManager(this)





    }

}




