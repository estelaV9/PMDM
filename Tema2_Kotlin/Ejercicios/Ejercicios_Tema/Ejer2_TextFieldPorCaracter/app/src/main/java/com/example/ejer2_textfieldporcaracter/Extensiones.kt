package com.example.ejemplospoo

import android.app.Activity
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat


/*funcion de extension = crear una clase que herede de otra clase y definir dentro otra funcion

Se crea dentro de la clase EditText una funcion despues_cambio_texto
se le pasa una funcion le paso como parametro otra funcion le tengo que decir como es esa funcion : esa funcion tiene x parametros y va a devolver algo

(String, Int..) -> param
Util -> lo que devuelve / retorna

En este caso, no devuelve nada, le paso una cadena como parametro
La cadena que le pase es la descri`cion de lo que esta escribiendo en el editText
*/
fun EditText.despues_cambio_texto(listener: (String) -> Unit) {
    //  Dentro de la funicon de extencion se implementa un escuchador al editText el this se referencia al objeto que invoque esa funcion
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            //En este caso no se hace nada
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            //En este caso no se hace nada
        }

        override fun afterTextChanged(s: Editable?) {
            //Invoca a la funcion pasada como parametro.
            listener(s.toString())
        }
    })
}
