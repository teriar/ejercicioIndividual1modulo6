package com.example.cl.ejercicio1modulo6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cl.ejercicio1modulo6.databinding.ActivityMainBinding

/*
* [x] Fragmento para agregar

* * [x] crear Interfaz
* * [] Room
*    [x] Entity
*    [x] Dao
*    [] DB
*
** [] fragmento para listar
* [] RecyclerView
* [x] Navigation
* */
class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}