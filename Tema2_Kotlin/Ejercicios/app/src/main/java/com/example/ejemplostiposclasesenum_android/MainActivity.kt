package com.example.ejemplostiposclasesenum_android

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
/** Ejercicio: Defina una aplicación android que permita cambiar el color de fondo de la app,
 * en función del radioButton seleccionado, se mostrará el color seleccionadoen un TextView. **/
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}