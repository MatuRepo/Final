package com.proyectos.integrador
import org.junit.Test
import org.junit.Assert.*
import org.junit.Assert.assertEquals
import org.junit.runner.RunWith
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Before
import org.junit.Rule

//carpetas test o androidTest

@RunWith(AndroidJUnit4::class)
class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        viewModel = MainViewModel()
    }

    @Test
    fun iguales() {
        val palabra = Palabra("hola", "hola")

        viewModel.compararPalabras(palabra)

        viewModel.resultado.observeForever { resultado ->
            assertEquals("Las palabras son iguales", resultado)
        }
    }

    @Test
    fun diferentes() {
        val palabra = Palabra("hola", "chau")

        viewModel.compararPalabras(palabra)

        viewModel.resultado.observeForever { resultado ->
            assertEquals("Las palabras son diferentes", resultado)
        }
    }
}
