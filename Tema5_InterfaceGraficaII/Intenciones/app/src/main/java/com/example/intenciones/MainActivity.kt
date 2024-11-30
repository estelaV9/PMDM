package com.example.intenciones

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
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
        mibinding.openWebPageBtt.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/estelaV9"))
            startActivity(intent)
        }

        // LLAMAR AL TELEFONO DE UN COMPAÑERO
        mibinding.callPhoneBtt.setOnClickListener {
            /*Caused by: java.lang.SecurityException: Permission Denial:
            starting Intent { act=android.intent.action.CALL
            SALTARA UN ERROR QUE INDICA QUE SE HA INTENTADO LLAMAR SIN TENER CONCEDIDO EL PERMISO
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:962849347"))*/

            // ESTA OPCION NO LLAMA DIRECTAMENTE, SINO QUE EL USUARIO DECIDIRA SI ES SEGURO LLAMAR
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:962849347"))
            startActivity(intent)
        }

        // CUANDO SE PULSE EL BOTON SALUDAR, LANZARA UNA INTENCION PARA COMPARTIR EL TEXTO
        // “Hola, soy <reemplaza por tu nombre>. Solo quería saludarte.”
        mibinding.shareTextBtt.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(
                    Intent.EXTRA_TEXT,
                    "Hola, soy Estela. Solo quería saludarte."
                )
            }
            startActivity(Intent.createChooser(intent, "Compartir vía"))
        }

        // ABRIR UN MAPA EN UNA LONGITUD Y LATITUD, CON UN DETERMINADO ZOOM
        mibinding.openMapBtt.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:38.995656,-0.166093?z=18"))
            startActivity(intent)
        }

        // TOMAR UNA FOTO
        mibinding.takePhotoBtt.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "No se encontró cámara disponible", Toast.LENGTH_SHORT).show()
            }
        }
    }
}