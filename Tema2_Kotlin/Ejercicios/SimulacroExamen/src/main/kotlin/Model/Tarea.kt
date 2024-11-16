package Model

import java.time.LocalDate
import java.util.Objects

// Clase Tarea.- Hereda de la clase Actividad e implementa la interface Recordatorio
class Tarea(
    nombre: String,
    completada: Boolean,
    var fecha_limite: LocalDate?, // PUEDE ADMITIR VALORES NULOS
    var notificacion: Notificacion?, // VARIABLE TIPO NOTIFICACION, PUEDE NULOS
    var urgencia: Urgencia // VARIABLE TIPO ENUM
    ) : Actividad(nombre, completada), Recordatorio {
    override fun programarRecordatorio() {

    } // DEFINIR UNA NOTIFICACION QUE SE MUESTRE EN

    override fun cancelarRecordatorio() {
        TODO("Not yet implemented")
    }

    enum class Urgencia{
        ALTO {
            override fun definirColor(): String = "Rojo"
        },
        MEDIO {
            override fun definirColor(): String = "Naranja"
        },
        BAJO {
            override fun definirColor(): String = "Verde"
        };

        // METODO PARA VINCULAR EL TIPO DE URGENCIA CON UN COLOR
        abstract fun definirColor():String // DEVUELVE EL COLOR SEGUN LA URGENCIA
    } // CLASE TIPO ENUM CON 3 VALORES

    inner class Notificacion{

    }
}