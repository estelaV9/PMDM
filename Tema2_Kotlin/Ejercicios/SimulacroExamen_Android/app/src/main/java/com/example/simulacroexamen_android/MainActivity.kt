package com.example.simulacroexamen_android

import Model.Actividad
import Model.Tarea
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.simulacroexamen_android.Model.Cita
import com.example.simulacroexamen_android.Model.Persona
import com.example.simulacroexamen_android.Utilities.filtrarPor
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val listaPersonas = ArrayList<Persona>()
        var persona1 = Persona("persona1", "1")
        var persona2 = Persona("persona2", "2")
        var persona3 = Persona("persona3", "3")

        listaPersonas.add(persona1)
        listaPersonas.add(persona2)
        listaPersonas.add(persona3)

        val listaActividades = ArrayList<Actividad>()
        var actividad1 = Cita("Ana", false, LocalDate.now(), "lugar1", listaPersonas)
        var actividad2 = Cita("Ana", true, LocalDate.now(), "lugar2", listaPersonas)
        var actividad3 = Cita("Paco", true, LocalDate.now(), "lugar3", listaPersonas)
        var actividad4 = Cita("Ana", false, LocalDate.now(), "lugar4", listaPersonas)

        listaActividades.add(actividad1)
        listaActividades.add(actividad2)
        listaActividades.add(actividad3)
        listaActividades.add(actividad4)

        // FILTRAR LAS TAREAS CON NIVEL URGENCIA ALTO
        val tarea1 = Tarea("Tarea1", false, null, null, Tarea.Urgencia.ALTO)
        val notificacion1 = tarea1.Notificacion(LocalDate.now(), true) // CREAR NOTIFICACION
        tarea1.notificacion = notificacion1 // ASIGNARLA A LA TAREA

        val tarea2 = Tarea("Tarea1", false, null, null, Tarea.Urgencia.MEDIO)
        val notificacion2 = tarea2.Notificacion(LocalDate.now(), true) // CREAR NOTIFICACION
        tarea1.notificacion = notificacion2 // ASIGNARLA A LA TAREA

        val tarea3 = Tarea("Tarea1", false, null, null, Tarea.Urgencia.ALTO)
        val notificacion3 = tarea3.Notificacion(LocalDate.now(), true) // CREAR NOTIFICACION
        tarea1.notificacion = notificacion3 // ASIGNARLA A LA TAREA

        val tarea4 = Tarea("Tarea1", false, null, null, Tarea.Urgencia.ALTO)
        val notificacion = tarea4.Notificacion(LocalDate.now(), true) // CREAR NOTIFICACION
        tarea1.notificacion = notificacion // ASIGNARLA A LA TAREA

        var listaTareasAlto = listaActividades.filtrarPor {
            if (it is Tarea) {
                it.urgencia == Tarea.Urgencia.ALTO
            } else {
                false
            }
        }


        var listaDefinitiva = listaActividades.filtrarPor {
            !it.completada
        }
        println(listaDefinitiva.joinToString())
    }
}