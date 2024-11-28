package com.example.ejemplo_intentimplicito

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var botonLlamar: Button  // DECLARAMOS EL BOTÓN PARA REALIZAR LA LLAMADA
    lateinit var intentLlamar: Intent  // DECLARAMOS EL INTENT PARA LA LLAMADA

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()  // ACTIVAMOS EL MODO DE PANTALLA COMPLETA SIN BORDES
        setContentView(R.layout.activity_main)  // ESTABLECEMOS EL LAYOUT PARA ESTA ACTIVIDAD

        // CONFIGURACIÓN PARA APLICAR PADDING AL VENTANA PRINCIPAL, TOMANDO EN CUENTA LOS BORDES DEL SISTEMA
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets  // RETORNAMOS LOS PADDING PARA APLICARLOS
        }

        InitComponentes()  // INICIALIZAMOS LOS COMPONENTES DE LA ACTIVIDAD
    }

    // MÉTODO PARA INICIALIZAR LOS COMPONENTES DE LA INTERFAZ DE USUARIO
    private fun InitComponentes() {
        this.botonLlamar = findViewById(R.id.button)  // ASIGNAMOS EL BOTÓN LLAMAR A LA VARIABLE
        botonLlamar.setOnClickListener {
            intentLlamar =
                Intent(Intent.ACTION_CALL)  // CREAMOS UN INTENT PARA REALIZAR UNA LLAMADA
            intentLlamar.setData(Uri.parse("tel:983454554"))  // ESTABLECEMOS EL NÚMERO TELEFÓNICO QUE SE LLAMARÁ

            // VERIFICAMOS SI LA APP TIENE LOS PERMISOS NECESARIOS PARA REALIZAR LLAMADAS
            // SI NO LOS TIENE, DEBERÍA SOLICITARLOS.
            // EN ESTE CASO, SE ESTÁ LLAMANDO A LA ACCIÓN DE LLAMADA DIRECTAMENTE
            // PERO DEBERÍAS IMPLEMENTAR LA VERIFICACIÓN Y SOLICITUD DE PERMISOS.

            // ENLACE A LA DOCUMENTACIÓN DE PERMISOS:
            // https://developer.android.com/training/permissions/requesting?hl=es-419

            startActivity(intentLlamar)  // INICIAMOS LA ACTIVIDAD CON EL INTENT PARA REALIZAR LA LLAMADA
        }

        // COMPROBAR SI TENEMOS PERMISO
        // SINO TENEMOS EL PERMISO, LARZAR UN DIALOG PARA SOLICITAR ESE PERMISO
        // PODER RESPONDER SI EL PERMISO SE CONCEDE O NO SE CONCEDE -> IMPLEMENTACION DE UN METODO
    }
}