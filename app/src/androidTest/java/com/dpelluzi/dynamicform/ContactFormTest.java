package com.dpelluzi.dynamicform;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import com.dpelluzi.dynamicform.view.MainActivity;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class ContactFormTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);


    @Before
    public void selectContactTab() {
        String title = mActivityRule.getActivity().getString(R.string.title_contact);

        Matcher<View> matcher = allOf(withText(title),isDescendantOfA(withId(R.id.tabs)));

        onView(matcher).perform(click());
    }

    @Test
    public void fillForm_correct() {
        final int NAME_FIELD_ID = 2;

        Matcher<View> matcher = allOf(withId(R.id.text_input),isDescendantOfA(withId(NAME_FIELD_ID)));
        onView(matcher).perform(typeText("Full name\n"));

        // TODO fill other fields
    }
}
