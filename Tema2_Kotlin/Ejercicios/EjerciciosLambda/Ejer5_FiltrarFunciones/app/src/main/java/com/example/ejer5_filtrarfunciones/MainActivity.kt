package com.example.ejer5_filtrarfunciones

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
        for (i in 1..100) {
            arrayEnteros.add(i)
        }

        // ATRIBUTOS ID
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val numerosTF = findViewById<TextView>(R.id.seMuestraArray)
        val filtrarTF = findViewById<TextView>(R.id.seMuestraArrayFiltrado)


        numerosTF.text = arrayEnteros.toString() // SETEAR EL ARRAY EN EL TEXTFIELD

        // PARA DETECTAR CUANDO SE PULSA UN RADIOBUTTON SE UTILIZA EL METODO setOnCheckedChangeListener
        // EN EL RADIOGROUP CON LOS PARAMETROS DE UN RADIOBUTTON NULO Y UN INT QUE SERA EL ID
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            // SWITCH DE LOS ID DE LOS RADIOBUTTONS
            when (checkedId) {
                R.id.primosRd -> { // FILTRAR NUMEROS PRIMOS
                    /*filtrarTF.text =
                        filtrarNumerosPrimos(arrayEnteros.toList()).toString() // LLAMAR A LA FUNCION DE FILTRAR NUMEROS PRIMOS
                */}

                R.id.magicosRd -> { // FILTRAR NUMEROS MAGICOS
                    filtrarTF.text =
                        filtrarNumerosMagicos(arrayEnteros.toList()).toString() // LLAMAR A LA FUNCION DE FILTRAR NUMEROS MAGICOS
                }

                R.id.capicuasRd -> { // FILTRAR NUMEROS CAPICUAS
                    //filtrarNumerosCapicuas(arrayEnteros.toList()) // LLAMAR A LA FUNCION DE FILTRAR NUMEROS CAPICUAS
                }
            }
        }
    }

    /*fun filtrarNumerosPrimos (arrayEnteros: List<Int>): Array<Int>{

    }*/

    fun filtrarNumerosMagicos (arrayEnteros: List<Int>): List<Int>{
        // LOS NUMEROS MAGICOS SON AQUELLOS QUE AL ELEVAR EL NUMERO AL CUBO, SUMANDO LOS DIGITOS
        // SALE ESE NUMERO
        val arrayNumerosMagicos:MutableList<Int> = mutableListOf() // ARRAY PARA AÑADIR LOS NUMEROS MAGICOS
        var numeroCubo: Int // ATRIBUTO PARA GUARDAR EL RESULTADO DEL NUMERO ELEVADO AL CUBO
        var numAux: Int // ATRIBUTO AUXILIAR DEL NUMERO AL CUBO PARA OPERAR CON EL

        for(i in arrayEnteros) {
            numeroCubo = i * i * i // SE ELEVA AL CUBO
            numAux = numeroCubo // SE ESTABLECE EL NUMERO AUXILIAR

            // INICIALIZAR DENTRO DEL BUCLE PARA QUE EN CADA INTERACION SE RESETEE
            val arrayDigitos:MutableList<Int> = mutableListOf()
            while (numAux > 0) {
                arrayDigitos.add(numAux % 10) // SE AÑADE EL RESTO
                numAux /= 10 // SE DIVIDE ENTRE 10
            } // MIENTRAS TENGA DIGITOS SEGUIRA EL BUCLE

            if(arrayDigitos.sum() == i) {
                arrayNumerosMagicos.add(i)
            } // SI LA SUMA DE LOS DIGITOS ES IGUAL A i ENTONCES SE AÑADE AL ARRAY
        } // SE RECORRE EL ARRAY DE ENTEROS
        return arrayNumerosMagicos.toList() // RETORNA EL ARRAY CON LOS NUMEROS MAGICOS
    } // METODO PARA FILTRAR LOS NUMEROS MAGICOS

    /*fun filtrarNumerosCapicuas (arrayEnteros: List<Int>): Array<Int>{

    }*/
}