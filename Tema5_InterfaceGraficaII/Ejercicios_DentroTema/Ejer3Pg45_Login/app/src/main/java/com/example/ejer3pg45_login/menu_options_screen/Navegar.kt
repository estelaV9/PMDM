package com.example.ejer3pg45_login.menu_options_screen

import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ejer3pg45_login.MenuOpciones
import com.example.ejer3pg45_login.databinding.ActivityNavegarBinding

class Navegar : AppCompatActivity() {
    private lateinit var mibinding: ActivityNavegarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // INICIALIZAMOS ViewBinding
        mibinding = ActivityNavegarBinding.inflate(layoutInflater)
        setContentView(mibinding.root)

        // CONFIGURAMOS EL WebView
        // INICIALIZO EL VISOR WEB (WEBVIEW) PARA MOSTRAR UNA PAGINA
        val webView: WebView = mibinding.mivisorWeb
        webView.webViewClient = WebViewClient() // ASEGURA QUE SE MANTENGA EN LA APLICACION
        webView.settings.javaScriptEnabled = true // SI NECESITAMOS SOPORTE PARA JS

        mibinding.navegarBtt.setOnClickListener {
            var url = mibinding.urlET.text.toString() // URL INTRODUCIDA

            if (url.isNotEmpty()) {
                if (url.startsWith("http://") || url.startsWith("https://")) {
                    webView.loadUrl(url) // CARGAMOS LA PAGINA EN EL WEBVIEW
                } else {
                    // SI LA URL NO TIENE UN FORMATO CORRECTO, SE AGREGA  "https://" POR DEFECTO
                    webView.loadUrl("https://$url")
                } // CARGAR LA PAGINA O UNA CON FORMATO POR DEFECTO
            } else {
                // SI LA URL ESTA VACIA, MOSTRAR UN MENSAJE DE ERROR
                Toast.makeText(this, "Por favor ingresa una URL valida", Toast.LENGTH_SHORT).show()
            } // VALIDAR SI LA URL INTRODUCIDA NO ESTA VACIA
        } // CUANDO PULSE EL BOTON NAVEGAR, SE ABRIRA EL EXPLORADOR

        mibinding.backBtt.setOnClickListener {
            finish()
        } // BOTON PARA VOLVER AL MENU DE OPCIONES
    }
}