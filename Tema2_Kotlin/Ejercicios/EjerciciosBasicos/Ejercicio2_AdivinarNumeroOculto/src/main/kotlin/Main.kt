import java.util.*
import kotlin.random.Random // IMPORTAR LA CLASE RANDOM
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`) // DECLARAR EN UNA VARIABLE VAL EL SCANNER
    var opcion:Int = -1
    var numIntentos:Int
    var numMaxGenerado = 0
    var numeroAleatorio:Int // GUARDAR EL NUMERO ALEATORIO
    print("*********** Adivinar el número oculto ***********")
    while (opcion != 3) {
        println("MENU" +
            "\n1 - Configurar." +
            "\n2 - Jugar." +
            "\n3 - Salir.")
        println("Introducir opcion: ")
        opcion = scanner.nextInt()
        when (opcion){
            1 -> {
                println("********* CONFIGURAR *********")
                println("¿Cuántos intentos deseas permitir?")
                numIntentos = scanner.nextInt()
                println("¿Cual es el número máximo a adivinar?")
                numMaxGenerado = scanner.nextInt()
            }
            2 -> {
                println("******** JUGAR *******")
                if (numMaxGenerado == 0) {
                    println("No has introducido ningún numero máximo a adivinar")
                } else {
                    // GENERAR UN NUMERO ALEATORIOENTRE 0 Y 9 (EXCLUYENDO EL 10)
                    numeroAleatorio = Random.nextInt(numMaxGenerado + 1)

                    println("Número aleatorio: $numeroAleatorio")
                }
            }
            3 -> {
                println("¡Hasta pronto!")
                exitProcess(0)
            }
        }
    }
}