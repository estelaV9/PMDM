package com.example.ejemplostiposclasesenum_android

import android.os.Build
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

/** Ejercicio: Defina una aplicación android que permita cambiar el color de fondo de la app,
 * en función del radioButton seleccionado, se mostrará el color seleccionadoen un TextView. **/
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // OBTENER LA REFERENCA DEL RADIO GROUP
        var radioGrupo_Colores = findViewById<RadioGroup>(R.id.radio_group_color)

        /***************************** UNA FORMA *******************************/
        // AGREGAR UN ESCUCHADOR PARA EL COMPONENTE DEL RADIO GROUP
        radioGrupo_Colores.setOnCheckedChangeListener((object : RadioGroup.OnCheckedChangeListener {
            var radio_verde = findViewById<RadioButton>(R.id.radioVerde)
            var radio_azul = findViewById<RadioButton>(R.id.radioAzul)
            var radio_rojo = findViewById<RadioButton>(R.id.radioRojo)
            var radio_negro = findViewById<RadioButton>(R.id.radioNegro)
            var miLayout =
                findViewById<ConstraintLayout>(R.id.main) // CONTENEDOR DE TODA LA PANTALLA

            @RequiresApi(Build.VERSION_CODES.O)
            override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
                when (p1) {
                    radio_rojo.id -> // CAMBIAR EL COLOR A ROJO
                        miLayout.setBackgroundColor(Vcolor.ROJO.retornar_Color().toArgb())

                    radio_negro.id -> // CAMBIAR EL COLOR A NEGRO
                        miLayout.setBackgroundColor(Vcolor.NEGRO.retornar_Color().toArgb())

                    radio_verde.id -> // CAMBIAR EL COLOR A VERDE
                        miLayout.setBackgroundColor(Vcolor.VERDE.retornar_Color().toArgb())

                    radio_azul.id -> // CAMBIAR EL COLOR A AZUL
                        miLayout.setBackgroundColor(Vcolor.AZUL.retornar_Color().toArgb())
                }
            }
        }))
    }
}