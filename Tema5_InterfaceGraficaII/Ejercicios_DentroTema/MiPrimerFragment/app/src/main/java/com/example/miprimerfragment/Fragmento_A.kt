package com.example.miprimerfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


// CREAR UN FRAGMENTO: com.exmaple.miprimerfragmet -> new -> fragment -> Fragemnt (blank)

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [Fragmento_A.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragmento_A : Fragment() {
    // TODO: Rename and change types of parameters
    private var login: String? = null
    private var password: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ARGUMENTS ES UNA PROPIEDAD DE FRAGMENT QUE PUEDE TENER INFORMACION QUE SE LE PASE
        // COMO ES UN BUNDLE
        arguments?.let {
            login = it.getString(LOGIN)
            password = it.getString(PASSWORD)
        }
        /*if(arguments != null){
            login = arguments.getString(ARG_login)
            password = arguments.getString(ARG_password)
        }*/
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { // DEVUELVE UNA VISTA
        // Inflate the layout for this fragment
        // NOS PERMITE OBTENER LA REFERENCIA PARA CARGAR O INSTANCIAR EL LAYOUT DEL FRAGMENTO

        val v = inflater.inflate(R.layout.fragment_fragmento__a, container, false) // TIENE QUE SER FALSE
        // VINCULAMOS LOS DATOS
        v.findViewById<TextView>(R.id.loginTV).text = this.login
        v.findViewById<TextView>(R.id.passwordTV).text = this.password
        return v
    }

    // BLOQUE ESTATICO
    companion object {
        // ESTABLECEMOS LAS VARIABLES EN EL BLOQUE ESTATICO
        // SON LAS CLAVES, NO LOS VALORES -> SE LE PASARA EL VALOR DESDE OTRO LADO
        const val LOGIN = "login"
        const val PASSWORD = "password"
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(login: String, password: String) =
            Fragmento_A().apply {
                /*arguments = Bundle().apply {
                    putString(ARG_login, login)
                    putString(ARG_password, password)
                }*/
            }
    }
}