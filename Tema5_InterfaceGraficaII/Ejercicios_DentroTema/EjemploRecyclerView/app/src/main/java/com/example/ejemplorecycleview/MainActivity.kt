package com.example.ejemplorecycleview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.ejemplorecycleview.databinding.ActivityMainBinding
import com.example.ejemplorecycleview.model.Coche

class MainActivity : AppCompatActivity() {
    lateinit var mibinding: ActivityMainBinding

    // DEFINIMOS OBJETO DEL RecyclerView
    lateinit var recycler: RecyclerView

    // DEFINO UN OBJETO DEL ADAPTER
    lateinit var miAdapter: AdaptadorRecycler

    // CREO LA LISTA DE DATOS
    var listaDatos = mutableListOf(
        Coche("Mercedes"),
        Coche("BMW"),
        Coche("Opel"),
        Coche("Porsche"),
        Coche("Ford"),
        Coche("Audi"),
        Coche("Mustang"),
        Coche("Citroen"),
        Coche("Volkswagen"),
        Coche("Skoda"),
        Coche("Maserati"),
        Coche("Subaru", true),
        Coche("Mazda"),
        Coche("Ferrari"),
        Coche("Lambo"),
        Coche("KIA"),
        Coche("Toyota"),
        Coche("Hyundai"),
        Coche("Renault"),
        Coche("Peugeot"),
        Coche("Maserati"),
        Coche("Subaru"),
        Coche("Maserati"),
        Coche("Subaru")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        iniciarComponentes()
    }

    fun iniciarComponentes() {
        mibinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mibinding.root)

        iniciarRecycler()
    }

    fun iniciarRecycler() {
        recycler = mibinding.recycler
        // DEFINIR MANEJADOR DEL Layout DEL Recycler
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // AÑADIRMOS UN SEPARADOR A LOS ELEMENTOS DEL RECYCLERVIWE
        val divisor = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        // LE ASIGNAMOS AL RECYCLEVIEW EL ITEMDECORATION
        this.recycler.addItemDecoration(divisor)

        // ASIGNAR UNA REFERENCIA DEL ADAPTADOR
        this.miAdapter = AdaptadorRecycler(this.listaDatos){
            posicion ->
            listaDatos.get(posicion).isSeleccionado = !listaDatos.get(posicion).isSeleccionado
            // REPINTO LOS ELEMENTOS
            miAdapter.notifyItemChanged(posicion)
        }

        // VINCULO AL Recycler viwe EL ADAPTADOR
        this.recycler.adapter = this.miAdapter

    }
}