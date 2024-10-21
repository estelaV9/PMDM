import java.util.Scanner

/* Ejercicio 2: Diseña una función con sintaxis lambda que devuelva(true o false) si
un número es mágico.
Los números mágicos son aquellos que al elevarlos al cubo y sumamos sus cifras nos dan
el mismo resultado. Para probarla puede asignar la función a una variable */

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var sumaCifras = 0 // VARIABLE PARA SUMAR LAS CIFRAS DEL NUMERO

    print("Introduzca un numero: ")
    val numero = scanner.nextInt()
    var numCubo = numero * numero * numero // SE ELEVA AL CUBO EL NUMERO

    // FUNCION LAMBDA QUE DEVUELVE LA VARIABLE esMagico SI LA SUMA DE SUS CIFRAS ES IGUAL AL NUMERO
    val esNumeroMagico = { num: Int ->
        while (numCubo > 0) {
            sumaCifras += numCubo % 10 // SUMAMOS LAS CIFRAS (al dividir el numero entre 10 el resto dara la cifra del numero)
            numCubo /= 10 // DIVIDIMOS ENTRE 10 PARA SABER SI TIENE MAS DIGITOS
        } // BUCLE PARA RECORRER SUS DIGITOS, MIENTRAS SEA MAYOR QUE 0 SUMARA LAS CIFRAS

        val esMagico = (sumaCifras == numero) // GUARDA EN LA VARIABLE SI LA SUMA DE LAS CIFRAS ES IGUAL AL NUMERO
        esMagico // RETORNA LA VARIABLE
    }

    // INVOCAMOS A LA FUNCION Y DEPENDIENDO SI DEVUELVE TRUE O FALSE LANZARA UN MENSAJE
    if (esNumeroMagico(numCubo)) {
        println("El numero $numero ES un numero magico")
    } else {
        println("El numero $numero NO es un numero magico")
    }
}