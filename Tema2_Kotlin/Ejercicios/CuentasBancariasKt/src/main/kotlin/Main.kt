import Model.*
import java.util.Scanner

fun main(args: Array<String>) {
    var option: Int = -1
    val scanner = Scanner(System.`in`)
    println("Bienvenido a BankPal!")
    try {
        val cuentas: MutableList<CuentaBancaria> = mutableListOf()
        do {
            println("1-Abrir una nueva cuenta")
            println("2-Ver un listado de las cuentas disponibles")
            println("3-Obtener los datos de una cuenta concreta")
            println("4-Realizar un ingreso en una cuenta.")
            println("5-Retirar efectivo de una cuenta. ")
            println("6-Consultar el saldo actual de una cuenta.")
            println("7-Salir")

            println("Elige una opcion: ")
            option = scanner.nextInt()

            when (option) {
                1 -> {
                    println("*********** NUEVA CUENTA ************")
                    println("Introduzca los datos personales")
                    print("Nombre: ")
                    val nombre = scanner.next()
                    print("Apellidos: ")
                    val apellidos = scanner.next()
                    print("DNI: ")
                    val dni = scanner.next()
                    val titular = Persona(nombre, apellidos, dni)
                    println(
                        "Tipo de cuenta: " +
                                "\n1 - Cuenta de Ahorro" +
                                "\n2 - Cuenta Corriente personal" +
                                "\n3 - Cuenta Corriente de Empresa"
                    )
                    val tipoCuentaNum = scanner.nextInt()
                    println("Saldo inicial: ")
                    val saldoInicial = scanner.nextDouble()

                    println("Numero de Cuenta")
                    val iban = scanner.next()
                    when (tipoCuentaNum) {
                        1 -> {
                            println("Tipo de interes: ")
                            val tipoInteres = scanner.nextDouble()
                            val cuentaAhorro:CuentaBancaria = CuentaAhorro(titular, saldoInicial, iban, tipoInteres)
                            cuentas.add(cuentaAhorro)
                        }

                        2 -> {
                            println("Comision Mantenimiento: ")
                            val comisionMantenimiento = scanner.nextInt()
                            val ccpersonal:CuentaBancaria = CCPersonal(titular, saldoInicial, iban, comisionMantenimiento)
                            cuentas.add(ccpersonal)
                        }

                        3 -> {
                            println("Maximo Descubierto Permitido: ")
                            val maxDescubierto = scanner.nextInt()
                            println("Tipo interes por descubierto: ")
                            val tipoInteres = scanner.nextDouble()
                            println("ComisionFija: ")
                            val comisionFija = scanner.nextDouble()
                            val ccEmpresa:CuentaBancaria =
                                CCEmpresa(titular, saldoInicial, iban, maxDescubierto, tipoInteres, comisionFija)
                            cuentas.add(ccEmpresa)
                        }

                        else -> println("Numero no valido")
                    }
                }

                2 -> {
                    println("CUENTAS BANCARIAS")
                   for (c in cuentas){
                       println(c.devolverInfo())
                       println()
                    }
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