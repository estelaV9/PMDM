package com.example.ejemplo_receptorintents

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.CalendarContract
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejemplo_receptorintents.databinding.ActivityMainBinding
import java.time.LocalDateTime
import java.time.ZoneOffset

class MainActivity : AppCompatActivity() {
    private lateinit var mibinding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        mibinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mibinding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        } // ESTABLEZCO UNA ESCUCHA PARA LOS MÁRGENES DEL SISTEMA

        mibinding.botonNavegador.setOnClickListener {
            // CREAMOS UNA INTENT PARA NAVEGAR A UNA WEB
            val miIntent = Intent(Intent.ACTION_VIEW)
            miIntent.data = Uri.parse("https://www.google.com")

            // VERIFICAMOS SI EXISTE UNA ACTIVIDAD QUE PUEDA RESPONDER A ESTA ACCIÓN
            if (miIntent.resolveActivity(packageManager) != null) {
                startActivity(miIntent)
            }
        } // ESCUCHADOR BOTÓN NAVEGADOR


        mibinding.botonLlamada.setOnClickListener {
            // CREAMOS UNA INTENT PARA ABRIR EL DIALER
            var miIntent = Intent(Intent.ACTION_DIAL)
            miIntent.data = Uri.parse("tel:685424232")
            val chooser = Intent.createChooser(miIntent, "SELECCIONA UNA APLICACIÓN")

            // VERIFICAMOS QUE EXISTE UNA APLICACIÓN QUE PUEDA RESPONDER A ESTA ACCIÓN
            if (miIntent.resolveActivity(packageManager) != null) {
                startActivity(miIntent)
            }
        } // ESCUCHADOR BOTÓN LLAMADA (ABRIR EL DIALER)


        mibinding.botonEmail.setOnClickListener {
            // CREAMOS UNA INTENT PARA ENVIAR UN EMAIL
            val miIntent = Intent(Intent.ACTION_SENDTO)
            miIntent.type = "text/plain"
            miIntent.data = Uri.parse("mailto:")
            miIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("rsanchezro@educa.jcyl.es"))
            miIntent.putExtra(Intent.EXTRA_SUBJECT, "Email de prueba")
            miIntent.putExtra(Intent.EXTRA_TEXT, "Este es el texto del mensaje")

            // VERIFICAMOS QUE EXISTE UNA APLICACIÓN QUE PUEDA RESPONDER A ESTA ACCIÓN
            if (miIntent.resolveActivity(packageManager) != null) {
                startActivity(miIntent)
            }
        } // ESCUCHADOR BOTÓN ENVIAR EMAIL


        mibinding.botonCalendario.setOnClickListener {
            // CREAMOS UNA INTENT PARA INSERTAR UN NUEVO EVENTO EN EL CALENDARIO
            var miIntent = Intent(Intent.ACTION_INSERT)
            miIntent.data = CalendarContract.Events.CONTENT_URI
            miIntent.type = "vnd.android.cursor.dir/event"
            miIntent.putExtra(CalendarContract.Events.TITLE, "Título del evento")
            miIntent.putExtra(CalendarContract.Events.DESCRIPTION, "Descripción del evento")

            // DEFINIMOS LA HORA DE INICIO Y FIN DEL EVENTO
            var dateTime =
                LocalDateTime.of(2024, 12, 12, 15, 30, 0) // 12 de diciembre de 2024, 15:30:00
            var epochTime = dateTime.toInstant(ZoneOffset.UTC).toEpochMilli()
            miIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, epochTime)

            // LA HORA DE FINALIZACION DEL EVENTO DE LA MISMA FORMA QUE EL VALOR ANTERIOR
            dateTime = LocalDateTime.of(2024, 12, 20, 23, 59, 59)
            epochTime = dateTime.toInstant(ZoneOffset.UTC).toEpochMilli()
            miIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, epochTime)

            // SOLO QUEDA ARRANCAR UNA ACTIVIDAD QUE RESPONDA A ESTA ACCION
            if (miIntent.resolveActivity(packageManager) != null) {
                startActivity(miIntent)
            }
        } // ESCUCHADOR BOTÓN AGREGAR EVENTO AL CALENDARIO
    }
}