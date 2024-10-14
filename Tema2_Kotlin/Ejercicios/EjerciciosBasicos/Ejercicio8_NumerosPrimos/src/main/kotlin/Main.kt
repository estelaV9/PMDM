import java.time.temporal.ValueRange
import java.util.Scanner

fun main(args: Array<String>) {
    // Defina una función Kotlin que devuelva si un número es primo o no.
    val scanner = Scanner (System.`in`)
    println("Introduzca un numero: ")
    var numero = scanner.nextInt()
    if(esNumeroPrimo(numero)){
        println("$numero es un numero primo")
    } else {
        println("$numero NO es un numero primo")
    } // COMPROBAR SI ES PRIMO O NO
}

fun esNumeroPrimo (numero:Int): Boolean{
    if (numero <= 1) {
        return false
    } // SI INTRODUCE UN NUMERO NEGATIVO, NO SERA PRIMO

    val raizCuadrada = Math.sqrt(numero.toDouble()).toInt() // RAIZ CUADRADA
    println(raizCuadrada)
    for (i:Int in 2..raizCuadrada){
        if (numero % i == 0) {
            return false
        } // SI HAY DIVISOR, NO ES PRIMO, SALE DEL BUCLE
    }
    return true // SI NO HAY DIVISOR, ES PRIMO
}