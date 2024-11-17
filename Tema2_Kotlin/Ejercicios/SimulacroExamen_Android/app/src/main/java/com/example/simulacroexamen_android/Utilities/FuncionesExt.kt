package com.example.simulacroexamen_android.Utilities

import Model.Actividad
import android.content.Context
import android.widget.Toast

fun Context.mensaje(mensaje:String, duracion:Int = Toast.LENGTH_LONG){ // POR DEFECTO ES LONG
    Toast.makeText(
        this,
        mensaje,
        duracion
    ).show()
}

// FUNCION DE EXTENSION Y DE ALTO NIVEL QUE PERMITA FILTRAR UN ARRAYLIST DE ACTIVIDADES
// EN FUNCION DE UNA LAMBDA COMO PARAMERTO.
// LA LAMBDA TIENE COMO PARAMETRO UNA ACTIVIDAD Y RETORNA UN BOOLEAN
// RETORNA UN ARRAYLIST DE ACTIVIDADES
fun ArrayList<Actividad>.filtrarPor(condicion: (Actividad) -> Boolean): ArrayList<Actividad> {
    return ArrayList(this.filter(condicion))
}