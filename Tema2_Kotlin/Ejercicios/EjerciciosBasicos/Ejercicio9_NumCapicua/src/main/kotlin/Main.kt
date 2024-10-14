import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner (System.`in`)

    println("NUMERO CAPICUA")
    println("Introduzca un numero")
    var numero = scanner.nextInt()

    if(numero < 0) {
        println("Por favor, introduzca un numero positivo")
    } // SI EL NUMERO ES NEGATIVO MOSTRAR ERROR

    if (isCapicua(numero)){
        println("$numero ES capicua")
    } else {
        println("$numero NO es capicua")
    } // COMPROBAR SI ES CAPICUA
}

fun isCapicua (numero:Int): Boolean{
    val listNumber = mutableListOf<Int>() // LISTA PARA GUARDAR LOS DIGITOS
    var numAux = numero
    var numeroInvertido = ""

    while (numAux % 10 > 0) {
        listNumber.add(numAux % 10)
        numAux /= 10
    } // SE AÑADEN LOS DIGITOS AL ARRAY

    // SE ITERA DESDE EL ULTIMO INDICE DE ListNumber HASTA EL PRIMER INDICE
    /** Para iterar a un rango decreciente se usa 'downTo', asi el bucle
     * se itera desde el ultimo indice hasta el primero **/
    for (i:Int in listNumber.size - 1 downTo 0){
        // CONCATENA LOS NUMEROS
        numeroInvertido += listNumber[i]
    }
    return numeroInvertido == numero.toString() // DEVUELVE TRUE O FALSE SEGUN SE CUMPLA O NO LA CONDICION
} // FUNCION QUE RETORNA SI EL NUMERO ES UN CAPICUA O NO