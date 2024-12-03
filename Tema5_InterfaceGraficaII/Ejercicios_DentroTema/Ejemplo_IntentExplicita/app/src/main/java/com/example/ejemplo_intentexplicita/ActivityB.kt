package com.example.ejemplo_intentexplicita

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.ejemplo_intentexplicita.databinding.ActivityBBinding

class ActivityB : AppCompatActivity() {
    private lateinit var mibinding: ActivityBBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        inicializarComponentes() // LLAMAR AL METODO PARA INICIALIZAR COMPONENTES
    }

    @SuppressLint("SetTextI18n")
    private fun inicializarComponentes() {
        // SE INSTANCIA EL OBJETO binding
        mibinding = ActivityBBinding.inflate(layoutInflater)

        // ESTABLECE EL LAYOUT A MI ACTIVIDAD
        setContentView(mibinding.root) // EL ROOT ES LA PROPIEDAD QUE ME PERMITE ACCEDER A LA RAIZ DEL LAYOUT

        // OBTENEMOS LOS DATOS DEL INTENT QUE SIRVIO PARA ABRIR ESTA ACTIVIDAD
        val miIntent = intent
        val miBundle = miIntent.extras // OBTENER EL BUNDLE VINCULADO AL INTENT

        // ACCEDEMOS A LOS DATOS DEL BUNDLE
        if (miBundle != null) {
            // SETTEAR EL DATO DEL EDIT TEXT Y EL DATO ENTERO
            mibinding.mostrarBundleTV.text = miBundle.getString("datos1") + " - " +
                    miBundle.getInt("datos2")
        } // SI LOS DATOS DEL BUNDLE NO ES NULO, MOSTRAR EL CONTENIDO DEL BUNDLE

        // LISTENER AL BOTON
        mibinding.finalizarActBBtt.setOnClickListener {
            // CREAMOS UN INTENT QUE ESTA VINCULADO CON LA MAINACTIVITY QUE ME SIRVE PARA DEDOLVER DATOSS
            val miIntent = Intent()
            // CREO UN BUNDLE PARA METER LOS DATOS
            val miBundle = Bundle()

            // RELLENO EL BUNDLE
            miBundle.putString("datoActividadB", mibinding.mostrarBundleTV.text.toString())
            // VINCULAR EL BUNDLE AL INTENT
            miIntent.putExtras(miBundle)

            setResult(Activity.RESULT_OK, miIntent) // ESTABLECER E RESULTADO

            finish() // FINALIZAR ACTIVIDAD
        }
    } // METODO PARA INICIALIZAR
}