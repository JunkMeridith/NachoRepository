package com.example.applaunchertestdrive

import android.app.Activity
import android.app.WallpaperManager
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.drawable.GradientDrawable
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.robolectric.RobolectricTestRunner
import java.util.jar.Manifest

@RunWith(RobolectricTestRunner::class)
class MainActivityHelperTest {

    lateinit var mockActivity: Activity

    lateinit var mockView: View

    lateinit var mockWallpaperManager: WallpaperManager

    lateinit var mockPermissionHelper: PermissionHelper

    @Before
    fun setUp() {
        mockActivity = Mockito.mock(Activity::class.java)
        mockView = Mockito.mock(View::class.java)
        mockWallpaperManager = Mockito.mock(WallpaperManager::class.java)
        mockPermissionHelper = Mockito.mock(PermissionHelper::class.java)
    }

    @Test
    fun setActivityBackgroundToCurrentWallpaper_hasPermissions_setsWallpaper() {

        val expectedDrawable = GradientDrawable()
        `when`(mockActivity.findViewById<View>(ArgumentMatchers.anyInt())).thenReturn(mockView)
        `when`(mockWallpaperManager.drawable).thenReturn(expectedDrawable)

        val mainActivityHelper = MainActivityHelper()
        mainActivityHelper.setActivityBackgroundToCurrentWallpaper(mockActivity, mockWallpaperManager, mockPermissionHelper)

        verify(mockView, times(1)).setBackground(expectedDrawable)
    }

    @Test
    fun setActivityBackgroundToCurrentWallpaper_noPermissions_givenByUser() {
        `when`(mockPermissionHelper.checkSelfPermission(mockActivity, "android.permission.READ_EXTERNAL_STORAGE")).thenReturn(PackageManager.PERMISSION_DENIED)
        `when`(mockActivity.findViewById<View>(ArgumentMatchers.anyInt())).thenReturn(mockView)

        val mainActivityHelper = MainActivityHelper()
        mainActivityHelper.setActivityBackgroundToCurrentWallpaper(mockActivity, mockWallpaperManager, mockPermissionHelper)

        verify(mockPermissionHelper, times(1)).requestPermissions(mockActivity, arrayOf("android.permission.READ_EXTERNAL_STORAGE"), 1)
    }

    @Test
    fun setActivityBackgroundToCurrentWallpaper_noPermissions_notGivenByUser() {
        `when`(mockPermissionHelper.checkSelfPermission(mockActivity, "android.permission.READ_EXTERNAL_STORAGE")).thenReturn(PackageManager.PERMISSION_DENIED)
        `when`(mockActivity.findViewById<View>(ArgumentMatchers.anyInt())).thenReturn(mockView)

        val mainActivityHelper = MainActivityHelper()
        mainActivityHelper.setActivityBackgroundToCurrentWallpaper(mockActivity, mockWallpaperManager, mockPermissionHelper)

        verify(mockView, times(0)).setBackground(any())
    }

}