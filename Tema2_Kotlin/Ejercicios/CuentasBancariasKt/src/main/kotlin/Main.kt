import java.util.Scanner

fun main(args: Array<String>) {
    var option: Int = -1
    val scanner = Scanner(System.`in`)
    println("Bienvenido a BankPal!")
    try {
        do {
            println("\n1-Abrir una nueva cuenta")
            println("\n2-Ver un listado de las cuentas disponibles")
            println("\n3-Obtener los datos de una cuenta concreta")
            println("\n4-Realizar un ingreso en una cuenta.")
            println("\n5-Retirar efectivo de una cuenta. ")
            println("\n6-Consultar el saldo actual de una cuenta.")
            println("\n7-Salir")

            println("Elige una opcion: ")
            option = scanner.nextInt()

            when (option) {
                1 -> {

                }

                2 -> {

                }

                3 -> {

                }

                4 -> {

                }

                5 -> {

                }

                6 -> {

                }

                7 -> {
                    println("Vuelva pronto!")
                    System.exit(0)
                }
            }


        } while (option != 7)
    } catch (e: Exception) {
        println("Ha ocurrido un error: $e")
    }
    println("adios!!")
}