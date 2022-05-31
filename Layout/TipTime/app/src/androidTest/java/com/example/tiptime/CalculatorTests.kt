package com.example.tiptime

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculatorTests {

    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calculate_20_percent_tip(){
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("50.00")).perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.tip_result)).check(matches(withText(containsString("$10.00"))))
    }

    @Test
    fun calculate_15_percent_tip_roundup(){
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("50.00")).perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.option_15_percent)).perform(click())
        onView(withId(R.id.option_15_percent)).check(matches(isChecked()))
        onView(withId(R.id.option_18_percent)).check(matches(isNotChecked()))
        onView(withId(R.id.option_20_percent)).check(matches(isNotChecked()))
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.tip_result)).check(matches(withText(containsString("$8.00"))))
    }

    @Test
    fun calculate_15_percent_tip_no_roundup(){
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("50.00")).perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.option_15_percent)).perform(click())
        onView(withId(R.id.option_15_percent)).check(matches(isChecked()))
        onView(withId(R.id.option_18_percent)).check(matches(isNotChecked()))
        onView(withId(R.id.option_20_percent)).check(matches(isNotChecked()))
        onView(withId(R.id.round_up_switch)).perform(click())
        onView(withId(R.id.round_up_switch)).check(matches(isNotChecked()))
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.tip_result)).check(matches(withText(containsString("$7.5gi0"))))
    }
}

