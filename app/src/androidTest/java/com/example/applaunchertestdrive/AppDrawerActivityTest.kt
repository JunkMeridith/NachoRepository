package com.example.applaunchertestdrive
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.hasChildCount
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Rule
import org.junit.Test

class AppDrawerTest {

    @get:Rule
    val activityRule = IntentsTestRule(MainActivity::class.java)

    @Test
    fun listsOneAppInDrawer() {
        val appList = listOf("Gmail")
        onView(withId(R.id.app_list)).check(matches(hasChildCount(appList.size)))
    }

}