package com.example.simulacroexamen_android

import Model.Tarea
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDate

class TareaActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.tarea)
        var nombre = findViewById<EditText>(R.id.editTextText)
        var radio_group = findViewById<RadioGroup>(R.id.radioGroup)
        var boton = findViewById<Button>(R.id.button)
        lateinit var radioSeleccionado: RadioButton
        var calendario = findViewById<CalendarView>(R.id.calendarView)
        lateinit var fechaSeleccionada: LocalDate
        lateinit var urgencia: Tarea.Urgencia

        calendario.setOnDateChangeListener { view, year, month, dayOfMonth ->
            fechaSeleccionada = LocalDate.of(year, month + 1, dayOfMonth)
        }
        radio_group.setOnCheckedChangeListener { group, checkedId ->
            radioSeleccionado = findViewById(checkedId)
            when (checkedId) {
                R.id.bajoRD -> urgencia = Tarea.Urgencia.BAJO
                R.id.medioRD -> urgencia = Tarea.Urgencia.MEDIO
                R.id.altoRD -> urgencia = Tarea.Urgencia.ALTO
            }
        }

        boton.setOnClickListener {
            var tarea = Tarea(nombre.text.toString(), false, fechaSeleccionada, null, urgencia)
            tarea.mostrarDetalle()
        }
    }
}