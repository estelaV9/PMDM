import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var sumaPuntuacion = 0 // ALMACENA LA PUNTUACION ACUMULADA DEL EXAMEN

    // CREAR UNA LISTA CON LAS PREGUNTAS DEL EXAMEN
    val preguntasExamen: List<String> = listOf(
        "¿Cuál es la capital de Francia?",
        "¿Cuál es la respuesta correcta? a) Opción1 b) Opción2 c) Opción3 d) Opción4",
        "La Tierra es plana: verdadero o falso (true/false)",
        "¿Cuánto es 5 x 5?"
    )

    // LISTA CON LAS RESPUESTAS DE LAS PREGUNTAS DEL EXAMEN
    val respuestasExamenes: List<String> = listOf(
        "paris", "b", "false", "25"
    )

    for (i in preguntasExamen.indices) {
        println(preguntasExamen[i]) // SE MUESTRA LA PREGUNTA
        val respuesta = scanner.nextLine().lowercase() // SE INTRODUCE LA RESPUESTA EN MINUSCULAS

        if (respuesta == respuestasExamenes[i]) {
            sumaPuntuacion += 1 // SUMA UN PUNTO A LA PUNTUACION TOTAL
        } // SE COMPARA LA RESPUESTA INTRODUCIDA CON LA RESPUESTA DE LA PREGUNTA
    } // RECORRER LOS INDICES DE LAS PREGUNTAS DEL EXAMEN

    println("Tu puntuacion en este examen es: $sumaPuntuacion")
}