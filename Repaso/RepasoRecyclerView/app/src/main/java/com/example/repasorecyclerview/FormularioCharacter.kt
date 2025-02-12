package com.example.repasorecyclerview

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.repasorecyclerview.databinding.ActivityFormularioCharacterBinding

class FormularioCharacter : AppCompatActivity() {
    private lateinit var binding: ActivityFormularioCharacterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFormularioCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // UBICAR EN LA PARTE SUPERIOR
        setSupportActionBar(binding.myToolbar)

        // AÑADIR UN ITTULO
        binding.myToolbar.title = "Rellenar formulario"

        // AÑADIR LA OPCION DE IR PARA ATRAS
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        var saveBtt = binding.saveBtt

        // CREAR OBJETO POR DEFECTO
        var superHero:SuperHero? = null

        saveBtt.setOnClickListener {
            // OBTENEMOS LOS DATOS ENVIADOS
            var nameET = binding.nombreETa.text.toString()
            var realNameET = binding.nombreRealETa.text.toString()
            var publisherET = binding.publisherETa.text.toString()

            if(nameET == null || realNameET == null || publisherET == null){

            } else{
                // SI NO SON NULOS SE GUARDA EL OBJETO
                superHero = SuperHero(nameET, publisherET, realNameET, "fds")
                // SE AÑADE A LA LISTA
                SuperHeroProvider.superHeroList.add(superHero!!)

                // DEVUELVE EL OBJETO
                var intent = Intent(this,MainActivity::class.java)
                var bundle= Bundle()
                bundle.putString("superhero",superHero.toString())
                intent.putExtras(bundle)
                //bundle.getString("texto") asi para obtenerlo
                startActivity(intent)
                Toast.makeText(this, "Se creo con exito", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when (item.itemId) {
            android.R.id.home -> {
                intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                //finish()
            }
        }
        return true
    } // FUNCION PARA IR PARA ATRAS
}