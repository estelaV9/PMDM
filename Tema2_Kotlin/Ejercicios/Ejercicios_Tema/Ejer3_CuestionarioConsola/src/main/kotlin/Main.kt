import Model.Pregunta
import java.lang.NumberFormatException
import java.util.*
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    /* SE CREAN LOS OBJETOS DE LAS PREGUNTAS */
    val pregunta1 = Pregunta(
        "¿Cuál es la capital de Francia?",
        Pregunta.TipoDificultad.MEDIA, "PARIS"
    )

    val pregunta2 = Pregunta(
        "¿Cuál es la respuesta correcta? a) Opción1 b) Opción2 c) Opción3 d) Opción4",
        Pregunta.TipoDificultad.ALTA, "b"
    )

    val pregunta3 = Pregunta(
        "La Tierra es plana: verdadero o falso (true/false)",
        Pregunta.TipoDificultad.FACIL, false // Cambiado a un Booleano
    )

    val pregunta4 = Pregunta(
        "¿Cuánto es 5 x 5?",
        Pregunta.TipoDificultad.FACIL, 25
    )
    println("**************** CUESTIONARIO *********************")
    println("1 - ${pregunta1.dificultad} :  ${pregunta1.pregunta}")
    val respuesta1 = scanner.nextLine()
    println("2 - ${pregunta2.dificultad} :  ${pregunta2.pregunta}")
    val respuesta2 = scanner.nextLine()
    println("3 - ${pregunta3.dificultad} :  ${pregunta3.pregunta}")
    var respuesta3 = scanner.nextLine().lowercase()
    while (respuesta3 != "true" && respuesta3 != "false") {
        println("Debe introducir true/false, por favor")
        respuesta3 = scanner.nextLine()
    } // VALIDAR QUE LA RESPUESTA SEA TRUE O FALSE

    println("4 - ${pregunta4.dificultad} :  ${pregunta4.pregunta}")
    val respuesta4: Int // INICIALIZAR LA RESPUESTA 4
    try {
        respuesta4 = scanner.nextLine().toInt() // SE CONVIERTE EN UN ENTERO
    } catch (e: NumberFormatException) {
        // CONTROLAR QUE NO PONGA UNA CADENA EN UN CAMPO NUMERICO
        println("Debe introducir un numero numerico")
        exitProcess(0) // SALIR DEL PROGRAMA
    }


    println("**************** CORRECCION *********************")
    if (pregunta1.corregirRespuesta(respuesta1.uppercase())) {
        println("Has acertado la 1")
    } else {
        println("Has fallado la 1, la respuesta correcta es " + pregunta1.respuesta)
    }

    if (pregunta2.corregirRespuesta(respuesta2.lowercase())) {
        println("Has acertado la 2")
    } else {
        println("Has fallado la 2, la respuesta correcta es " + pregunta2.respuesta)
    }

    if (pregunta3.corregirRespuesta(respuesta3.toBoolean())) { // SE PASA COMO BOOLEANO
        println("Has acertado la 3")
    } else {
        println("Has fallado la 3, la respuesta correcta es " + pregunta3.respuesta)
    }

    if (pregunta4.corregirRespuesta(respuesta4)) {
        println("Has acertado la 4")
    } else {
        println("Has fallado la 4, la respuesta correcta es " + pregunta4.respuesta)
    }
}