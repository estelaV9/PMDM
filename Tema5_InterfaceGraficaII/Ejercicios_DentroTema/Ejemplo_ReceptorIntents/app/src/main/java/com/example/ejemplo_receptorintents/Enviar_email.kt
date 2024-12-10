package com.example.ejemploreceptorintents

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejemplo_receptorintents.R
import com.example.ejemplo_receptorintents.databinding.ActivityEnviarEmailBinding

class Enviar_email : AppCompatActivity() {
    lateinit var mibinding: ActivityEnviarEmailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mibinding = ActivityEnviarEmailBinding.inflate(layoutInflater)
        setContentView(mibinding.root)

        // ESTABLEZCO UNA ESCUCHA PARA LOS MÁRGENES DEL SISTEMA
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // OBTENGO LA INTENT Y LOS DATOS DEL EMAIL
        var miIntent = intent
        var datos = intent.data
        if (datos?.scheme.equals("mailto")) {
            mibinding.textDestinatario.text =
                miIntent.getStringArrayExtra(Intent.EXTRA_EMAIL)?.get(0) ?: ""
            mibinding.textAsunto.text = miIntent.getStringExtra(Intent.EXTRA_SUBJECT)
            mibinding.textMensaje.text = miIntent.getStringExtra(Intent.EXTRA_TEXT)
        }
    }
}