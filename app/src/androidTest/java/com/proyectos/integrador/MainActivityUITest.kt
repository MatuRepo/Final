package com.proyectos.integrador
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import androidx.test.espresso.assertion.ViewAssertions
//??

class MainActivityUITest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun compararTest() {
        //tipeo
        Espresso.onView(ViewMatchers.withId(R.id.palabra1)).perform(ViewActions.typeText("hola"))
        Espresso.onView(ViewMatchers.withId(R.id.palabra2)).perform(ViewActions.typeText("hola"))

        // click
        Espresso.onView(ViewMatchers.withId(R.id.botonComparar)).perform(ViewActions.click())

        // resultad
        Espresso.onView(ViewMatchers.withId(R.id.resultado)).check(ViewAssertions.matches(ViewMatchers.withText("Las palabras son iguales")))
    }
}
