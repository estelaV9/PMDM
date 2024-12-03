package com.example.ejemplo_intentexplicita

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejemplo_intentexplicita.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // NOS CREA TANTAS CLASES COMO TANTAS CLASES DE ACTIVIDAD HAYA
    // DE ESTA MANERA, ACCEDE A LOS COMPONENTES DEL LAYOUT DE UNA FORMA MAS DIRECTA
    // Y NO TENER QUE DECLARA TANTOS OBJETOS COMO COMPONENTES HAYA EN EL LAYOUT
    lateinit var mibinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        inicializarComponentes() // LLAMAR AL METODO PARA INICIALIZAR COMPONENTES
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun inicializarComponentes() {
        // SE INSTANCIA EL OBJETO binding
        mibinding = ActivityMainBinding.inflate(layoutInflater)

        // ESTABLECE EL LAYOUT A MI ACTIVIDAD
        setContentView(mibinding.root) // EL ROOT ES LA PROPIEDAD QUE ME PERMITE ACCEDER A LA RAIZ DEL LAYOUT

        // LISTENER AL BOTON
        mibinding.irActBBtt.setOnClickListener {
            // CUANDO PULSEMOS EL BOTON, ABRIREMOS LA ACTIVIDAD B, PARA ELLO CREAMOS UN INTENT EXPLICITO
            // LE PASAMOS EL CONTEXTO Y REFERENCIAMOS LA ACTIVIDAD B
            var miIntent = Intent(this, ActivityB::class.java)

            // UNA VEZ REFERENCIADA, ABRIMOS LA ACTIVIDAD B
            startActivity(miIntent)
        }
    } // METODO PARA INICIALIZAR
}