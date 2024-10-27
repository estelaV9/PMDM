package Model

class Pregunta( // CONSTRUCTOR PRIMARIO
    var pregunta: String,
    var dificultad: TipoDificultad,
    var respuesta: Any // SE PONE ANY PARA QUE ACEPTE CUALQUIER DATO (int, bool..)
) {

    enum class TipoDificultad {
        FACIL, MEDIA, ALTA
    } // ENUM PARA EL TIPO DE DIFICULTAD

    fun <T> corregirRespuesta(respuestaIntroducida: T): Boolean {
        return respuestaIntroducida == this.respuesta // SI ES IGUAL A LA RESPUESTA, DEVUELVE TRUE
    } // FUNCION PARA CORREGIR LAS RESPUESTAS INTRODUCIDAS
}