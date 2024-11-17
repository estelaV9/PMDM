package com.example.simulacroexamen_android.Model

import Model.Actividad
import Model.Recordatorio
import android.content.Context
import java.time.LocalDate

class Cita(
    nombre: String,
    completada: Boolean,
    var Fecha_hora: LocalDate, // DE LA CITA
    var lugar: String, // DIRECCION O LUGAR DE LA CITA
    var personas: ArrayList<Persona>? // DE LAS PERSONAS CON LAS QUE SE HA QUEDADO
) : Actividad(nombre, completada), Recordatorio {

    fun agreagarPersonaCita(persona: Persona): Boolean {
        for (p in personas!!) {
            if (p.dni == persona.dni) {
                return false
            } // SI TIENE EL MISMO DNI, RETORNA FALSE
        } // RECORRE LAS PERSONAS

        personas!!.add(persona)
        return true
    } // AGREGA UNA PERSONA A LA CITA

    override fun mostrarDetalle(): String {
        return "Cita: $nombre | Completada: $completada" +
                "Fecha y hora $Fecha_hora | Lugar: $lugar | personas: ${personas?.joinToString()}"
    } // DEVUELVE UN STRING CON EL DETALLE COMPLETO DE UNA CITA

    override fun programarRecordatorio(context: Context) {
        TODO("Not yet implemented")
    }

    override fun cancelarRecordatorio(context: Context) {
        TODO("Not yet implemented")
    }
}