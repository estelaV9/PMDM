package com.example.intenciones

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import java.io.File
import java.io.IOException

class VistaLugarActivity : AppCompatActivity() {

    private lateinit var foto: ImageView
    private lateinit var lugar: Lugar
    private var uriUltimaFoto: Uri? = null


    /* Crea una intención implícita con acción ACTION_SEND. Mandaremos
    un texto plano formado por el nombre del lugar y su URL. Esta información podrá
    ser recogida por cualquier aplicación que se haya registrado como enviadora de
    mensajes (WhatsApp, Gmail, SMS, etc.).  */
    fun compartir(lugar: Lugar) {
        val i = Intent(Intent.ACTION_SEND)
        i.type = "text/plain"
        i.putExtra(
            Intent.EXTRA_TEXT,
            "${lugar.nombre} - ${lugar.url}"
        ) // COMPARTIMOS EL NOMBRE Y URL DEL LUGAR
        startActivity(i)
    } // METHOD PARA COMPARTIR EL LUGAR


    fun llamarTelefono(lugar: Lugar) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${lugar.telefono}"))
        startActivity(intent)
    } // METHOD PARA LLAMAR AL TELÉFONO DEL LUGAR


    fun verPgWeb(lugar: Lugar) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(lugar.url))
        startActivity(intent)
    } // METHOD PARA VER LA PÁGINA WEB DEL LUGAR


    /* El cuarto obtiene la latitud y longitud del lugar.
    Si alguna de las dos es distinta de cero, consideraremos que se ha introducido esta
    información y crearemos una URI basada en estos valores. Si son cero, consideraremos
    que no se han introducido, por lo que crearemos una URI basándonos en la dirección
    del lugar.  */
    fun verMapa(lugar: Lugar) {
        val lat = lugar.posicion.latitud
        val lon = lugar.posicion.longitud
        val uri = if (lat != 0.0 && lon != 0.0) {
            Uri.parse("geo:$lat,$lon")
        } else {
            Uri.parse("geo:0,0?q=${lugar.direccion}")
        }
        startActivity(Intent(Intent.ACTION_VIEW, uri))
    } // METHOD PARA VER EL MAPA DEL LUGAR


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.accion_compartir -> {
                compartir(lugar)  // LLAMAMOS AL METHOD PARA COMPARTIR EL LUGAR
                return true
            }

            R.id.accion_llegar -> {
                verMapa(lugar)  // LLAMAMOS AL METHOD PARA VER EL MAPA DEL LUGAR
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    } // METHOD PARA MANEJAR LAS OPCIONES DEL MENU


    fun verMapa(view: android.view.View) {
        verMapa(lugar);
    }

    fun llamarTelefono(view: android.view.View) {
        llamarTelefono(lugar);
    }

    fun verPgWeb(view: android.view.View) {
        verPgWeb(lugar);
    }


    fun fotoDeGaleria(view: android.view.View) {
        val intent =
            Intent(Intent.ACTION_OPEN_DOCUMENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "image/*"
        galeriaLauncher.launch(intent)
    } // METHOD PARA SELECCIONAR UNA FOTO DE LA GALERÍA


    private val galeriaLauncher =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
            ActivityResultCallback<ActivityResult> { result ->
                if (result.resultCode == RESULT_OK) {
                    val uri = result.data?.data
                    uri?.let {
                        contentResolver.takePersistableUriPermission(
                            uri,
                            Intent.FLAG_GRANT_READ_URI_PERMISSION
                        )
                        lugar.setFoto(uri.toString())  // GUARDAMOS LA FOTO EN EL LUGAR
                        ponerFoto(foto, uri.toString())  // MOSTRAMOS LA FOTO EN EL IMAGEVIEW
                    }
                } else {
                    Toast.makeText(this, "Foto no cargada", Toast.LENGTH_LONG).show()
                }
            }) // ACTIVITY RESULT PARA SELECCIONAR UNA FOTO DE LA GALERÍA


    private fun ponerFoto(imageView: ImageView, uri: String?) {
        if (!uri.isNullOrEmpty()) {
            imageView.setImageURI(Uri.parse(uri))
        } else {
            imageView.setImageBitmap(null) // SI NO HAY FOTO, QUITAMOS LA IMAGEN
        }
    }  // METHOD PARA MOSTRAR LA FOTO EN EL IMAGEVIEW


    fun tomarFoto(view: android.view.View) {
        try {
            val file = File.createTempFile(
                "img_${System.currentTimeMillis() / 1000}",
                ".jpg",
                getExternalFilesDir(null)
            )
            uriUltimaFoto =
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    FileProvider.getUriForFile(this, "com.example.mislugares.fileprovider", file)
                } else {
                    Uri.fromFile(file)
                }
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uriUltimaFoto)
            tomarFotoLauncher.launch(intent)
        } catch (e: IOException) {
            Toast.makeText(this, "Error al crear fichero de imagen", Toast.LENGTH_LONG).show()
        }
    } // METHOD PARA TOMAR UNA FOTO DESDE LA CÁMARA


    private val tomarFotoLauncher =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
            ActivityResultCallback<ActivityResult> { result ->
                if (result.resultCode == RESULT_OK && uriUltimaFoto != null) {
                    lugar.setFoto(uriUltimaFoto.toString())  // GUARDAMOS LA FOTO TOMADA EN EL LUGAR
                    ponerFoto(foto, lugar.foto)  // MOSTRAMOS LA FOTO EN EL IMAGEVIEW
                } else {
                    Toast.makeText(this, "Error en captura", Toast.LENGTH_LONG).show()
                }
            })  // ACTIVITY RESULT PARA TOMAR UNA FOTO DESDE LA CÁMARA


    fun eliminarFoto(view: android.view.View) {
        lugar.setFoto("")  // ELIMINAMOS LA FOTO DEL LUGAR
        ponerFoto(foto, "")  // QUITAMOS LA FOTO EN EL IMAGEVIEW
    } // METHOD PARA ELIMINAR UNA FOTO DEL LUGAR


    private fun actualizarVistas() {
        ponerFoto(foto, lugar.foto)  // MOSTRAMOS LA FOTO DEL LUGAR AL CARGAR
    } // METHOD PARA ACTUALIZAR LAS VISTAS AL CARGAR O MODIFICAR EL LUGAR


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vista_lugar)
        foto = findViewById(R.id.)
    } // METHOD ONCREATE PARA INICIALIZAR LOS COMPONENTES Y LA ACTIVIDAD
}