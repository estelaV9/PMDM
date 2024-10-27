package com.example.ejer5_filtrarfunciones

import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // ESTABLECER ARRAY DE ENTEROS Y METER LOS 100 PRIMEROS NUMEROS
        val arrayEnteros: MutableList<Int> = mutableListOf()
        for (i in 1..100){
            arrayEnteros.add(i)
        }

        // ATRIBUTOS RADIOBUTTONS
        var radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        var filtraPrimos = findViewById<RadioButton>(R.id.primosRd)
        var filtraMagigos = findViewById<RadioButton>(R.id.magicosRd)
        var filtraCapicuas = findViewById<RadioButton>(R.id.capicuasRd)

        var numerosTF = findViewById<TextView>(R.id.seMuestraArray)
        //var filtrarTF = findViewById<TextView>(R.id.seMuestraArrayFiltrado)


        numerosTF.text = arrayEnteros.toString()


    }
}