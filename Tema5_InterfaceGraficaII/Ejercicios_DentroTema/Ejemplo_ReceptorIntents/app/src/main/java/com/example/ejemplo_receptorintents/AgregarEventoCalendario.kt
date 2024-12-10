package com.example.ejemploreceptorintents

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejemplo_receptorintents.R
import com.example.ejemplo_receptorintents.databinding.ActivityAgregarEventoCalendarioBinding

class AgregarEventoCalendario : AppCompatActivity() {
    lateinit var mibinding: ActivityAgregarEventoCalendarioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mibinding = ActivityAgregarEventoCalendarioBinding.inflate(layoutInflater)
        setContentView(mibinding.root)

        // ESTABLEZCO UNA ESCUCHA PARA LOS MÁRGENES DEL SISTEMA
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // RECIBO LOS DATOS DEL EVENTO DE CALENDARIO, PERO EL LAYOUT NO ESTÁ COMPLETADO
        // FALTA MOSTRAR LA INFORMACIÓN DEL EVENTO RECIBIDA EN LA INTENT
    }
}