package Model

class Examen(private val preguntas: Collection<Pregunta<*>>) { // LAS PREGUNTAS NO TIENEN UN TIPO
    fun realizar() {
        // SE PASA LA LISTA DE PREGUNTAS Y  PIDE LA RESPUESTA Y CUANDO LLEGA AL FINAL TE DICE LA CORRECCINO
        var puntos = 0 // SABER LA NOTA QUE TIENE EN EL EXAMEN

        preguntas.forEach { pregunta ->
            var respuesta: String? = null
            while (respuesta.isNullOrBlank()) {
                println(pregunta.pregunta)
                respuesta = readlnOrNull()
            } // MIENTRAS SE OBTENGA UNA RESPUESTA SE MUESTRA LA PREGUNTA

            // COMPROBAR SI LA RESPUESTA ES CORRECTA
            if (pregunta.corregirRespuesta(respuesta)) {
                println("Correcto!")
                puntos++
            } else println("Incorrecto")
        } // RECORRE LAS PREGUNTAS CON forEach PERMITE RECORRER CADA UNO DE LOS ELEMENTOS DE ESA COLECCION

        // Mostrar la nota con dos decimales
        println("Tu nota es: %.2f".format(puntos.toDouble() / preguntas.size * 10))
    }
}