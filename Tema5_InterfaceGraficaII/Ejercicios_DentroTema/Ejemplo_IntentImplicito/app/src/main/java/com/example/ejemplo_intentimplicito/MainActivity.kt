package com.example.ejemplo_intentimplicito

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.PackageManagerCompat
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
        }

        /** LOS PERMISOS SE DEFINEN COMO CONSTANTES EN CODIGO DESDE LA CLASE Manifest.permission.<PERMISO QUE SEA>
        COMPROBAR SI TENEMOS PERMISO -> FUNCION ContextCompat.checkSelfPermission
        SINO TENEMOS EL PERMISO, LARZAR UN DIALOG PARA SOLICITAR ESE PERMISO -> Funcion requestPermissions
        PODER RESPONDER SI EL PERMISO SE CONCEDE O NO SE CONCEDE -> IMPLEMENTACION FUNCION onRequestPermissionsResult **/

        // VERIFICAMOS SI EL PERMISO HA SIDO CONCEDIDO
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // SI NO SE TIENE EL PERMISO, SOLICITAMOS EL PERMISO AL USUARIO, EL CODIGO DE RESPUESTA (1) PERMITA SABER
            // SI EL PERMISO SE HA CONCEDIDO O NO
            requestPermissions(arrayOf(Manifest.permission.CALL_PHONE), 1)
        } else {
            // SI YA TIENE EL PERMISO, SE PUEDE REALIZAR LA LLAMADA
            val newIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:650531432"))
            startActivity(newIntent) // INICIAMOS LA ACTIVIDAD PARA MARCAR EL NUMERO
        }
    }

    // METODO QUE SE EJECUTA CUANTO EL SUUARIO RESPONDE A LA SOLICITUD DE PERMISO
    override fun onRequestPermissionsResult(
        requestCode: Int, // EL CODIGO DE LA SOLICITUD DE PERMISO
        permissions: Array<out String>, // ARRAY DE LOS PERMISOS SOLICITADOS
        grantResults: IntArray // RESULTADOS DE LA SOLICITUD (SI EL PERMISO FUE CONCEDIDO O NO)
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {  // VERIFICAMOS EL CÓDIGO DE RESPUESTA
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // SI EL PERMISO FUE CONCEDIDO, INICIAMOS LA LLAMADA
                startActivity(intentLlamar)  // INICIAMOS EL INTENT PARA REALIZAR LA LLAMADA
            } else {
                // SI EL PERMISO NO SE CONCEDIÓ, PODEMOS MOSTRAR UN MENSAJE DE ADVERTENCIA
                // PARA INFORMAR AL USUARIO QUE LA LLAMADA NO SE PUEDE REALIZAR
            }
        }
    }
}