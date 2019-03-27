package com.example.applaunchertestdrive

import android.app.Activity
import android.content.Context
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class PermissionHelper {

    fun checkSelfPermission(context: Context, permission: String) : Int {
        return ContextCompat.checkSelfPermission(context, permission)
    }

    fun requestPermissions(activity: Activity, permissions: Array<String>, id: Int) {
        ActivityCompat.requestPermissions(activity, permissions, id)
    }
}