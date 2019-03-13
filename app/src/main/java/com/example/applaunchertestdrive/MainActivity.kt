package com.example.applaunchertestdrive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chromeButton.setOnClickListener { onChromeButtonClick() }

    }

    fun onChromeButtonClick() {
        val launchIntent = packageManager.getLaunchIntentForPackage("com.android.chrome")
        startActivity(launchIntent)
    }
}
