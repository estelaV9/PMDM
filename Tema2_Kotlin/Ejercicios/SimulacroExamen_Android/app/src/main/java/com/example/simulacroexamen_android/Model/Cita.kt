package com.example.simulacroexamen_android.Model

import Model.Actividad
import Model.Recordatorio
import android.content.Context
import java.time.LocalDate

class Cita(
    override var nombre: String,
    override var completada: Boolean,
    var Fecha_hora: LocalDate, // DE LA CITA
    var lugar: String, // DIRECCION O LUGAR DE LA CITA
    var personas: MutableList<Persona>? = mutableListOf() // DE LAS PERSONAS CON LAS QUE SE HA QUEDADO
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

    override fun mostrarDetalle() {
        super.mostrarDetalle()
        println("Fecha y Hora: $Fecha_hora")
        println("Lugar: $lugar")
        println("Personas invitadas: ${personas?.joinToString { it.nombre }}")
    } // DEVUELVE UN STRING CON EL DETALLE COMPLETO DE UNA CITA

    override fun programarRecordatorio(context: Context) {
        println("Recordatorio programado para la cita '$nombre' en $Fecha_hora en $lugar")
    }

    override fun cancelarRecordatorio(context: Context) {
        println("Recordatorio cancelado para la cita '$nombre'")
    }
}