package com.example.ejemplo_intentexplicita

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.ejemplo_intentexplicita.databinding.ActivityBBinding
import com.example.ejemplo_intentexplicita.databinding.ActivityMainBinding

class ActivityB : AppCompatActivity() {
    lateinit var mibinding: ActivityBBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        inicializarComponentes() // LLAMAR AL METODO PARA INICIALIZAR COMPONENTES
    }

    private fun inicializarComponentes(){
        // SE INSTANCIA EL OBJETO binding
        mibinding = ActivityBBinding.inflate(layoutInflater)

        // ESTABLECE EL LAYOUT A MI ACTIVIDAD
        setContentView(mibinding.root) // EL ROOT ES LA PROPIEDAD QUE ME PERMITE ACCEDER A LA RAIZ DEL LAYOUT

        // LISTENER AL BOTON
        mibinding.finalizarActBBtt.setOnClickListener {
            finish()
        }
    } // METODO PARA INICIALIZAR
}