package org.example

import org.example.Model.Dwelling
import org.example.Model.SquareCabin

fun main() {
    // NO SE PUEDE CREAR UNA INSTANCIA DE Dwelling YA QUE ES UNA CLASE ABSTRACTA
    // val dwelling = Dwelling()

    // CREAR INSTANCIA DE SquareCabin
    // DENTRO DE LA INSTANCIA SE AGREGARAN LAS SENTENCIAS DE LA CLASE ABSTRACTA
    // (Agrega sentencias de impresión para el material de construcción, la capacidad y la función hasRoom().)
    val squareCabin = SquareCabin(6)
    println("\nSquare Cabin\n============")
    println("Capacity: ${squareCabin.capacity}")
    println("Material: ${squareCabin.buildingMaterial}")
    println("Has room? ${squareCabin.hasRoom()}")

    // CUANDO TRABAJAS CON UNA INSTANCIA ESPECIFICA SE PUEDE HACER TODAS LAS OPERACIONES
    // CON EL OBJETO DE INSTANCIA USANDO UNA SENTECIA 'with'
    // (asi no repetimos el nombre de la instancia cada vez que queramos un atributo)
    with(squareCabin) {
        println("\nSquare Cabin\n============")
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room? ${hasRoom()}")
    }
}