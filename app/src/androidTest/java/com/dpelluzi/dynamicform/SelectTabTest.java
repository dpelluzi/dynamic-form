package com.dpelluzi.dynamicform;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import com.dpelluzi.dynamicform.view.MainActivity;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class SelectTabTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);


    @Test
    public void changeTab_Contact() {

        String title = mActivityRule.getActivity().getString(R.string.title_contact);

        Matcher<View> matcher = allOf(withText(title),isDescendantOfA(withId(R.id.tabs)));

        onView(matcher).perform(click());
        onView(withId(R.id.text_title)).check(matches(withText(title)));

    }

    @Test
    public void changeTab_Investment() {

        String title = mActivityRule.getActivity().getString(R.string.title_investment);

        Matcher<View> matcher = allOf(withText(title), isDescendantOfA(withId(R.id.tabs)));

        onView(matcher).perform(click());
        onView(withId(R.id.text_screen_title)).check(matches(withText(title)));

    }
}
