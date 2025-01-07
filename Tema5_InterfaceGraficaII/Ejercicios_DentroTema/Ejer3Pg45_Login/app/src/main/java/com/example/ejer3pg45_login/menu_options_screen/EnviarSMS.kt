package com.example.ejer3pg45_login.menu_options_screen

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ejer3pg45_login.MenuOpciones
import com.example.ejer3pg45_login.databinding.ActivityEnviarSmsBinding

class EnviarSMS : AppCompatActivity() {
    private lateinit var mibinding: ActivityEnviarSmsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // INICIALIZAMOS ViewBinding
        mibinding = ActivityEnviarSmsBinding.inflate(layoutInflater)
        setContentView(mibinding.root)

        mibinding.enviarBtt.setOnClickListener {
            // OBTENEMOS EL NUMERO DE TELEFONO Y EL MENSAJE
            val numero = mibinding.numeroET.text.toString()
            val mensaje = mibinding.smsET.text.toString()


            if (numero.isNotEmpty() && mensaje.isNotEmpty()) {
                val smsIntent = Intent(Intent.ACTION_SENDTO).apply {
                    // PASAMOS EL NUMERO Y EL MENSAJE A LA URI
                    data = Uri.parse("smsto:$numero") // URI PARA SMS
                    putExtra("sms_body", mensaje) // AGREGAMOS EL MENSAJE
                } // INTENT PARA ENVIAR EL SMS

                startActivity(smsIntent) // INICIAMOS LA ACTIVIDAD
            } else {
                // SI EL NUMERO O MENSAJE ESTAN VACIOS, MOSTRAMOS UN MENSAJE DE ERROR
                if (numero.isEmpty()) {
                    Toast.makeText(this, "Por favor ingresa un numero valido", Toast.LENGTH_SHORT).show()
                }
                if (mensaje.isEmpty()) {
                    Toast.makeText(this, "Por favor ingresa un mensaje valido", Toast.LENGTH_SHORT).show()
                }
            } // VERIFICAMOS QUE EL NUMERO Y EL MENSAJE NO ESTEN VACIOS
        } // CUANDO PULSE EL BOTON SE ENVIARA EL SMS

        mibinding.backBtt.setOnClickListener {
            finish()
        } // BOTON PARA VOLVER AL MENU DE OPCIONES
    }
}
