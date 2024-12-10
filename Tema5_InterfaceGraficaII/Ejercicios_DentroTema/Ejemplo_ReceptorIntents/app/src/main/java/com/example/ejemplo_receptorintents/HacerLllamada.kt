package com.example.ejemploreceptorintents

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejemplo_receptorintents.R

class HacerLllamada : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hacer_lllamada)

        // ESTABLEZCO UNA ESCUCHA PARA LOS MÁRGENES DEL SISTEMA
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // OBTENGO LA INTENT QUE INICIÓ ESTA ACTIVIDAD
        val intent = intent
        // ACCEDO A LOS DATOS DE LA URI (TELÉFONO) EN LA INTENT
        val datos = intent.data
        // MUESTRO EL NÚMERO DE TELÉFONO MARCADO
        val mitextview = findViewById<TextView>(R.id.textViewLlamada)
        mitextview.text = "TELÉFONO:${datos?.schemeSpecificPart ?: "NÚMERO NO PROPORCIONADO"}"
    }
}