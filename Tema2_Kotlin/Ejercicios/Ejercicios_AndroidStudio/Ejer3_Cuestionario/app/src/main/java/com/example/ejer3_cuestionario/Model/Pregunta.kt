package com.example.ejer3_cuestionario.Model

class Pregunta(pregunta: String) {

    enum class TipoDificultad {
        FACIL, MEDIA, ALTA
    }

    var pregunta: String = ""
    lateinit var dificultad: TipoDificultad
    var respuesta: String = ""

    constructor(pregunta: String, dificultad: TipoDificultad, respuesta: String)
            : this(pregunta) {
        this.pregunta = pregunta
        this.dificultad = dificultad
        this.respuesta = respuesta
    }


    fun corregirRespuesta (respuesta: String): Boolean {
        return respuesta == this.respuesta
    }
}