package com.example.ejer3pg45_login.menu_options_screen

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejer3pg45_login.MenuOpciones
import com.example.ejer3pg45_login.databinding.ActivityLlamarBinding

class Llamar : AppCompatActivity() {
    private lateinit var mibinding: ActivityLlamarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // INICIALIZAMOS ViewBinding
        mibinding = ActivityLlamarBinding.inflate(layoutInflater)
        setContentView(mibinding.root)

        // OBTENEMOS LA INTENT QUE INICIO ESTA ACTIVIDAD
        val intent = intent
        // ACCEDEMOS A LOS DATOS DE LA URI (TELEFONO) EN LA INTENT
        val datos = intent.data
        val number = mibinding.numeroET // SE MUESTRA EL NUMERO DE TELEFONO MARCADO


        if (datos != null) {
            number.setText(datos.toString()) // ESTABLECEMOS EL NUMERO
        } // SI LA URI CONTIENE UN NUMERO DE TELEFONO, LO MOSTRAMOS EN EL CAMPO DE TEXTO

        mibinding.llamarBtt.setOnClickListener {
            val phoneNumber = number.text.toString() // NUMERO INTRODUCIDO

            if (phoneNumber.isNotEmpty()) {
                val dialIntent = Intent(Intent.ACTION_DIAL).apply {
                    // PASAMOS EL NUMERO A LA URI
                    data = Uri.parse("tel:$phoneNumber")
                } // SE CREA UN INTENT PARA ABRIR EL DIALER

                startActivity(dialIntent) // SE INICIA LA ACTIVIDAD PARA LLAMAR
            } else {
                // SI NO HAY NUMERO, MOSTRAMOS UN MENSAJE DE ERROR
                number.error = "Por favor ingresa un numero valido"
            } // VALIDAMOS SI ESTA VACIO
        } // CUANDO PULSE EL BOTON DE LLAMAR SE ABRIRA EL DIALER

        mibinding.backBtt.setOnClickListener {
            finish()
        } // BOTON PARA VOLVER AL MENU DE OPCIONES
    }
}
