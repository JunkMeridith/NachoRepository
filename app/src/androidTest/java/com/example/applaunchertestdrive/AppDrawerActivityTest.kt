package com.example.applaunchertestdrive

import android.content.Context
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.toPackage
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import junit.framework.TestCase.assertEquals
import kotlinx.android.synthetic.main.app_drawer_layout.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AppDrawerActivityTest {

    @get:Rule
    val activityRule = IntentsTestRule(AppDrawerActivity::class.java)

    lateinit var context: Context

    @Before
    fun setUp() {
        context = InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Test
    fun getsACountOfInstalledApplications() {
        val list = context.packageManager.getInstalledApplications(0)
        val totalListCount = (activityRule.activity.appDrawerList.adapter?.itemCount ?: 0)

        assertEquals(list.size, totalListCount)
    }

    @Test
    fun displaysApplicationLabels() {
        val list = context.packageManager.getInstalledApplications(0)
        val firstAppLabel = context.packageManager.getApplicationLabel(list[0]).toString()
        onView(withText(firstAppLabel)).check(matches(isDisplayed()))
    }

    @Test
    fun displaysApplicationIcons() {
        val list = context.packageManager.getInstalledApplications(0)
        val firstAppLabel = context.packageManager.getApplicationLabel(list[0]).toString()
        onView(withText(firstAppLabel)).check(matches(hasSibling(withId(R.id.img))))
        var firstImage: ImageView = activityRule.activity.findViewById(R.id.img)
        val applicationIcon = context.packageManager.getApplicationIcon(list[0])

        //assert only works because they are using the same drawable resource
        assertEquals(firstImage.drawable.constantState, applicationIcon.constantState)
    }

    @Test
    fun whenClickedStartIntent() {
        val list = activityRule.activity.getAllInstalledApplications()

        onView(withId(R.id.appDrawerList))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))


        intended(toPackage(list[0].packageName))
    }
}