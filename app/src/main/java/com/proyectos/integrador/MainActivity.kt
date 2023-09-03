package com.proyectos.integrador

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.proyectos.integrador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.resultado.observe(this, Observer { resultado ->
            binding.resultado.text = resultado
        })

        binding.botonComparar.setOnClickListener {
            val palabra1 = binding.palabra1.text.toString()
            val palabra2 = binding.palabra2.text.toString()
            val palabra = Palabra(palabra1, palabra2)
            viewModel.compararPalabras(palabra)
        }
    }
}