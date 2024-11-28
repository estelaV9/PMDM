package com.example.ejemplo_ciclovida

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.ejemplociclovida.R

class MainActivity : AppCompatActivity() {
    lateinit var boton_segundaactividad: Button
    lateinit var boton_terceraactividad: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // INICIALIZAMOS LOS COMPONENTES DE LA VISTA (BOTONES)
        inicializarComponents()
        // AQUÍ SE PUEDEN ESTABLECER LOS ESCUCHADORES DE LOS BOTONES
    }

    private fun inicializarComponents() {
        boton_segundaactividad = findViewById(R.id.button2)
        boton_terceraactividad = findViewById(R.id.button3)

        // ESCUCHADOR PARA EL BOTÓN QUE INICIA LA SEGUNDA ACTIVIDAD
        boton_segundaactividad.setOnClickListener {
            val myIntent = Intent(this, SegundaActividad::class.java)
            startActivity(myIntent)
        }

        // ESCUCHADOR PARA EL BOTÓN QUE INICIA LA TERCERA ACTIVIDAD
        boton_terceraactividad.setOnClickListener {
            val myIntent = Intent(this, TerceraActividad::class.java)
            startActivity(myIntent)
        }
    }
}