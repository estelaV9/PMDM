package com.example.ejemplospoo

import android.app.Activity
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

// Función para comprobar si un objeto es null
/*fun Any?.esnulo(): Boolean {
    return this == null
}
// Ejercicio1.- Es posible definir esta función con menos código?

// Funcion para simplificar un Toast, podrá ser invocada desde cualquier Activity
fun Activity.mostrar_mensaje(mensaje: String, duracion: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, mensaje, duracion).show()
}

/**
 * Funcion para obtener un color a partir de un valor de recurso, podrá ser invocada desde
 * cualquier activity. Se etiqueta con la anotación @ColorRes (ver anotaciones de recursos en
 * https://developer.android.com/studio/write/annotations?hl=es-419) para impedir en tiempo de
 * compilación que se introduzca un valor que no corresponde con un valor de recurso de color
 * @param color_res Parametro que representa un recurso de color
 * @return Un entero que representa el color en formato AARRGGBB
 *
 */

// desde cualquier activity
fun Activity.get_color(@ColorRes color_res: Int): Int {
    return ContextCompat.getColor(this, color_res)
}

// Ejercicio 2.- Podemos definir la función de otra forma más sencilla?
/**
 * En este caso una función que permite cargar imagenes a partir de una
 * url haciendo uso de la libreria Glide,sera necesario importarla en gradle
 * Glide es una libreria muy potente para cargar recursos desde URL's
 * (https://bumptech.github.io/glide/doc/download-setup.html)
 * Configuración e instalacion de libreria y en los ficheros gradle:
 * https://bumptech.github.io/glide/doc/download-setup.html
 */
fun ImageView.cargarImagen(url: String) {
    if (url.isNotEmpty()) {
        // Cargamos la imagen, this.context representa el contexto de
        // la imagen, es decir, de que Activity depende la vista
        // ImageView es un contenedor de imagenes, into dice que se cargue
        // la imagen de la URL en este contenedor.
        Glide.with(this.context).load(url).into(this)
    }
}*/

fun EditText.despues_cambio_texto(listener: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            //En este caso no se hace nada
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            //En este caso no se hace nada
        }

        override fun afterTextChanged(s: Editable?) {
            listener(s.toString())
        }
    })
}