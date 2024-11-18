package com.example.simulacroexamen_android

import Model.Actividad
import Model.Tarea
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.simulacroexamen_android.Model.Cita
import com.example.simulacroexamen_android.Model.Pago
import com.example.simulacroexamen_android.Model.Persona
import com.example.simulacroexamen_android.Utilities.filtrarPagosPor
import com.example.simulacroexamen_android.Utilities.filtrarPor
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var citaRD = findViewById<RadioButton>(R.id.citaRD)
        var tareaRD = findViewById<RadioButton>(R.id.tareaRD)
        var pagoRD = findViewById<RadioButton>(R.id.pagoID)
        val button = findViewById<Button>(R.id.button)

        lateinit var radioButtonSeleccionado: RadioButton
        lateinit var activity: Class<*>
        val radiogroup = findViewById<RadioGroup>(R.id.radioGroup)

        //CUANDO CAMBIA EL RADIOBUTTON SELECCIONADO DEL RADIOGROUP, SE GUARDA EN checkedId
        radiogroup.setOnCheckedChangeListener { group, checkedId ->
            //COJO EL RADIOBUTTON SELECCIONADO (checkedId)
            radioButtonSeleccionado = findViewById(checkedId)

            when (checkedId) {
                R.id.tareaRD -> activity = TareaActivity::class.java
            }
        }

        button.setOnClickListener {
            val intent = Intent(this, activity)
            startActivity(intent)
        }


        // CREAR PERSONAS
        val listaPersonas = ArrayList<Persona>()
        val persona1 = Persona("Ana", "12345678A")
        val persona2 = Persona("Paco", "23456789B")
        val persona3 = Persona("Luis", "34567890C")
        listaPersonas.addAll(listOf(persona1, persona2, persona3))

        // CREAR ACTIVIDADES
        val listaActividades = ArrayList<Actividad>()

        // CREAR CITAS
        val cita1 =
            Cita("Reunión", false, LocalDate.of(2024, 1, 15), "Oficina", arrayListOf(persona1))
        val cita2 = Cita(
            "Encuentro",
            false,
            LocalDate.of(2024, 2, 20),
            "Parque",
            arrayListOf(persona1, persona2)
        )
        val cita3 = Cita("Visita", true, LocalDate.now(), "Museo", null)
        listaActividades.addAll(listOf(cita1, cita2, cita3))

        // CREAR TAREAS
        val tarea1 = Tarea("Proyecto Kotlin", false, null, null, Tarea.Urgencia.ALTO)
        val tarea2 =
            Tarea("Revisar diseño", true, LocalDate.of(2023, 12, 1), null, Tarea.Urgencia.MEDIO)
        val tarea3 = Tarea(
            "Actualizar reportes",
            false,
            LocalDate.of(2024, 3, 15),
            null,
            Tarea.Urgencia.ALTO
        )
        listaActividades.addAll(listOf(tarea1, tarea2, tarea3))

        // FILTRAR LAS TAREAS CON NIVEL DE URGENCIA ALTO
        val tareasUrgenciaAlta = listaActividades.filtrarPor {
            it is Tarea && it.urgencia == Tarea.Urgencia.ALTO
        }
        println("Tareas con urgencia ALTA:")
        tareasUrgenciaAlta.forEach { println(it.mostrarDetalle()) }

        // FILTRAR LAS CITAS QUE INCLUYAN A ANA
        val citasConAna = listaActividades.filtrarPor {
            it is Cita && it.personas?.any { persona -> persona.nombre == "Ana" } == true
        }
        println("\nCitas con Ana:")
        citasConAna.forEach { println(it.mostrarDetalle()) }

        // FILTRAR PAGOS REALIZADOS (COMPLETADOS)
        val pagos = ArrayList<Actividad>()
        val pago1 = Pago(150.0, LocalDate.now(), "Bizum", "Pago alquiler", true)
        val pago2 = Pago(200.0, LocalDate.of(2024, 2, 5), "Transferencia", "Pago luz", false)
        pagos.addAll(listOf(pago1, pago2))

        val pagosCompletados = pagos.filtrarPor { it.completada }
        println("\nPagos completados:")
        pagosCompletados.forEach { println(it.mostrarDetalle()) }


        // CREAR ALGUNOS PAGOS
        val pago5 = Pago(100.0, LocalDate.of(2024, 1, 1), "Bizum", "Pago 1", true)
        val pago6 = Pago(200.0, LocalDate.of(2023, 6, 15), "Efectivo", "Pago 2", false)
        val pago7 = Pago(300.0, LocalDate.of(2024, 12, 31), "Transferencia", "Pago 3", true)
        val pago8 = Pago(400.0, LocalDate.now(), "Bizum", "Pago 4", true)

        // LISTA DE PAGOS
        val listaPagos = arrayListOf(pago5, pago6, pago7, pago8)

        // TOTAL DE LOS PAGOS COMPLETADOS
        val totalPagosCompletados = listaPagos.filtrarPagosPor { it.completada }
        println("Total de pagos completados: $totalPagosCompletados €")

        // TOTAL DE LOS PAGOS DEL 2024
        val pagos2024 = listaPagos.filtrarPagosPor { it.fechaPago.year == 2024 }
        println("Total de pagos del 2024: $pagos2024 €")


        // EN UNA FUNCION PRINCIPAL, PRUEBA LA FUNCIONALIDAD ANTERIOR
        // DEBERA CREAR UNA LISTA DE TAREAS, DE CITAS Y DE PAGOS
        val listaTarea = ArrayList<Actividad>()
        val listaCita = ArrayList<Actividad>()
        val listaPago = ArrayList<Actividad>()

        // DEFINIR UNA FUNCION QUE PERMITA AÑADIR UNA NUEVA CITA A UN ARRAYLIST
        // MIENTRAS NO COINCIDA EN FECHA Y HORA CON LAS EXISTENTES
        fun nuevaCita(cita: Cita) {
            val existeCita = listaCita.filtrarPor {
                it is Cita && it.Fecha_hora == cita.Fecha_hora
            } // VERIFICAR SI EXISTE UNA CITA CON LA MISMA FECHA Y HORA

            if (existeCita.isEmpty()) {
                listaCita.add(cita)
            } // SI NO EXISTE LA CITA, SE AÑADE
        }
    }
}