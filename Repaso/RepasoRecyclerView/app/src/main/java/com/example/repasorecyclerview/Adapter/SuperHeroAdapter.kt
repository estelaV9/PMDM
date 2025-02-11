package com.example.repasorecyclerview.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.repasorecyclerview.R
import com.example.repasorecyclerview.SuperHero

// EXTIENDE DEL ADAPTER DE LA CLASE DE VIEW HODLER
// Y SE IMPLEMENTAN LOS METODOS DE LA CLASE

// EL ADAPTADOR RECIBIRA EL LISTADO DE SUPERHERO SIN LA LISTA NO VA A PODER HACER SU FUNCION
class SuperHeroAdapter(
    private val superheroList: List<SuperHero>,
    // SE LE PASA EL FRAGMENTO MANAGER PARA CONTROLAR EL DIALOG
    private val fragmentManager: FragmentManager
) :
    RecyclerView.Adapter<SuperHeroViewHolder>() {

    // DEVUELVE AL VIEW HOLDER EL ITEM/LAYOUT (item_superhero) QUE VA A PODER MODIFICAR
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        // SACAMOS EL CONTEXTO A TRAVES DE LAS VISTAS (viewGroup) POR ESO A LOS RECYCLER VIEW
        // NO HAY QUE PASARLES EL CONTEXTO
        val layoutInflater = LayoutInflater.from(parent.context)
        // LE PASAMOS EL INFLATER CON EL LAYOUT QUE HEMOS CREADO, EL PARENT Y EL FALSE
        return SuperHeroViewHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false), fragmentManager)
    }

    // ESTE METODO DEVUELVE EL TAMAÑO DEL LISTADO
    // SON EL NUMERO DE ITEM QUE SE VA A VER EN EL RECYCLERVIEW
    override fun getItemCount(): Int {
        return superheroList.size
    }

    // VA A PASAR POR CADA UNO DE LOS ITEMS Y VA A LLAMAR AL METODO SUPERHERO RENDER
    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        // LE PASAMOS LA POSICION A LA QUE DEBE ACCEDER
        val item = superheroList[position]
        holder.render(item)
    }
}