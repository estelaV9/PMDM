package com.example.ejer3pg45_login

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.ejer3pg45_login.databinding.ActivityMainBinding
import com.example.ejer3pg45_login.model.User

class MainActivity : AppCompatActivity() {
    private lateinit var mibinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // INICIALIZAMOS ViewBinding
        mibinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mibinding.root) // SE VINCULA A LA RAIZ DEL LAYOUT

        // USUARIO QUE PODRA ACCEDER AL SISTEMA
        var user = User("admin", "admin")

        mibinding.alertTV.visibility = View.INVISIBLE // SE INCIA INVISIBLE LA ALERTA

        mibinding.entrarBtt.setOnClickListener {
            if (user.isValid(
                    mibinding.nameUserET.text.toString(),
                    mibinding.passwordET.text.toString()
                )
            ) {
                // SI LAS CREDENCIALES COINCIDEN, REDIRIGIRA AL SISTEMA
                val miIntent = Intent(this, MenuOpciones::class.java)
                startActivity(miIntent)
            } else {
                // SI LAS CREDENCIALES NO COINCIDEN, SE MUESTRA LA ALERTA
                mibinding.alertTV.visibility = View.VISIBLE
            } // SE VALIDA QUE SEAN LAS CREDENCIALES DEL USUARIO
        } // CUANDO SE PULSE EL BOTON SE VALIDARA Y ENTRARA EN EL SISTEMA
    }
}