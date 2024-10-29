package Model

// CLASE GENERICA
class Pregunta<T> ( // CONSTRUCTOR PRIMARIO
    var pregunta: String,
    var dificultad: TipoDificultad,
    var respuesta: T
) {

    enum class TipoDificultad {
        FACIL, MEDIA, ALTA
    } // ENUM PARA EL TIPO DE DIFICULTAD

    /* enum class Test */
    enum class Test {
        A, B, C, D
    }

    fun <T> corregirRespuesta(respuestaIntroducida: T): Boolean {
        return respuestaIntroducida == this.respuesta // SI ES IGUAL A LA RESPUESTA, DEVUELVE TRUE
    } // FUNCION PARA CORREGIR LAS RESPUESTAS INTRODUCIDAS
}