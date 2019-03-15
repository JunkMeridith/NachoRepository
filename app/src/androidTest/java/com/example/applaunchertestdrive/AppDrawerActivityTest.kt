package com.example.applaunchertestdrive
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Rule
import org.junit.Test

class AppDrawerActivityTest {

    @get:Rule
    val activityRule = IntentsTestRule(AppDrawerActivity::class.java)

    @Test
    fun listsOneAppInDrawer() {
        onView(withId(R.id.appDrawerList))
            .check(matches(hasDescendant(withText("Gmail"))))
    }

}