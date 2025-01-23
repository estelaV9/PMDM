package com.example.ejemplorecycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ejemplorecycleview.databinding.ElementoRecyclerBinding
import com.example.ejemplorecycleview.model.Coche

class AdaptadorRecycler(private val datos: List<Coche>, var onClickItem:(Int)->Unit) :
    RecyclerView.Adapter<AdaptadorRecycler.MiViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiViewHolder {
        // INFLAR LA VISTA DE UN ELEMENTO
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.elemento_recycler, parent, false)

        // CONSTRUYO UN OBJETO ViewHolder, DE MI PROPIA CLASE
        val objeto_viewholder = MiViewHolder(vista)

        // RETORNO EL OBJETO CREADO
        return objeto_viewholder
    }

    override fun getItemCount(): Int {
        return datos.size
    }

    override fun onBindViewHolder(holder: MiViewHolder, position: Int) {
        // VINCULO CADA UNO DE LOS ELEMENTOS VISUALES (vistas) DEL HOLDER CON DATOS
        //holder.itemView.findViewById<TextView>(R.id.texto1).text = datos.get(position)
        holder.render(datos.get(position), position)
        holder.itemView.setOnClickListener{
            // SE INVOCA ALGO QUE VIENE DE FUERA (main)
            onClickItem(position)
        }
    }

    // CLASE QUE REPRESENTA UN ViewHolder
    class MiViewHolder(val vista: View) : RecyclerView.ViewHolder(vista) {
        // HACEMOS EL BINGIN DENTRO DEL HOLDER
        private var bindingHolder = ElementoRecyclerBinding.bind(vista)

        // LA PROPIEDAD itemView REPRESENTA LA VISTA INDIVIDUAL Y TIENE LA MISMA REFERENCIA QUE VISTA
        fun render(dato: Coche, pos: Int) {
            bindingHolder.texto1.text = dato.marca
            if(dato.isSeleccionado){
                vista.setBackgroundColor(vista.context.getColor(R.color.blue))
            } else {
                vista.setBackgroundColor(vista.context.getColor(R.color.white))
            }
            vista.setOnClickListener{
                // TODOESTO SE DEBERIA EJECUTAR EN LA CLAS EQUE DEFINA EL RECYCLERVIEW


                // CAMBIO EL VALOR DE SELECCIONADO
                dato.isSeleccionado = !dato.isSeleccionado

                // REPINTAR TODA LA LISTA VISIBLE
                this.bindingAdapter?.notifyItemChanged(pos)

            }
        }
    }
}