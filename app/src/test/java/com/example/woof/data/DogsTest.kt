package com.example.woof.data

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class DogsTest {
    @Test
    fun catalog_has_nine_dogs() {
        assertEquals(9, dogs.size)
    }

    @Test
    fun names_are_unique_and_ages_are_nonnegative() {
        assertEquals(dogs.size, dogs.map { it.name }.distinct().size)
        assertTrue(dogs.all { it.age >= 0 })
    }

    @Test
    fun each_dog_has_image_and_hobby_resource() {
        assertTrue(dogs.all { it.imageResourceId != 0 && it.hobbies != 0 })
    }
}
