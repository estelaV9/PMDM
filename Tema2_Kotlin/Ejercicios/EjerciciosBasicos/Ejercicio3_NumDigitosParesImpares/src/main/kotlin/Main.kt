import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var contadorPares = 0
    var contadorImpares = 0
    var contadorDigitos = 0

    println("Introduzca un numero: ")
    val numIntroducido:Int = scanner.nextInt()
    var numAuxiliar = numIntroducido // VARIABLE AUXILIAR PARA IR REDUCIENDO

    while (numAuxiliar > 0) {
        val digito = numAuxiliar % 10 // EXTRAER EL ULTIMO DIGITO
        contadorDigitos++
        if (digito % 2 == 0) {
            contadorPares++
        } else {
            contadorImpares++
        }
        numAuxiliar = numAuxiliar / 10 // ELIMINAR EL ULTIMO DIGITO
    }
    println("El numero $numIntroducido tiene $contadorDigitos digitos " +
            "los cuales $contadorPares son digitos pares y $contadorImpares " +
            "son digitos impares")
}