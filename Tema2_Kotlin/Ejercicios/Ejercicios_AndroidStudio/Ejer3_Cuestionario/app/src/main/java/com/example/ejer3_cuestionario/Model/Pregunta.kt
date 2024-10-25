package com.example.ejer3_cuestionario.Model

class Pregunta(
    var pregunta: String,
    var dificultad: TipoDificultad,
    var respuesta: Any // SE PONE ANY PARA QUE ACEPTE CUALQUIER DATO (int, bool..)
) {

    enum class TipoDificultad {
        FACIL, MEDIA, ALTA
    }


    fun <T> corregirRespuesta(respuesta: T): Boolean {
        return respuesta == this.respuesta
    }


}