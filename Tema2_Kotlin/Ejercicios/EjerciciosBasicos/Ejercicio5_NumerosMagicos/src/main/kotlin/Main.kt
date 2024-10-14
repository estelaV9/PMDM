fun main(args: Array<String>) {
    println("Numeros magicos")
    for (i: Int in 1..1000) {
        if (esMagico(i)) {
            println("$i es un numero mágico")
        } else {
            println("$i NO es un numero mágico")
        }
    }

}

fun esMagico(numero: Int): Boolean {
    var elevarCubo: Int
    elevarCubo = numero * numero * numero
    var numAux = elevarCubo
    var sumaNumeros = 0

    while (numAux > 0) {
        val digito = numAux % 10 // EXTRAER EL ULTIMO DIGITO
        sumaNumeros += digito
        numAux /= 10 // ELIMINAR EL ULTIMO DIGITO
    }
    return sumaNumeros == numero // RETORNAR SI ES MAGICO O NO

} // FUNCION PARA DECIR SI UN NUMERO ES MAGICO O NO
