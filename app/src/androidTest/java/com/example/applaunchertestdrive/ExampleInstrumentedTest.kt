package com.example.applaunchertestdrive

import android.app.Instrumentation
import android.content.Intent
import androidx.test.InstrumentationRegistry
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.allOf

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule
import java.util.regex.Matcher
import android.app.Instrumentation.ActivityResult
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.*


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val activityRule = IntentsTestRule(MainActivity::class.java)
    @Test
    fun buttonShouldExist() {
        onView(withId(R.id.chromeButton)).check(matches(isDisplayed()))

    }

    @Test
    fun buttonShouldLaunchChrome(){

        onView(withId(R.id.chromeButton)).perform(click())
     //   intended(toPackage("com.android.chrome/com.google.android.apps.chrome.Main"))

    }
}

//        onView(withId(R.id.phoneNumber)).check(matches(withText(phoneNumber)))®
