package com.example.applaunchertestdrive
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import kotlinx.android.synthetic.main.app_drawer_layout.*
import org.junit.Rule
import org.junit.Test

class AppDrawerActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(AppDrawerActivity::class.java)


    @Test
    fun getsACountOfInstalledApplications() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val list = context.packageManager.getInstalledApplications(0)
        val totalListCount = (activityRule.activity.appDrawerList.adapter?.itemCount ?: 0) - 1

        onView(withId(R.id.appDrawerList))
            .perform(RecyclerViewActions
            .scrollToPosition<RecyclerView.ViewHolder>(totalListCount))

        onView(withId(R.id.appDrawerList)).check(matches(hasChildCount(list.size)))
    }
}