import java.util.Scanner

fun main(args: Array<String>) {
    val reader = Scanner(System.`in`)
    var numIntroducido: Int
    // DECLARAMOS UNA LISTA MUTABLE VACIA DE ENTEROS
    var listNum = mutableListOf<Int>()
    println("Introduzca varios numeros. Si desea para introduzca 0")
    do {
        numIntroducido = reader.nextInt()
        if (numIntroducido != 0) {
            listNum.add(numIntroducido)
        } // NO AGREGAR 0 A LA LISTA
    } while (numIntroducido != 0)

    println("El numero mayor de los numeros introducidos es ${encontrarMayor(listNum)}")
}

fun encontrarMayor(listNum: List<Int>): Int {
    var numMayor = listNum[0] // Inicializar el numero mayor con el primer elemento en la lista
    for (i in listNum) {
        if (i > numMayor) {
            numMayor = i
            println(i)
        } // COMPARAR EL VALOR CON EL NUMERO MAYOR
    }
    return numMayor
}