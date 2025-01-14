package com.example.miprimerfragment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /** AÑADIR EL FRAGMENTO DESDE CODIGO -> FORMA 1 (no se hace)
        // CARGAR EL FRAGMENTO A:
        // OBTENGO UNA REFERENCIA DE UN FragmentTransaction
        val miFragmentoTransaction = supportFragmentManager.beginTransaction()

        // AÑADIR EL ACTIVITY UNA INSTANCIA DEL Fragmento_A
        // SE INVOCA AL METODO onCreateView DEL FRAGMENT Y SE LE PASA EL CONTENEDOR COMO PARAMETRO
        // Y UNA INSTANCIA DEL FRAGMENTO Y PODEMOS AÑADIRLE UNA ETIQUETA PARA LOCALIZAR FRAGMENTOS
        miFragmentoTransaction.add(R.id.fragmentContainerView, Fragmento_A(), "fragmentoA")

        // HACER COMMIT PORQUE SI NO LA ACCION NO SE REALIZA
        miFragmentoTransaction.commit()

        // CON ESTOS TRES PASOS YA HEMOS AÑADIDO EL FRAGMENTO A LA ACTIVIDAD **/


        /** FORMA 2 MAS OPTIMA **/
        // CARGAR EL Fragmento_A CON LA FORMA MAS OPTIMIZADA
        supportFragmentManager.commit {
            // INVOCAR EL METODO -> REORDENA LA PILA DE FRAGMENTOS PARA OPTIMIZAR LA CARGA DE
            // FRAGMENTOS DENTRO DE MI ACTIVIDAD
            setReorderingAllowed(true)
            add<Fragmento_A>(R.id.fragmentContainerView)
        }

    }
}