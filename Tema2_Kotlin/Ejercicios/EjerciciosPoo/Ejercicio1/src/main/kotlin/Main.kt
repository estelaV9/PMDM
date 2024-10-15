package org.example

import org.example.Model.Dwelling
import org.example.Model.RoundHut
import org.example.Model.RoundTower
import org.example.Model.SquareCabin

fun main() {
    // NO SE PUEDE CREAR UNA INSTANCIA DE Dwelling YA QUE ES UNA CLASE ABSTRACTA
    // val dwelling = Dwelling()

    /*********** CREAR UNA INSTANCIA DE SquareCabin ************/
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

    /*********** CREAR UNA INSTANCIA DE RoundHut ************/
    val roundHut = RoundHut(3)
    // IMPRIMIR INFORMACION
    with(roundHut) {
        println("\nRound Hut\n=========")
        println("Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Has room? ${hasRoom()}")
    }

    /*********** CREAR UNA INSTANCIA DE RoundTower ************/
    val roundTower = RoundTower(4)
    // IMPRIMIR INFORMACION
    with(roundTower) {
        println("\nRound Tower\n==========")
        println("Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Has room? ${hasRoom()}")
    }
}