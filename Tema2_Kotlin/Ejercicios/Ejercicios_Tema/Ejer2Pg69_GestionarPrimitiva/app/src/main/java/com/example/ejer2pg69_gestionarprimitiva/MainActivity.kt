package com.example.ejer2pg69_gestionarprimitiva

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var contador = 0 // CONTADOR PARA SABER LAS VECES QUE HA PULSADO EL BOTON
        val numRandomSinRepetidos = generarNumerosPrimitiva().toList() // LISTA CON LOS NUMEROS SIN DUPLICAR

        val textView = findViewById<TextView>(R.id.numeroPrimitivaTV)
        val generarBtt = findViewById<Button>(R.id.generarBtt)

        generarBtt.setOnClickListener {
            if (contador < numRandomSinRepetidos.size) {
                textView.text = numRandomSinRepetidos[contador].toString() // MOSTRAMOS EL NUMERO ACTUAL                contador++
            } else {
                textView.text = "Ya no hay más números." // Mensaje si se acaban los números
            } // MOSTRARA EL NUMERO DENTRO DEL RANDO DE LA LISTA, CUANDO SE PASE MOSTRARA UN MENSAJE
        } // CUANDO PULSE EL BOTON MOSTRARA EL NUMERO
    }

    /** LA PRIMITIVA SON 6 NUMEROS ENTRE EL 1 AL 49 SIN DUPLICAR **/
    fun generarNumerosPrimitiva(): Set<Int> {
        val numerosGenerados: MutableSet<Int> =
            mutableSetOf() // CREAMOS LA LISTA SET PARA EVITAR DUPLICADOS

        while (numerosGenerados.size < 6) {
            val randomNumber =
                (1..49).random() // GENERAR UN NUMERO ALEATORIO ENTRE 1 Y 49
            numerosGenerados.add(randomNumber) // AÑADIR EL NUMERO ALEATORIO A LA LISTA
        } // MIENTRAS EL TAMAÑO DE LA LISTA SEA MENOR QUE 6 ENTONCES AÑADIRA NUMEROS

        return numerosGenerados.toSet() // DEVUELVE LOS NUMEROS GENERADOS
    } // FUNCION PARA GENERAR LOS 6 NUMEROS DE LA PRIMITIVA
}