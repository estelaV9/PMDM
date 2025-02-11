package com.example.repasodeltema

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.repasodeltema.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var miBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // INFLAR EL BINGING
        miBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(miBinding.root)

        // SE CONFIGURA EL TOOLBAR
        setSupportActionBar(findViewById(R.id.my_toolbar))

        // SE CONFIGURA EL BOTTON NAVIGATION
        miBinding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.irPrincipal -> {
                    Toast.makeText(this, "Inicio seleccionado", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.irFavoritos -> {
                    Toast.makeText(this, "Favoritos seleccionado", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.irAjustes -> {
                    Toast.makeText(this, "Ajustes seleccionado", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // SE EJECUTA AUTOMATICAMENTE CUANDO CREE LA ACTIVITY
        menuInflater.inflate(R.menu.menu_opciones, menu)
        return true
    } // SE INFLA EL MENU DE OPCIONES

    // SE MANEJA LA SELECCION DE OPCIONES DEL MENU
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_option1 -> {
                Toast.makeText(this, "Opción 1 seleccionada", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.action_option2 -> {
                Toast.makeText(this, "Opción 2 seleccionada", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.action_about -> {
                Toast.makeText(this, "Acerca de...", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.action_exit -> {
                finish() // CERRAR ACTIVIDAD
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}