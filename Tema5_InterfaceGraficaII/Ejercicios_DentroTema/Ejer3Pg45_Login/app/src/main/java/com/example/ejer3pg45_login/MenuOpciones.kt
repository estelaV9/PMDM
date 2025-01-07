package com.example.ejer3pg45_login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejer3pg45_login.databinding.ActivityMenuOpcionesBinding
import com.example.ejer3pg45_login.menu_options_screen.EnviarSMS
import com.example.ejer3pg45_login.menu_options_screen.Llamar
import com.example.ejer3pg45_login.menu_options_screen.Navegar

class MenuOpciones : AppCompatActivity() {
    private lateinit var mibinding: ActivityMenuOpcionesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // INICIALIZAMOS ViewBinding
        mibinding = ActivityMenuOpcionesBinding.inflate(layoutInflater)
        setContentView(mibinding.root)

        mibinding.navegarBtt.setOnClickListener {
            val miIntent = Intent(this, Navegar::class.java)
            startActivity(miIntent)
        } // IR A LA PANTALLA NAVEGAR

        mibinding.llamarBtt.setOnClickListener {
            val miIntent = Intent(this, Llamar::class.java)
            startActivity(miIntent)
        } // IR A LA PANTALLA LLAMAR

        mibinding.enviarSmsBtt.setOnClickListener {
            val miIntent = Intent(this, EnviarSMS::class.java)
            startActivity(miIntent)
        } // IR A LA PANTALLA DE ENVIAR UN SMS
    }
}