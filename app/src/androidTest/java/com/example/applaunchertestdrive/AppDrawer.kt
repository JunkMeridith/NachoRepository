package com.example.applaunchertestdrive
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.rule.IntentsTestRule
import org.junit.Test
import org.junit.Rule
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.espresso.matcher.ViewMatchers.*


class AppDrawer {

    @get:Rule
    val activityRule = IntentsTestRule(MainActivity::class.java)

    @Test
    fun opensTheAppDrawer() {
        onView(withId(R.id.appDrawerButton)).perform(click())

        intended(hasComponent(DrawerAppList::class.java.name))
        onView(withId(R.id.app_list)).check(matches(isDisplayed()))
    }

    @Test
    fun listsOneAppInDrawer() {
        val appList = listOf("Gmail")
        onView(withId(R.id.app_list)).check(matches(hasChildCount(appList.size)))
    }

}