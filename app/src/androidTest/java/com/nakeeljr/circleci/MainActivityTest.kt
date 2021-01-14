package com.nakeeljr.circleci

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.runner.RunWith
import androidx.test.rule.ActivityTestRule
import org.junit.Test

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, false, false)

    @Test
    fun appLaunchSuccessfully() {
        ActivityScenario.launch(MainActivity::class.java)
    }
}