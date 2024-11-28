package com.example.ejemplo_ciclovida

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.example.ejemplociclovida.R

class SegundaActividad : AppCompatActivity() {
    var botonpulsado = true
    var valor = 0
    lateinit var micheck: CheckBox
    lateinit var boton: Button
    lateinit var imagen: ImageView
    lateinit var texto: TextView
    lateinit var edittext: TextView
    lateinit var mitoolBar: Toolbar

    // SE EJECUTA CUANDO SE CREA LA ACTIVIDAD
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.segunda_activity)

        // INICIALIZA LOS COMPONENTES DE LA ACTIVIDAD
        initComponents(savedInstanceState)
        Log.i("CicloVida", "Se ejecuta OnCreate, se crea la actividad")
    }

    // SE EJECUTA CUANDO LA ACTIVIDAD SE HACE VISIBLE AL USUARIO
    override fun onStart() {
        super.onStart()
        Log.i("CicloVida", "Se ejecuta OnStart, la actividad se hace visible")
    }

    // SE EJECUTA CUANDO LA ACTIVIDAD TIENE EL FOCO Y ES INTERACTIVA
    override fun onResume() {
        super.onResume()
        Log.i("CicloVida", "Se ejecuta onResume, la actividad tiene el foco")
    }

    // SE EJECUTA CUANDO LA ACTIVIDAD PIERDE EL FOCO, PERO SIGUE SIENDO VISIBLE
    override fun onPause() {
        super.onPause()
        Log.i("CicloVida", "Se ejecuta OnPause, la actividad pierde el foco principal, pero es visible")
    }

    // SE EJECUTA CUANDO LA ACTIVIDAD DEJA DE SER VISIBLE Y PASA A SEGUNDO PLANO
    override fun onStop() {
        super.onStop()
        Log.i("CicloVida", "Se ejecuta onStop, la actividad ya no es visible")
    }

    // SE EJECUTA CUANDO LA ACTIVIDAD SE DESTRUYE O ES FINALIZADA
    override fun onDestroy() {
        super.onDestroy()
        Log.i("CicloVida", "Se ejecuta onDestroy, la actividad se destruye de memoria")
    }

    // SE EJECUTA CUANDO LA ACTIVIDAD SE DESTRUYE Y NECESITAMOS GUARDAR SU ESTADO
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("estado", botonpulsado)
        outState.putInt("contador", this.valor)
    }

    fun initComponents(estado: Bundle?) {
        mitoolBar = findViewById(R.id.mitoolbar)
        setSupportActionBar(mitoolBar)
        micheck = findViewById(R.id.checkBox)
        micheck.isSaveEnabled = false
        boton = findViewById(R.id.button)
        imagen = findViewById(R.id.compartir)
        texto = findViewById(R.id.textView)
        edittext = findViewById(R.id.editText)
        texto.text = valor.toString()

        // ESCUCHADOR PARA EL BOTÓN DE COMPARTIR
        imagen.setOnClickListener {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Comparto el valor del textfield: ${texto.text}")
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)

            try {
                ContextCompat.startActivity(this, shareIntent, null)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "Compartir no disponible", Toast.LENGTH_LONG).show()
            }
        }

        // ESCUCHADOR PARA EL BOTÓN QUE INCREMENTA UN VALOR
        boton.setOnClickListener {
            valor++
            texto.text = valor.toString()
        }

        if (estado != null) {
            botonpulsado = estado.getBoolean("estado")
            micheck.isChecked = botonpulsado
            valor = estado.getInt("contador")
            texto.text = valor.toString()
        }
    }
}