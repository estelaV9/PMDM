package com.example.ejer2pg69_gestionarprimitiva

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.time.TestTimeSource

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var contador = 0 // CONTADOR PARA SABER LAS VECES QUE HA PULSADO EL BOTON

        val textView = findViewById<TextView>(R.id.numeroPrimitivaTV)
        val generarBtt = findViewById<Button>(R.id.generarBtt)
        val numIngetroTV = findViewById<TextView>(R.id.numeroReintegro)

        generarBtt.setOnClickListener {
            // CADA VEZ QUE SE HAGA CLICK AL BOTON SE GENERAN NUEVOS NUMEROS DE LA PRIMITIVA Y EL NUMERO DEL REINTEGRO
            val numRandomSinRepetidos = generarNumerosPrimitiva().toList() // LISTA CON LOS NUMEROS SIN DUPLICAR
            var numeroRandomReintegro = (1..9).random() // VARIABLE PARA GUARDAR EL NUMERO DE REINTEGRO

            // MOSTRAR DIRECTAMENTE LOS 6 NUMEROS Y EL REINTEGRO CUANDO SE PULSE EL BOTON
            textView.text = numRandomSinRepetidos.joinToString()
            numIngetroTV.text = "El número de reintegro es : $numeroRandomReintegro" // SE MUESTRA EL REINTEGRO

            /* IR MOSTRANDO DE NUMERO A NUMERO
            // GENERAR NUMERO ALEATORIO DEL 1 AL 9 PARA EL REINTEGRO
            numIngetroTV.text = "El número de reintegro es : $numeroRandomReintegro" // SE MUESTRA EL REINTEGRO

            // SI HAY MAS NUMEROS EN LA LISTA LOS SEGUIRA MOSTRANDO
            if (contador < numRandomSinRepetidos.size) {
                textView.text = numRandomSinRepetidos[contador].toString() // MOSTRAMOS EL NUMERO ACTUAL
                contador++
            } else {
                textView.text = "Ya no hay más números." // Mensaje si se acaban los números
            } // MOSTRARA EL NUMERO DENTRO DEL RANDO DE LA LISTA, CUANDO SE PASE MOSTRARA UN MENSAJE*/
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