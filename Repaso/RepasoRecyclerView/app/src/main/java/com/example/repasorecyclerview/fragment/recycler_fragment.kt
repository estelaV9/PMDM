package com.example.repasorecyclerview.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.repasorecyclerview.Adapter.SuperHeroAdapter
import com.example.repasorecyclerview.FormularioCharacter
import com.example.repasorecyclerview.R
import com.example.repasorecyclerview.SuperHeroProvider
import com.example.repasorecyclerview.databinding.ActivityRecyclerFragmentBinding

class RecyclerFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SuperHeroAdapter
    private lateinit var binding: ActivityRecyclerFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityRecyclerFragmentBinding.inflate(layoutInflater)
        // INFLAMOS EL LAYOUT DEL FRAMENTO
        // si no tenemos el binding:
        // return inflater.inflate(R.layout.activity_recycler_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerSuperHero)
        adapter = SuperHeroAdapter(SuperHeroProvider.superHeroList, parentFragmentManager)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        binding.addCharacter.setOnClickListener {
            var intent = Intent(requireContext(), FormularioCharacter::class.java)
            //intent.putExtra("heroe",SuperHeroProvider.superHeroList.get(pos)) pos si se necesita pasar algo al intent.
            startActivity(intent)
        } // CUANDO PULSES EL BOTON DE AÑADIR TE LLEVAA A UNA NUEVA ACTIVITY CON LOS DATOS A RELLENAR


        /*private fun initRecyclerView(){
            val recyclerView = findViewById<RecyclerView>(R.id.recyclerSuperHero)
            // ESTE LINEARLAYOUT CONTROLA COMO SE VAN A VER LOS ELEMENTOS (se puede poner gridlayout...)
            binding.fragmentContainerBottomNav .layoutManager = LinearLayoutManager(this)
            // SE LE PASA EL SUPPORTMANAGER DESDE LA ACTIVIDAD
            recyclerView.adapter = SuperHeroAdapter(SuperHeroProvider.superHeroList, supportFragmentManager)
        }*/
    }
}