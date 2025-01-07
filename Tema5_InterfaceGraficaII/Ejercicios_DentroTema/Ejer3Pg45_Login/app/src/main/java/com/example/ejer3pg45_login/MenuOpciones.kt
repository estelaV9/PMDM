package com.example.ejer3pg45_login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejer3pg45_login.databinding.ActivityMenuOpcionesBinding

class MenuOpciones : AppCompatActivity() {
    private lateinit var mibinding: ActivityMenuOpcionesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // INICIALIZAMOS ViewBinding
        mibinding = ActivityMenuOpcionesBinding.inflate(layoutInflater)
        setContentView(mibinding.root)
    }
}