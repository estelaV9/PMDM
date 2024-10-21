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
        setContentView(R.layout.activity_main) // ESTABLECE EL LAYOUT DE LA ACTIVIDAD

        // OBTENER LA REFERENCA DEL RADIO GROUP
        var radioGrupo_Colores =
            findViewById<RadioGroup>(R.id.radio_group_color) // ENLAZA EL RADIOGROUP AL CODIGO

        /***************************** UNA FORMA *******************************/
        // AGREGAR UN ESCUCHADOR PARA EL COMPONENTE DEL RADIO GROUP
        radioGrupo_Colores.setOnCheckedChangeListener((object : RadioGroup.OnCheckedChangeListener {
            // OBTENER LAS REFERENCIAS A CADA RADIOBUTTON
            var radio_verde = findViewById<RadioButton>(R.id.radioVerde)
            var radio_azul = findViewById<RadioButton>(R.id.radioAzul)
            var radio_rojo = findViewById<RadioButton>(R.id.radioRojo)
            var radio_negro = findViewById<RadioButton>(R.id.radioNegro)
            var miLayout =
                findViewById<ConstraintLayout>(R.id.main) // CONTENEDOR DE TODA LA PANTALLA

            @RequiresApi(Build.VERSION_CODES.O) // REQUIERE UNA API MINIMA PARA USAR 'toArgb()'
            override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
                // CAMBIAR DEL COLOR DEL FONDO SEGUN EL RADIOBUTTON SELECCIONADO
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

        /***************************** SEGUNDA FORMA *******************************/
        /*  // CREAMOS UN SETONCHECKEDCHANListener QUE NOS PEDIRÁ EL RADIOGROUP QUE HEMOS GUARDADO
        // ANTERIORMENTE Y CHECKEDID QUE ES VARIABLE DEFINIDA POR ANDROID STUDIO
        radiogroup.setOnCheckedChangeListener{radioGroup,checkedId ->
            // COGES EL ID DEL PANEL PRINCIPAL QUE QUIERES CAMBIAR DE COLOR, ESTÁ ASÍ EN EL XML --> android:id="@+id/main"
            val mainLayout = findViewById<ConstraintLayout>(R.id.main)

            when (checkedId) { // VERIFICAMOS CUAL RADIOBUTTON FUE SELECCIONADO
                R.id.RbRojo -> { // SI SE SELECCIONA ROJO
                    val colorRojo:Int = Vcolor.ROJO.retornarColor() // OBTENEMOS EL COLOR ROJO
                    mainLayout.setBackgroundColor(colorRojo) // CAMBIAMOS EL FONDO AL COLOR ROJO
                }
                R.id.RbAzul -> { // SI SE SELECCIONA AZUL
                    val colorAzul:Int = Vcolor.AZUL.retornarColor() // OBTENEMOS EL COLOR AZUL
                    mainLayout.setBackgroundColor(colorAzul) // CAMBIAMOS EL FONDO AL COLOR AZUL
                }
                R.id.RbVerde -> { // SI SE SELECCIONA VERDE
                    val colorVerde:Int = Vcolor.VERDE.retornarColor() // OBTENEMOS EL COLOR VERDE
                    mainLayout.setBackgroundColor(colorVerde) // CAMBIAMOS EL FONDO AL COLOR VERDE
                }
                R.id.RbNegro -> { // SI SE SELECCIONA NEGRO
                    val colorNegro:Int = Vcolor.NEGRO.retornarColor() // OBTENEMOS EL COLOR NEGRO
                    mainLayout.setBackgroundColor(colorNegro) // CAMBIAMOS EL FONDO AL COLOR NEGRO
                }
            }
        }

        // CAMBIAR LA FUNCION PARA QUE DEVUELVA DIRECTAMENTE UN VALOR PREDEFINIDO
        fun retornarColor(): Int { // FUNCIÓN PARA RETORNAR EL COLOR
            return when(this) { // VERIFICAR CUAL ES EL COLOR ACTUAL
                ROJO->Color.RED // RETORNAR COLOR ROJO
                AZUL->Color.BLUE // RETORNAR COLOR AZUL
                VERDE->Color.GREEN // RETORNAR COLOR VERDE
                NEGRO->Color.BLACK // RETORNAR COLOR NEGRO
            }
        } */
    }
}