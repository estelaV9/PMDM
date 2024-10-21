import java.util.Scanner

/* Ejercicio 3: Diseña una función con sintaxis lambda que devuelva (true o false) si
un número es capicúa (se lee igual de izquierda a derecha que de derecha a
izquierda). Para probarla puede asignar la función a una variable */
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    println("Introduzca un numero: ")
    val numero = scanner.nextInt()

    var numeroInvertido = "" // DECLARAMOS UNA CADENA VACIA DONDE CONCATENAREMOS LAS CIFRAS DEL NUMERO
    var numAux = numero // VARIABLE AUXILIAR PARA OPERAR CON EL NUMERO
    var numCifra: Int // VARIABLE PARA GUARDAR LA CIFRA DEL NUMERO

    // FUNCION LAMBDA PARA SABER SI UN NUMERO ES CAPICUA O NO
    val isCapicua = { num: Int ->
        while (numAux > 0) {
            numCifra = numAux % 10 // SE GUARDA LA CIFRA DEL NUMERO COGIENDO EL RESTO DE DIVIDIR EL NUMERO ENTRE 10
            numeroInvertido += numCifra // SE CONCATENA LA CIFRA
            numAux /= 10 // SE DIVIDE ENTRE DIEZ PARA PASAR AL SIGUIENTE DIGITO
        } // BUCLE QUE RECORRE TODOS LOS DIGITOS DEL NUMERO

        // SE CONVIERTE EL NUMERO A STRING Y SE GUARDA EN UNA VARIABLE SI EL NUMERO ES IGUAL O NO
        // AL NUMERO INVERTIDO
        var esNumeroCapicua = (numero.toString() == numeroInvertido)
        esNumeroCapicua // DEVUELVE LA VARIABLE
    }

    // DEPENDIENDO LO QUE DEVUELVA LA FUNCION, MOSTRARA UN MENSAJE U OTRO
    if (isCapicua(numero)) {
        println("El numero $numero ES capicua")
    } else {
        println("El numero $numero NO es capicua")
    }
}