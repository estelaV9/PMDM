package Model

import android.content.Context
import android.widget.Toast
import com.example.simulacroexamen_android.Utilities.mensaje
import java.time.LocalDate

// CLASE TAREA: HEREDA DE LA CLASE ACTIVIDAD E IMPLEMENTA LA INTERFACE RECORDATORIO
class Tarea(
    nombre: String,
    completada: Boolean,
    private var fecha_limite: LocalDate?, // PUEDE ADMITIR VALORES NULOS
    private var notificacion: Notificacion?, // VARIABLE TIPO NOTIFICACION, PUEDE NULOS
    private var urgencia: Urgencia // VARIABLE TIPO ENUM
) : Actividad(nombre, completada), Recordatorio {

    override fun mostrarDetalle():String{
        return "La tarea '$nombre'. " +
                "Completada: $completada. " +
                "Fecha limite: $fecha_limite. " +
                "Notificacion: Activo - ${notificacion?.activo} | FechaHora - ${notificacion?.fecha_hora_notificacion}." +
                "Urgencia: $urgencia"
    } // SOBREESCRITURA GENERANDO UN STRING CON EL DETALLE COMPLETO DE UNA TAREA

    override fun programarRecordatorio(context: Context) {
        if (notificacion?.activo == true) {
            context.mensaje("Recordatorio activo para la tarea '$nombre' en la fecha $fecha_limite")
        } else {
            context.mensaje("No hay recordatorio activo para la tarea '$nombre'.")
        }
    } // DEFINIR UNA NOTIFICACION QUE SE MUESTRE EN

    override fun cancelarRecordatorio(context: Context) {
        if(notificacion == null){
            context.mensaje("No se puedo cancelar recordatorio ya que notificacion es nulo")
        } else if(notificacion?.activo == true){
            notificacion = null // SE CANCELA LA NOTIFICACION
            context.mensaje("Se ha cancelado el recordatorio correctamente")
        }
    }

    enum class Urgencia {
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
        abstract fun definirColor(): String // DEVUELVE EL COLOR SEGUN LA URGENCIA
    } // CLASE TIPO ENUM CON 3 VALORES

    inner class Notificacion(
        var fecha_hora_notificacion: LocalDate, // MOMENTO DONDE SE PROGRAMARA LA NOTIFICACION
        var activo: Boolean // MARCA SI LA NOTIFICACION ES ACTIVA
    ) {
    }
}