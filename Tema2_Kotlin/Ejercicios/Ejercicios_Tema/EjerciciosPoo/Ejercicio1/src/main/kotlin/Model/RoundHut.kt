package org.example.Model

import kotlin.math.PI // IMPORTAR PI
import kotlin.math.sqrt // IMPORTAR LA FUCION sqrt()

// open para que puedan heredar de ella
// SE PASA EL RADIO
open class RoundHut(residents: Int, val radius: Double) : Dwelling(residents) {
    override val buildingMaterial = "Straw"
    override val capacity = 4

    override fun floorArea(): Double {
        // La superficie de la planta de una vivienda circular es igual a PI * radio * radio.
       return PI * radius * radius
    } // IMPLEMENTAR LA FUNCION DE LA CLASE ABSTRACTA

    fun calculateMaxCarpetLength(): Double {
        // CALCULA LA LONGUITUD DE LA ALFOMBRA CUADRADA QUE PUEDE CABER
        // EN UN CIRCULO : sqrt(2) * radius
        return sqrt(2.0) * radius
    } // METODO SABER LA LONGUITUD DE UN LADO DE LA ALFOMBRA PARA COLOCARLA
}