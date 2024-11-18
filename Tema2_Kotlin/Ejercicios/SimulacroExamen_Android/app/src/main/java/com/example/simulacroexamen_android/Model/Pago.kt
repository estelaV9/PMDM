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
        if (!completada) {
            completada = true
            println("Pago de $cantidad procesado exitosamente el $fechaPago mediante $metodoPago.")
        } else {
            println("El pago de $cantidad ya estaba completado.")
        }
        /*marcarComoCompletada() // LLAMAR AL METODO CLASE SUPERIOR
        // MOSTRAR UN MENSAJE (Toast), PAGO PROCESADO
        context.mensaje("Pago procesado")*/
    } // LLAMAR AL METODO MARCARCOMOCOMLETADA Y MOSTRAR UN MENSAJE

    override fun mostrarDetalle() {
        println("Cantidad: $cantidad")
        println("Fecha de Pago: $fechaPago")
        println("Método de Pago: $metodoPago")
        println("Estado: ${if (completada) "Completado" else "Pendiente"}")
    } // RETORNA STRING CON LA DESCRIPCION DE UN PAGO

    // Algoritmo para detectar pagos duplicados
    fun detectarPagosDuplicados(pagos: List<Pago>): List<Pair<Pago, Pago>> {
        val duplicados = mutableListOf<Pair<Pago, Pago>>()

        for (i in pagos.indices) {
            for (j in i + 1 until pagos.size) {
                val pago1 = pagos[i]
                val pago2 = pagos[j]

                // Comprobamos duplicados por monto, fecha y método de pago
                if (pago1.cantidad == pago2.cantidad &&
                    pago1.fechaPago == pago2.fechaPago &&
                    pago1.metodoPago == pago2.metodoPago
                ) {
                    duplicados.add(pago1 to pago2)
                }
            }
        }

        return duplicados
    }

    // Algoritmo para calcular total de pagos pendientes y completados
    fun calcularTotalesPagos(pagos: List<Pago>): Pair<Double, Double> {
        val totalPendiente = pagos.filter { !it.completada }.sumOf { it.cantidad }
        val totalCompletado = pagos.filter { it.completada }.sumOf { it.cantidad }

        println("Total pendiente: $$totalPendiente")
        println("Total completado: $$totalCompletado")

        return totalPendiente to totalCompletado
    }


    fun ArrayList<Pago>.calcular(funcion: (Pago) -> Double): Double {
        var resultado: Double = 0.0
        this.forEach { resultado += funcion(it) }
        return resultado
    }
}