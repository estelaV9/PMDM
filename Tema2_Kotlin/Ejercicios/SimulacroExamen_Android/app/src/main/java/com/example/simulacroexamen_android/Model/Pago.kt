package com.example.simulacroexamen_android.Model

import Model.Actividad
import android.content.Context
import com.example.simulacroexamen_android.Utilities.mensaje
import java.time.LocalDate

class Pago(
    var cantidad: Double,
    var fechaPago: LocalDate,
    var metodoPago: String,
    nombre: String,
    completada: Boolean
) : Actividad(nombre, completada) {

    fun procesarPago(context: Context): Unit {
        marcarComoCompletada() // LLAMAR AL METODO CLASE SUPERIOR
        // MOSTRAR UN MENSAJE (Toast), PAGO PROCESADO
        context.mensaje("Pago procesado")
    } // LLAMAR AL METODO MARCARCOMOCOMLETADA Y MOSTRAR UN MENSAJE

    override fun mostrarDetalle(): String {
        return "Pago: Cantidad: $cantidad, Fecha de pago: $fechaPago, Método: $metodoPago]"
    } // RETORNA STRING CON LA DESCRIPCION DE UN PAGO
}