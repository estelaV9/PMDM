package com.example.ejer2_textfieldporcaracter

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.caracteresEdit)
        val textField = findViewById<TextView>(R.id.textField)

        // Agrega un TextWatcher para detectar cambios en el texto del EditText
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // No se necesita implementación en este caso
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // No se necesita implementación en este caso
            }

            override fun afterTextChanged(s: Editable?) {
                // Llama a la función caracteresIntroducidos para obtener la cadena de guiones y la muestra en el TextView
                val guiones = caracteresIntroducidos(s.toString())
                textField.text = guiones
            }
        })
    }

    fun <T> caracteresIntroducidos(caracteres: T): String {
        val numCaracteres = caracteres.toString()
        var numGuiones = "";
        // SE USA UNTIL PARA EVITAR EL INDICE FUERA DEL RANGO
        for (i: Int in 0 until numCaracteres.length) {
            numGuiones += "_"
        }
        return numGuiones;
    }
}