import java.util.Scanner

/* Ejercicio 1:  Diseña una función con sintaxis lambda que devuelva (true o false) si
un número es primo. Para probarla puede asignar la función a una variable  */

fun main(args: Array<String>) {
    /** EJEMPLO LAMBDA: val suma = {a: Int, b:Int -> a + b}*/
    val scanner = Scanner(System.`in`)

    print("Introduzca un numero: ")
    val respuesta = scanner.nextInt()

    // FUNCION LAMBDA PARA SABER SI UN NUMERO ES PRIMO O NO
    val esPrimo = { num: Int ->
        var esPrimo = true // DECLARAMOS LA VARIABLES PARA SABER SI ES PRIMO O NO
        val raiz = Math.sqrt(num.toDouble()).toInt() // ASIGNAMOS EL VALOR DE LA RAIZ DEL NUMERO
        for (i in 2..raiz) {
            if (num % i == 0) {
                esPrimo = false
                break // SALE DEL BUCLE
            } // SI EL NUMERO ES DIVISIBLE POR i, NO ES PRIMO
        }
        esPrimo// DEVUELVE EL VALOR DE SI ES PRIMO O NO
    }

    // SE INVOCA A LA FUNCION Y DEPENDIENDO LO QUE DEVUELVA LANZARA UN MENSAJE U OTRO
    if (esPrimo(respuesta)) {
        println("$respuesta es primo")
    } else {
        println("$respuesta NO es primo")
    }
}