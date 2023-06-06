package com.example.bookmaker;

import static org.junit.Assert.*;

import org.testng.annotations.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ButtonTextTest {

    @Rule
    public ActivityScenarioRule<mainpage> activityScenarioRule =
            new ActivityScenarioRule<>(mainpage.class);

    @Test
    public void testButtonText() {
        // Verify the text of each button
        Espresso.onView(withId(R.id.football))
                .check(matches(withText(R.string.football)));

        Espresso.onView(withId(R.id.tennis))
                .check(matches(withText(R.string.tennis)));

        Espresso.onView(withId(R.id.basketball))
                .check(matches(withText(R.string.basketball)));

        Espresso.onView(withId(R.id.mma))
                .check(matches(withText(R.string.mma)));

        Espresso.onView(withId(R.id.golf))
                .check(matches(withText(R.string.golf)));

        Espresso.onView(withId(R.id.hockey))
                .check(matches(withText(R.string.hockey)));

        Espresso.onView(withId(R.id.american_football))
                .check(matches(withText(R.string.am_footbal)));

        Espresso.onView(withId(R.id.australian_football))
                .check(matches(withText(R.string.Aus_football)));

        Espresso.onView(withId(R.id.rugby))
                .check(matches(withText(R.string.rugby)));

        Espresso.onView(withId(R.id.baseball))
                .check(matches(withText(R.string.baseball)));

        Espresso.onView(withId(R.id.cricket))
                .check(matches(withText(R.string.cricket)));

        Espresso.onView(withId(R.id.politics))
                .check(matches(withText(R.string.politics)));
    }

    @Test
    public void testLayoutRemovalOnClick() {
        // Simulate the layout creation (add the layout to the parent view)
        YourActivity activity = activityScenarioRule.getScenario().getActivity();
        ViewGroup layout = activity.findViewById(R.id.yourParentLayout); // Replace with the actual parent layout ID
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.coupon_template, null);
        layout.addView(view);

        // Perform a click on the close button
        onView(withId(R.id.imageButton2)).perform(click());

        // Verify that the layout is removed from the parent view
        onView(withId(R.id.template)).check(doesNotExist()); // Replace with the actual layout ID

        // Verify the absence of specific views within the layout (optional)
        onView(withId(R.id.addBetName)).check(doesNotExist()); // Replace with the actual view ID
        onView(withId(R.id.addOdd)).check(doesNotExist()); // Replace with the actual view ID
        onView(withId(R.id.addWinner)).check(doesNotExist()); // Replace with the actual view ID
        onView(withId(R.id.imageButton2)).check(doesNotExist()); // Replace with the actual view ID
    }
}