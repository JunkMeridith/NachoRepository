package com.example.applaunchertestdrive

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.app_drawer_layout.*


class AppDrawerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_drawer_layout)

        val installedApps = getAllInstalledApplications()

        appDrawerList.adapter = AppDrawerAdapter(installedApps, this.packageManager, this)
        appDrawerList.layoutManager = LinearLayoutManager(this)
    }

    fun getAllInstalledApplications(): List<ApplicationInfo> {
        val installedApps = this.packageManager.getInstalledApplications(PackageManager.PERMISSION_GRANTED)
        return installedApps
            .filter {
                this.packageManager.getLaunchIntentForPackage(it.packageName) != null
            }
    }



}




