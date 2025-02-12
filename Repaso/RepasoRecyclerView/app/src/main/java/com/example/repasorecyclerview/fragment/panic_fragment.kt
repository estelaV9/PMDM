package com.example.repasorecyclerview.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.repasorecyclerview.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PanicFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // INFLAMOS LA VISTA DEL FRAGMENTO
        val rootView = inflater.inflate(R.layout.fragment_panic, container, false)

        // ACCEDEMOS AL ImageView DENTRO DE LA VISTA INFLADA
        val imageView: ImageView = rootView.findViewById(R.id.imgPanic)
        val buttonEnviar: Button = rootView.findViewById(R.id.enviarCorreoBtt)

        // CARGAMOS EL GIF
        Glide.with(requireContext())  // SE USA EL CONTEXTO DE LA ACTIVIDAD
            .asGif()  // ESPECIFICAMOS QUE ES UN GIF
            .load("https://i.pinimg.com/originals/17/62/0a/17620a76ae319084b457177d73dcc5ab.gif")  // URL DEL GIF
            .into(imageView)  // DONDE SE DEBE MOSTRAR EL GIF

        buttonEnviar.setOnClickListener {
            // ENVIAMOS LA URL
            enviarMensajeUrl("https://i.pinimg.com/originals/17/62/0a/17620a76ae319084b457177d73dcc5ab.gif")
        } // CUANDO SE PULSA EL BOTON DE ENVIAR, SE MANDA LA URL
        return rootView
    }

    fun enviarMensajeUrl(mensaje: String) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, mensaje)
        }
        // COMO ES UN FRAGMENT, EN VEZ DE packageManager SE PONE requireActivity().packageManager
        if (intent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(Intent.createChooser(intent, "Compartir mensaje con"))
        } else {
            // COMO ES UN FRAGMENT, EN VEZ DE this SE PONE requireContext()
            Toast.makeText(requireContext(), "No hay aplicaciones disponibles para enviar el mensaje.", Toast.LENGTH_SHORT).show()
        }
    } // METODO PARA ENVIAR LA URL

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment panic_fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PanicFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}