package com.example.simulacroexamen_android.Utilities

import android.content.Context
import android.widget.Toast

fun Context.mensaje(mensaje:String, duracion:Int = Toast.LENGTH_LONG){ // POR DEFECTO ES LONG
    Toast.makeText(
        this,
        mensaje,
        duracion
    ).show()
}