package com.example.repasorecyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.repasorecyclerview.databinding.ActivityMainBinding
import com.example.repasorecyclerview.fragment.PanicFragment
import com.example.repasorecyclerview.fragment.RecyclerFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // EL RECYCLERVIEW FUNCIONA CON LISTAS Y CREARA UN ITEM/OBEJTO POR CADA VALOR EN LA LISTA
        //var myList = listOf("Example1", "Example2", "Example3") // CREARIA 3 CELDAS

        // CUANDO SE CREE, LLAMA AL METODO
        //initRecyclerView()
        initFragment()

    }

    private fun initFragment(){
        // SE CARGA EL FRAGMENTO POR DEFECTO
        loadFragment(RecyclerFragment())

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.recycler -> loadFragment(RecyclerFragment())
                R.id.panic -> loadFragment(PanicFragment())
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerBottomNav, fragment)
            .commit()
    }
}