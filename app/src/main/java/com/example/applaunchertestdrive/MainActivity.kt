package com.example.applaunchertestdrive


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        chromeButton.setOnClickListener {
            onChromeButtonClick()
        }

        appDrawerButton.setOnClickListener {
            onAppDroorButtonClick()
        }

    }

    private fun onAppDroorButtonClick() {
        startActivity(Intent(this, DrawerAppList::class.java))

    }

    fun onChromeButtonClick() {
        val launchIntent = packageManager.getLaunchIntentForPackage("com.android.chrome")
        startActivity(launchIntent)
    }





}


