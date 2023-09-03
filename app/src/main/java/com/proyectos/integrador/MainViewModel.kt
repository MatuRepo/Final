package com.proyectos.integrador

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val resultado = MutableLiveData<String>()

    fun compararPalabras(palabra: Palabra) {
        resultado.value = if (palabra.palabra1 == palabra.palabra2) {
            "Las palabras son iguales"
        } else {
            "Las palabras son diferentes"
        }
    }
}