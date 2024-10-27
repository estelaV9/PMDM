/* Ejercicio 4.- Diseñe una función de orden superior que reciba como parámetro un
array de enteros y una función (en forma de expresión lambda) y devuelva un array
de enteros con los valores filtrados según la función que se le pase como segundo
argumento. La función que se le pasa como 2º parámetro recibe un número entero
y devuelve un boolean. */
fun main(args: Array<String>) {
    // SE USA ARRAY YA QUE NO SE VA A MODIFICAR LOS VALORES
    val arrayEnteros: Array<Int> = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    // FUNCION LAMBDA -> RECIBE UN NUMERO Y DEVUELVE UN VALOR BOOLEANO
    val isPar: (Int) -> Boolean = { num:Int ->
        num % 2 == 0 // SI EL RESTO DEL NUMERO DIVIDIDO ENTRE 2 ES IGUAL A 0, DEVUELVE TRUE
    }

    // FUNCION DE ORDEN SUPERIOR QUE RECIBE UN ARRAY Y LA FUNCION LAMBDA Y DEVUELVE UNA LISTA
    fun valoresFiltrados(arrayEnteros: Array<Int>, funIsPar: (Int) -> Boolean): MutableList<Int> {
        // SE INICIALIZA LA LISTA MUTABLE
        val arrayNumerosFiltrados: MutableList<Int> = mutableListOf() // COMO VAMOS A MANIPULAR DATOS, SE USA MUTABLELIST

        for (i in arrayEnteros){
            if(funIsPar(i)){
                arrayNumerosFiltrados.add(i) // SE AÑADE EL NUMERO i A LA LISTA MUTABLE
            } // SI LA FUNCION isPar DEVUELVE TRUE SE AÑADE A LA LISTA MUTABLE
        } // RECORRER EL ARRAY
        return arrayNumerosFiltrados // RETORNA LA LISTA MUTABLE
    }
    println(valoresFiltrados(arrayEnteros, isPar))
}