package com.example.applaunchertestdrive

import android.Manifest
import android.app.Activity
import android.app.WallpaperManager
import android.content.Context
import android.content.pm.PackageManager
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class MainActivityHelper {

    fun setActivityBackgroundToCurrentWallpaper(activity: Activity, wallpaperManager: WallpaperManager, permissionHelper: PermissionHelper) {


        if(permissionHelper.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED) {
            permissionHelper.requestPermissions(activity, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 1)
        }

        if (permissionHelper.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE)
            == PackageManager.PERMISSION_GRANTED) {
            var view = activity.findViewById<View>(R.id.layout)
            var drawable = wallpaperManager.drawable
            view.background = drawable
        }

    }
}