import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    println("Introduzca una letra para adivinar la palabra. Si desea para escriba 'salir'")
    val palabraAdivinar = mutableListOf("s", "h", "r", "e", "k") // LISTA CON LOS CARACTERES DE LA PALABRA
    var palabra: String // GUARDAR CARACTER INTRODUCIDO POR EL USUARIO
    // LISTA PARA GUARDAR TODAS LAS PALABRAS QUE HA INTRODUCIDO EL USUARIO QUE SI QUE CONTIENE LA PALABRA A ADIVINAR
    val listPalabrasIntroducidas = mutableListOf<String>()

    do {
        palabra = scanner.next()
        if (estaPalabra(palabra, palabraAdivinar)) {
            println("La palabra $palabra SI esta")
            listPalabrasIntroducidas.add(palabra)
        } else {
            println("La palabra $palabra NO esta")
        } // COMPROBAR SI EL CARACTER INTRODUCIDO ESTA EN LA PALABRA A ADIVINAR

        if (listPalabrasIntroducidas.size == palabraAdivinar.size) {
            println("¡Felicidades! Has adivinado la palabra: '$palabraAdivinar'")
            break
        } else {
            // MOSTRAR LAS LETRAS ADIVINADAS
            println("Letras adivinadas: $listPalabrasIntroducidas")
        } // COMPROBAR SI LA LISTA DE CARACTERES QUE HA IDO ADIVINANDO EL USUARIO ES IGUAL AL TOTAL DE CARACTERES DE LA PALABRA A ADIVINAR
    } while (palabra != "salir")

    println("¡Vuelva pronto!")
}

fun estaPalabra(palabra: String, palabraAdivinar: List<String>): Boolean {
    for (i: Int in 0 until palabraAdivinar.size) {
        if (palabraAdivinar[i] == palabra) {
            println("La palabra $palabra SI esta")
            return true
        } // SI EL CARACTER SE ENCUENTRA EN LA PALABRA, RETORNAR TRUE
    } // RECORRER LA LISTA DE CARACTERES PARA VER SI ESTA LA PALABRA QUE HA INTRODUCIDO
    return false
} // METODO PARA SABER SI LA PALABRA ESTA O NO