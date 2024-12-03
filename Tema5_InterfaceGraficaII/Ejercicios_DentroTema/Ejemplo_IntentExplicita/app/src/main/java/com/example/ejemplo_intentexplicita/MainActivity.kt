package com.example.ejemplo_intentexplicita

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.ejemplo_intentexplicita.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // NOS CREA TANTAS CLASES COMO TANTAS CLASES DE ACTIVIDAD HAYA
    // DE ESTA MANERA, ACCEDE A LOS COMPONENTES DEL LAYOUT DE UNA FORMA MAS DIRECTA
    // Y NO TENER QUE DECLARA TANTOS OBJETOS COMO COMPONENTES HAYA EN EL LAYOUT
    private lateinit var mibinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        inicializarComponentes() // LLAMAR AL METODO PARA INICIALIZAR COMPONENTES
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
            val miIntent = Intent(this, ActivityB::class.java)

            // CREAR EL BUNDLE
            val miBundle = Bundle()
            // RELLENO EL BUNDLE
            miBundle.putString("datos1", mibinding.editText.text.toString())
            miBundle.putInt("dato2", 4)
            // VINCULO EL BUNDLE AL INTENT
            miIntent.putExtras(miBundle)

            // ABRIR LA ACTIVIDAD B
            startActivity(miIntent)
        }
    } // METODO PARA INICIALIZAR
}