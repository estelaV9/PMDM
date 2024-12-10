package com.example.ejemploreceptorintents

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejemplo_receptorintents.R

class AbrirNavegador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_abrir_navegador)

        // ESTABLEZCO UNA ESCUCHA PARA LOS MÁRGENES DEL SISTEMA (BARRAS DE ESTADO Y NAVEGACIÓN)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // OBTENGO LA INTENT QUE PERMITIÓ ABRIR ESTA ACTIVIDAD
        var miIntent = intent
        // OBTENGO LOS DATOS DE LA URI DE LA INTENT
        var datos = miIntent.data?.schemeSpecificPart ?: "VACIO"
        var mitexto = findViewById<TextView>(R.id.textNavegador)
        mitexto.text = datos

        // INICIALIZO EL VISOR WEB (WEBVIEW) PARA MOSTRAR UNA PÁGINA
        val webView: WebView = findViewById(R.id.mivisorWeb)
        webView.webViewClient = WebViewClient() // ASEGURA QUE SE MANTENGA EN LA APLICACIÓN
        webView.settings.javaScriptEnabled = true // SI NECESITAMOS SOPORTE PARA JS

        // CARGO LA PÁGINA DE GOOGLE SI LA URI COINCIDE
        if (miIntent.data != null && miIntent.data.toString().equals("https://www.google.com")) {
            webView.loadUrl(miIntent.data.toString())
        } else {
            webView.loadUrl("https://www.android.com/") // POR DEFECTO, CARGO ANDROID
        }
    }
}