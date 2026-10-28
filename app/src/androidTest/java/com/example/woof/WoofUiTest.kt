package com.example.woof

import android.graphics.BitmapFactory
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.filterToOne
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToIndex
import androidx.compose.ui.test.performScrollToNode
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.woof.data.dogs
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WoofUiTest {
    @get:Rule
    val compose = createAndroidComposeRule<MainActivity>()

    private fun text(id: Int) = compose.activity.getString(id)
    private fun expand(name: Int) = compose.onNodeWithContentDescription(
        compose.activity.getString(R.string.expand_button_content_description, text(name))
    )
    private fun collapse(name: Int) = compose.onNodeWithContentDescription(
        compose.activity.getString(R.string.collapse_button_content_description, text(name))
    )

    @Test
    fun allNineDogsShowNameAgeAndActivity() {
        dogs.forEachIndexed { index, dog ->
            compose.onNodeWithTag("dog_list").performScrollToIndex(index)
            compose.onNodeWithText(text(dog.name)).assertIsDisplayed()
            compose.onNodeWithTag("dog_${dog.name}").onChildren()
                .filterToOne(hasText(compose.activity.getString(R.string.years_old, dog.age)))
                .assertIsDisplayed()
            expand(dog.name).performClick()
            compose.onNodeWithTag("dog_list").performScrollToNode(hasText(text(dog.hobbies)))
            compose.onNodeWithText(text(dog.hobbies)).assertIsDisplayed()
            collapse(dog.name).performClick()
            compose.onNodeWithText(text(dog.hobbies)).assertDoesNotExist()
        }
    }

    @Test
    fun allNinePhotosCanBeDecoded() {
        dogs.forEach { dog ->
            compose.activity.resources.openRawResource(dog.imageResourceId).use { stream ->
                val photo = BitmapFactory.decodeStream(stream)
                assertNotNull("Foto de ${text(dog.name)}", photo)
                assertTrue(photo.width > 0 && photo.height > 0)
                photo.recycle()
            }
        }
    }

    @Test
    fun cardsExpandIndependently() {
        expand(R.string.dog_name_1).performClick()
        expand(R.string.dog_name_2).performClick()
        compose.onNodeWithText(text(R.string.dog_description_1)).assertIsDisplayed()
        compose.onNodeWithText(text(R.string.dog_description_2)).assertIsDisplayed()
        collapse(R.string.dog_name_1).performClick()
        compose.onNodeWithText(text(R.string.dog_description_1)).assertDoesNotExist()
        compose.onNodeWithText(text(R.string.dog_description_2)).assertIsDisplayed()
    }

    @Test
    fun expansionSurvivesActivityRecreation() {
        expand(R.string.dog_name_1).performClick()
        compose.activityRule.scenario.recreate()
        compose.onNodeWithText(text(R.string.dog_description_1)).assertIsDisplayed()
        collapse(R.string.dog_name_1).assertIsDisplayed()
    }

    @Test
    fun scrollingAwayAndBackPreservesExpansion() {
        expand(R.string.dog_name_1).performClick()
        compose.onNodeWithTag("dog_list").performScrollToIndex(8)
        compose.onNodeWithText(text(R.string.dog_name_9)).assertIsDisplayed()
        compose.onNodeWithTag("dog_list").performScrollToIndex(0)
        compose.onNodeWithText(text(R.string.dog_description_1)).assertIsDisplayed()
    }
}
