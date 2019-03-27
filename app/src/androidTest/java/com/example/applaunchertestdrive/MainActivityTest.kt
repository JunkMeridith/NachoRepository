package com.example.applaunchertestdrive

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.matcher.IntentMatchers.toPackage
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.GrantPermissionRule
import org.junit.Rule
import org.junit.Test


class MainActivityTest {

    @get:Rule
    val activityRule = IntentsTestRule(MainActivity::class.java)

    @Test
    fun chromeButtonExists() {
        onView(withId(R.id.chromeButton)).check(matches(isDisplayed()))
    }

    @Test
    fun appDrawerButtonExists() {
        onView(withId(R.id.appDrawerButton)).check(matches(isDisplayed()))
    }

    @Test
    fun videoChatButtonExists() {
        onView(withId(R.id.videoChatButton)).check(matches(isDisplayed()))
    }

    @Test
    fun buttonLaunchesChrome() {
        onView(withId(R.id.chromeButton)).perform(click())
        intended(toPackage("com.android.chrome"))
    }

    @Test
    fun opensTheAppDrawer() {
        onView(withId(R.id.appDrawerButton)).perform(click())
        intended(hasComponent(AppDrawerActivity::class.java.name))
        onView(withId(R.id.appDrawerList)).check(matches(isDisplayed()))
    }

    @Test
    fun videoChatButtonLaunchesTwilio() {
        onView(withId(R.id.videoChatButton)).perform(click())
        intended(toPackage("com.twilio.video.quickstart.kotlin"))
    }

}


