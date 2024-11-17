package Model

open abstract class Actividad(
    var nombre: String, // NOMBRE DE LA ACTIVIDAD A REALIZAR
    var completada: Boolean // SABER SI LA ACTIVIDAD SE HA COMPLETADO
) {

    init {
        completada = false // INICIALMENTE LA ACTIVIDAD ESTARA EN FALSE
    }

    // METODOS
    fun marcarComoCompletada() {
        completada = true
        println("La actividad '$nombre' ha sido marcada como completada.")
    } // ESTABLECE A TRUE EL ATRIBUTO COMPLETADA

    open fun mostrarDetalle():String{
        return "Model.Actividad: $nombre | Completada: $completada"
    } // GENERA UN STRING CON LOS VALORES DE LOS ATRIBUTOS
}