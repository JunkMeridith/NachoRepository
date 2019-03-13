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


class openChromeTest {

    @get:Rule
    val activityRule = IntentsTestRule(MainActivity::class.java)

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