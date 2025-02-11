package com.example.repasorecyclerview.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.example.repasorecyclerview.R
import com.example.repasorecyclerview.SuperHero

class DialogPersonalizado : DialogFragment() {
    // DECLARAMOS LA VARIABLE DEL OBJETO
    private var superHero: SuperHero? = null
    companion object {
        private const val ARG_SUPERHERO = "superHero"

        //  CREARR UNA NUEVA INSTANCIA DEL DIALOG CON UNN SuperHero
        fun newInstance(superHero: SuperHero): DialogPersonalizado {
            val fragment = DialogPersonalizado()
            val args = Bundle()
            args.putSerializable(ARG_SUPERHERO, superHero)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // RECUPERAR EL OBJETO DEL BUNDLE
        superHero = arguments?.getSerializable(ARG_SUPERHERO) as? SuperHero
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        val view = requireActivity().layoutInflater.inflate(R.layout.dialog_personalizado, null)

        // SE ASIGNAN LOS DATOS A LOS ELEMENTOS DEL LAYOUT
        val nameTextView = view.findViewById<TextView>(R.id.nameSHtv)
        val realNameTextView = view.findViewById<TextView>(R.id.realNameSHtv)
        val heroImageView = view.findViewById<ImageView>(R.id.imgSuperHero)
        val closeButton = view.findViewById<Button>(R.id.backDialog)

        superHero?.let { hero ->
            nameTextView.text = hero.superHero
            realNameTextView.text = hero.realName
            Glide.with(this).load(hero.photo).into(heroImageView)
        }

        closeButton.setOnClickListener { dismiss() }

        builder.setView(view)
        return builder.create()
    }


    /*override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //C REAR DIALOG PERSONALIZADO
        return activity.let { //Activity.let dicho de forma rápida "crea" los
            // SE CREA UN BUILDER
            var builder = AlertDialog.Builder(context)
            // SE INFLA LA VISTA
            var view = requireActivity().layoutInflater.inflate(R.layout.dialog_personalizado, null)
            // SE LLENAN LOS DATO
            view.findViewById<Button>(R.id.backDialog).setOnClickListener {
                dismiss()
            }
            // SE METE EN LA VISTA EL BUILDER
            builder.setView(view)

            // SE DEVUELVE LA CREACION DEL DIALOG
            builder.create()
        }
    }*/
}