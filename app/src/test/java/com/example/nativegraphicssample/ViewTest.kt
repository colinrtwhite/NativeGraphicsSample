package com.example.nativegraphicssample

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isClickable
import androidx.test.espresso.matcher.ViewMatchers.isRoot
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.takahirom.roborazzi.RoborazziRule
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.GraphicsMode

@RunWith(AndroidJUnit4::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
class ViewTest {

    @get:Rule
    val roborazziRule = RoborazziRule(
        captureRoot = onView(isRoot()),
        options = RoborazziRule.Options(
            outputDirectoryPath = "src/test/snapshots/images",
        )
    )

    @Test
    fun test() {
        ActivityScenario.launch(ViewTestActivity::class.java)

        onView(withId(R.id.image))
            .perform(object : ViewAction {
                override fun getDescription() = ""

                override fun getConstraints() = withId(R.id.image)

                override fun perform(uiController: UiController?, view: View?) {
                    (view as ImageView).setImageDrawable(ColorDrawable(Color.RED))
                }

            })
    }
}
