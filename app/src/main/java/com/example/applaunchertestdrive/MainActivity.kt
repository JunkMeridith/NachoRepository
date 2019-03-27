package com.example.applaunchertestdrive


import android.app.WallpaperManager
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainActivityHelper().setActivityBackgroundToCurrentWallpaper(
            this,
            WallpaperManager.getInstance(this),
            PermissionHelper()
        )
    }

    fun onClickAppDrawerButton(@Suppress("UNUSED_PARAMETER") view: View) {
        startActivity(Intent(this, AppDrawerActivity::class.java))
    }

    fun onClickChromeButton(@Suppress("UNUSED_PARAMETER") view: View) {
        val launchIntent = packageManager.getLaunchIntentForPackage("com.android.chrome")
        startActivity(launchIntent)
    }

    fun onClickVideoChatButton(@Suppress("UNUSED_PARAMETER") view: View) {
        val launchIntent = packageManager.getLaunchIntentForPackage("com.twilio.video.quickstart.kotlin")
        startActivity(launchIntent)
    }


}


