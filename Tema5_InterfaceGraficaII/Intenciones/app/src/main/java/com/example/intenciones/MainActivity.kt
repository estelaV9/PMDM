package com.example.intenciones

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.intenciones.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mibinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mibinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mibinding.root)

        mibinding.githubBtt.setOnClickListener {
            // CREAR UN INTENT PARA ABRIR LA URL
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/estelaV9"))

            // INICIAR LA ACTIVIDAD CON EL INTENT
            startActivity(intent)
        }
    }
}