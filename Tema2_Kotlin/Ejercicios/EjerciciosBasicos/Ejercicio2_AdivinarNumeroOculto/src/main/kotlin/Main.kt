import java.util.*
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`) // DECLARAR EN UNA VARIABLE VAL EL SCANNER
    var opcion:Int = -1
    var numIntentos:Int
    var numMaxGenerado:Int
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
                println("¿Cual es el número máximo para generar?")
                numMaxGenerado = scanner.nextInt()
            }
            2 -> {

            }
            3 -> {
                println("¡Hasta pronto!")
                exitProcess(0)
            }
        }
    }
}