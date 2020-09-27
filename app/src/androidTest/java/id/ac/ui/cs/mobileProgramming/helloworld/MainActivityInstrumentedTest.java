package id.ac.ui.cs.mobileProgramming.helloworld;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {
    private String helloWorldText;
    private String message;
    private String encrypted;

    @Before
    public void setUp(){
        helloWorldText = "Hello World!";
        message = "darell";
        encrypted = "kecpzh";
    }

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testHelloWorldIsExist() {
        onView(withId(R.id.textView)).check(matches(withText(helloWorldText)));
    }

    @Test
    public void testEncryptText() {
        onView(withId(R.id.messageTarget)).perform(typeText(message));
        onView(withId(R.id.encrypt)).perform(click());
        onView(withId(R.id.output)).check(matches(withText(encrypted)));
    }
}