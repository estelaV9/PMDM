package com.example.repasorecyclerview.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.repasorecyclerview.Adapter.SuperHeroAdapter
import com.example.repasorecyclerview.R
import com.example.repasorecyclerview.SuperHeroProvider

class RecyclerFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SuperHeroAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // INFLAMOS EL LAYOUT DEL FRAMENTO
        return inflater.inflate(R.layout.activity_recycler_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerSuperHero)
        adapter = SuperHeroAdapter(SuperHeroProvider.superHeroList, parentFragmentManager)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        /*private fun initRecyclerView(){
            val recyclerView = findViewById<RecyclerView>(R.id.recyclerSuperHero)
            // ESTE LINEARLAYOUT CONTROLA COMO SE VAN A VER LOS ELEMENTOS (se puede poner gridlayout...)
            binding.fragmentContainerBottomNav .layoutManager = LinearLayoutManager(this)
            // SE LE PASA EL SUPPORTMANAGER DESDE LA ACTIVIDAD
            recyclerView.adapter = SuperHeroAdapter(SuperHeroProvider.superHeroList, supportFragmentManager)
        }*/
    }
}