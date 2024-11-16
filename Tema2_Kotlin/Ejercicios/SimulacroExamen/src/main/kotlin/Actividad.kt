abstract class Actividad(
    protected var nombre: String, // NOMBRE DE LA ACTIVIDAD A REALIZAR
    protected var completada: Boolean // SABER SI LA ACTIVIDAD SE HA COMPLETADO
) {

    init {
        completada = false // INICIALMENTE LA ACTIVIDAD ESTARA EN FALSE
    }

    // METODOS
    fun marcarComoCompletada() {
        completada = true
        println("La actividad '$nombre' ha sido marcada como completada.")
    } // ESTABLECE A TRUE EL ATRIBUTO COMPLETADA

    fun mostrarDetalle():String{
        return "Actividad: $nombre | Completada: $completada"
    } // GENERA UN STRING CON LOS VALORES DE LOS ATRIBUTOS
}