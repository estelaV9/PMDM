package com.example.ejemplospoo

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var imagen: ImageView =findViewById<ImageView>(R.id.imageView)
        imagen.cargarImagen("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png")
        //   mostrar_mensaje("Mensaje", Toast.LENGTH_LONG)

        // REFERENCIO UN OBJETO EDITEXT
        var miTexto = findViewById<EditText>(R.id.editText)
        // ASOCIO UN ESCUCHADOR A ESE EDITTEXT A TRAVES DE LA FUNCINO DE EXTENSION DEFINIDA EN EXTENSIONES.KT
        miTexto.despues_cambio_texto { cadena ->
            mostrar_mensaje(cadena)
        }
    }
}