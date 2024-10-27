import java.util.*
import kotlin.random.Random // IMPORTAR LA CLASE RANDOM
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`) // DECLARAR EN UNA VARIABLE VAL EL SCANNER
    var opcion: Int = -1
    var numIntentos = 5 // valores por defecto
    var numMaxGenerado = 10 // valores por defecto
    var numeroAleatorio: Int // GUARDAR EL NUMERO ALEATORIO
    var numIntroducido: Int // GUARDAR EL NUMERO QUE VAYA A INTRODUCIR EL USUARIO
    print("*********** Adivinar el número oculto ***********")
    while (opcion != 3) {
        try {
            println(
                "MENU" +
                        "\n1 - Configurar." +
                        "\n2 - Jugar." +
                        "\n3 - Salir."
            )
            println("Introducir opcion: ")
            opcion = scanner.nextInt()
            when (opcion) {
                1 -> {
                    println("********* CONFIGURAR *********")
                    configuracion()
                }

                2 -> {
                    println("******** JUGAR *******")
                    // GENERAR UN NUMERO ALEATORIOENTRE 0 Y 9 (EXCLUYENDO EL 10)
                    numeroAleatorio = Random.nextInt(numMaxGenerado + 1)
                    println("Introduzca numeros para ver si adivinas")
                    numIntroducido = scanner.nextInt()
                    if (numIntroducido == numeroAleatorio) {
                        // Si el usuario adivina el numero, se muestra un mensaje
                        println("Has ganado! Has necesitado $numIntentos")
                    } else {
                        numIntentos--
                        if (numIntroducido < numeroAleatorio) {
                            println("PISTA: el número oculto es mayor")
                        } else {
                            println("PISTA: el número oculto es menor")
                        }
                    }
                    if (numIntentos == 0) {
                        println("¡Perdiste! Se acabaron los intentos. El número era: $numeroAleatorio.")
                    } else {
                        println("Te quedan $numIntentos intentos.")
                    }
                }

                3 -> {
                    println("¡Hasta pronto!")
                    exitProcess(0) // TERMINAR PROGRAMA
                }

                else -> println("Opción no válida. Elige una opción del menú.")
            }
        } catch (e: NumberFormatException) {
            println("El dato introducido debe ser numérico")
        }
    }
}


fun configuracion() {
    numIntentos = 0
    numMaxGenerado = 0
    try {
        while (numIntentos <= 0) {
            println("Escribe el número mínimo de intentos:")
            numIntentos = scanner.nextInt()
            if (numIntentos <= 0) {
                println("Debes agregar minimo un intento")
            }
        }
        while (numMaxGenerado <= 0 || numMaxGenerado < numIntentos) {
            println("Escribe el número máximo a escribir:")
            numMaxGenerado = scanner.nextInt()
            if (numMaxGenerado <= 0) {
                println("El número máximo no debería ser negativo o igual a 0")
            } else if (numMaxGenerado < numIntentos) {
                println("Escribe un número máximo mayor al de intentos")
            }
        }
    } catch (e: NumberFormatException) {
        println("No se puede escribir un valor no entero")
    }
}