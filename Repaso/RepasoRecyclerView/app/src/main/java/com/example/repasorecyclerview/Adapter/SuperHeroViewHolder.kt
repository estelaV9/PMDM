package com.example.repasorecyclerview.Adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.repasorecyclerview.R
import com.example.repasorecyclerview.SuperHero
import com.example.repasorecyclerview.databinding.ItemSuperheroBinding
import com.example.repasorecyclerview.dialog.DialogPersonalizado

// VA A SER EL ENCARGADO DE COGER LOS DATOS DE LA LSITA Y TINTARLOS
// le pasamos la vista (el item_superhero)

class SuperHeroViewHolder(view: View, private val fragmentManager: FragmentManager) : RecyclerView.ViewHolder(view) { // LE PASAMOS LA VISTA

    val binding = ItemSuperheroBinding.bind(view)

    /*val realName = view.findViewById<TextView>(R.id.realNameSHtv)
    val publisher = view.findViewById<TextView>(R.id.publisherSHtv)
    val superHero = view.findViewById<TextView>(R.id.nameSHtv)
    val photo = view.findViewById<ImageView>(R.id.imgSuperHero)*/

    // FUNCION RENDER QUE RECIVE UN OBJETO Y SE VA A LLAMAR POR CADA ITEM DE LA LISTA
    fun render(superHeroModel: SuperHero) {
        binding.nameSHtv.text = superHeroModel.superHero
        binding.realNameSHtv.text = superHeroModel.realName
        binding.publisherSHtv.text = superHeroModel.publisher
        // ESTABLEECR LA IMAGEN --> NECESITA PERMISO (declaralo)
        Glide.with(binding.imgSuperHero.context).load(superHeroModel.photo)
            .into(binding.imgSuperHero)

        // FORMA UNO PARA CLICKAR LOS ELEMENTOS
        // EN ESTE EJEMPLO SE HACE CLICK EN LA IMAGEN
        binding.imgSuperHero.setOnClickListener {
            Toast.makeText(
                binding.imgSuperHero.context,
                superHeroModel.realName,
                Toast.LENGTH_SHORT
            ).show()
        }

        // AQUI SE HACE CLICK EN LA CELDA
        // LLAMAMOS A ITEMVIEW QUE ES TODA LA CELDA
        itemView.setOnClickListener {
            Toast.makeText(
                binding.imgSuperHero.context,
                superHeroModel.superHero,
                Toast.LENGTH_SHORT
            ).show()
        }

        itemView.setOnClickListener {
            DialogPersonalizado.newInstance(superHeroModel)
                .show(fragmentManager, "DialogoPersonalizado")
        }
    }
}