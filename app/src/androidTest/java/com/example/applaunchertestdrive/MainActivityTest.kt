package com.example.applaunchertestdrive

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Test
import org.junit.Rule
import androidx.test.espresso.intent.matcher.IntentMatchers.*

sealed class MainActivityTest {
    @get:Rule
    val activityRule = IntentsTestRule(MainActivity::class.java)

    class OpenChromeTest : MainActivityTest() {


        @Test
        fun buttonExists() {
            onView(withId(R.id.chromeButton)).check(matches(isDisplayed()))
        }

        @Test
        fun buttonLaunchesChrome() {
            onView(withId(R.id.chromeButton)).perform(click())
            intended(toPackage("com.android.chrome"))
        }
    }

    class OpenAppDrawerTest : MainActivityTest() {

        @Test
        fun opensTheAppDrawer() {
            onView(withId(R.id.appDrawerButton)).perform(click())
            intended(hasComponent(DrawerAppList::class.java.name))
            onView(withId(R.id.app_list)).check(matches(isDisplayed()))
        }
    }
}

