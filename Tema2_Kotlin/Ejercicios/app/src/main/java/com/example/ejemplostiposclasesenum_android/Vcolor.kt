package com.example.ejemplostiposclasesenum_android

import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresApi

// CLASE TIPO ENUM
enum class Vcolor (num_color:Int, nombre_color:String){
    /** nota: puede contener propiedades, si se definen en el constructor principal sera necesario
     * inicializar cada valor del enum. Los objetos tendran esas nuevas propiedades
     * Rojo(1,"Red")**/
    ROJO(1, "RED"), AZUL(2, "BLUE"),
    VERDE(3, "GREEN"), NEGRO(4, "BLACK"); // COLORES DISPONIBLES

    @RequiresApi(Build.VERSION_CODES.O) // REQUIERE UNA VERSION MINIMA DE API
    fun retornar_Color(): Color {
        return when (this) { // EL THIS HACE REFERENCIA AL COLOR QUE CUANDO INVOQUEMOS A LA FUNCION SE DEFINA (color actual)
            ROJO -> Color.valueOf(Color.RED) // RETORNA COLOR ROJO
            AZUL -> Color.valueOf(Color.BLUE) // RETORNA COLOR AZUL
            VERDE -> Color.valueOf(Color.GREEN) // RETORNA COLOR VERDE
            else -> Color.valueOf(Color.BLACK) // RETORNA COLOR NEGRO COMO VALOR POR DEFECTO
        }
    } // FUNCION PARA RETORNAR UN COLOR
}