package com.example.intenciones

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.intenciones.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mibinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mibinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mibinding.root)

        // CUANDO SEA PULSADO EL BOTON, LANZARA UNA INTENCION IMPLICITA QUE ABRA MI GITHUB
        mibinding.githubBtt.setOnClickListener {
            // CREAR UN INTENT PARA ABRIR LA URL
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/estelaV9"))

            // INICIAR LA ACTIVIDAD CON EL INTENT
            startActivity(intent)
        }

        // CUANDO SE PULSE EL BOTON SALUDAR, LANZARA UNA INTENCION PARA COMPARTIR EL TEXTO
        // “Hola, soy <reemplaza por tu nombre>. Solo quería saludarte.”
        mibinding.compartirBtt.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND);
            intent.setType("text/plain"); intent.putExtra(Intent.EXTRA_TEXT,
            "Hola, soy Estela. Solo quería saludarte." )
            startActivity(intent)
        }

        // LLAMAR AL TELEFONO DE UN COMPAÑERO

    }
}