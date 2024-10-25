package com.example.ejer3_cuestionario

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejer3_cuestionario.Model.Pregunta
import java.util.Scanner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val scanner = Scanner (System.`in`)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val pregunta1 = Pregunta("¿Cuál es la capital de Francia?",
            Pregunta.TipoDificultad.MEDIA, "París")

        val pregunta2 = Pregunta("¿Cuál es la respuesta correcta? a) Opción1 b) Opción2 c) Opción3 d) Opción4",
            Pregunta.TipoDificultad.ALTA, "b")

        val pregunta3 = Pregunta( "La Tierra es plana: verdadero o falso",
            Pregunta.TipoDificultad.FACIL, false)

        val pregunta4 = Pregunta( "¿Cuánto es 5 x 5?",
            Pregunta.TipoDificultad.FACIL,25)

        println("**************** CUESTIONARIO *********************")
        println(pregunta1.pregunta)
        var respuesta1 = scanner.nextLine()
        println(pregunta2.pregunta)
        var respuesta2 = scanner.nextLine()
        println(pregunta3.pregunta)
        var respuesta3 = scanner.nextBoolean()
        println(pregunta4.pregunta)
        var respuesta4 = scanner.nextInt()

        println("**************** CORRECCION *********************")
        if(pregunta1.corregirRespuesta(respuesta1)){
            println("Has acertado la 1")
        } else {
            println("Has fallado la 1, la respuesta correcta es " + pregunta1.respuesta)
        }

        if(pregunta2.corregirRespuesta(respuesta2)){
            println("Has acertado la 2")
        } else {
            println("Has fallado la 2, la respuesta correcta es " + pregunta2.respuesta)
        }

        if(pregunta3.corregirRespuesta(respuesta3)){
            println("Has acertado la 3")
        } else {
            println("Has fallado la 3, la respuesta correcta es " + pregunta3.respuesta)
        }

        if(pregunta1.corregirRespuesta(respuesta4)){
            println("Has acertado la 4")
        } else {
            println("Has fallado la 4, la respuesta correcta es " + pregunta4.respuesta)
        }


    }
}