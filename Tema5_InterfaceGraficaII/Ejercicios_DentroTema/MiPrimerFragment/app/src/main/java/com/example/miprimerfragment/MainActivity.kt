package com.example.miprimerfragment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.miprimerfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var miBinding: ActivityMainBinding
    var cargaFragmento_A = true // EL FRAGMENTO A ESTA CARGADO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // ESTABLEZCO MI LAYOUT A LA ACTIVIDAD
        miBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(miBinding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /** AÑADIR EL FRAGMENTO DESDE CODIGO -> FORMA 1 (no se hace)
        // CARGAR EL FRAGMENTO A:
        // OBTENGO UNA REFERENCIA DE UN FragmentTransaction
        val miFragmentoTransaction = supportFragmentManager.beginTransaction()

        // AÑADIR EL ACTIVITY UNA INSTANCIA DEL Fragmento_A
        // SE INVOCA AL METODO onCreateView DEL FRAGMENT Y SE LE PASA EL CONTENEDOR COMO PARAMETRO
        // Y UNA INSTANCIA DEL FRAGMENTO Y PODEMOS AÑADIRLE UNA ETIQUETA PARA LOCALIZAR FRAGMENTOS
        miFragmentoTransaction.add(R.id.fragmentContainerView, Fragmento_A(), "fragmentoA")

        // HACER COMMIT PORQUE SI NO LA ACCION NO SE REALIZA
        miFragmentoTransaction.commit()
        // CON ESTOS TRES PASOS YA HEMOS AÑADIDO EL FRAGMENTO A LA ACTIVIDAD **/


        // CREANDO UN BUNDLE Y RELLENANDOLE DE INFORMACION
        val miBundle = bundleOf(Fragmento_A.LOGIN to "Pepito", Fragmento_A.PASSWORD to "pepitopass")

        /** FORMA 2 MAS OPTIMA **/
        // CARGAR EL Fragmento_A CON LA FORMA MAS OPTIMIZADA
        supportFragmentManager.commit {
            // INVOCAR EL METODO -> REORDENA LA PILA DE FRAGMENTOS PARA OPTIMIZAR LA CARGA DE
            // FRAGMENTOS DENTRO DE MI ACTIVIDAD
            setReorderingAllowed(true)
            add<Fragmento_A>(R.id.fragmentContainerView, args = miBundle) // PASAMOS EL BUNDLE
        }

        // OBTENER UNA REFERENCIA DEL FragmentContainerView PARA AÑADIRLE LA ACCCION onClickListener
        miBinding.fragmentContainerView.setOnClickListener{
            // REEMPLAZAR EL FRAGMENTO DEL fragmentContainerView
            if (this.cargaFragmento_A) {
                // SIGNIFICA QUE ESTA CARGADO EL FRAGMENTO A Y POOR LO TANTO LO REMPLAZO POR EL FRAGMENTO B
                supportFragmentManager.commit {
                    replace<Fragmento_B>(R.id.fragmentContainerView)
                    addToBackStack("fragmento_b") // VA AÑADIR EN LA FILA EL FRAGMENTO QUE HAYA ACUTALMENTE EN EL CONTENEDOR
                    setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                }
            } else {
                // SI ESTA CARGADO EL FRAGMENTO B LO REMPLAZO POR EL FRAGMENTO A
                supportFragmentManager.commit {
                    replace<Fragmento_A>(R.id.fragmentContainerView)
                    addToBackStack("fragmento_a")
                    setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                }
            }
            // CAMBIAMOS EL VALOR
            this.cargaFragmento_A = !cargaFragmento_A
        }
    }
}