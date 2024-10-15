package org.example.Model

abstract class Dwelling (private var residents: Int){
    // CREAR UNA VARIABLE PARA REPRESENTAR EL MATERIAL DE CONSTRUCCION
    // COMO EL MATERIA NO CAMBIARA, SE USA VAL
    abstract val buildingMaterial:String

    // CREAR VARIABLE DE CAPACIDAD (cantas personas pueden vivir en ella), TAMPOCO CAMBIA
    abstract val capacity: Int

    // CREAR VARIABLE DE RESIDENTES (cuantos residentes residen en la vivienda)
    // SERA UN PARAMETRO QUE SE PASE AL CONSTRUCTOR DE LA CLASE
    // SE USA DE TIPO PRIVATE PARA SOLO ACCEDER A ELLA DESDE LA PROPIA CLASE
    // (Dado que la cantidad de personas que viven en una vivienda suele ser información privada)

    fun hasRoom (): Boolean{
        // HAY ESPACIO SI LA CAPACIDAD ES MAYOR QUE LOS RESIDENTES, RETORNA TRUE O FALSE
        return residents < capacity
    } // FUNCION PARA DETERMINAR SI HAY ESPACIO PARA OTRO HABITANTE EN LA VIVIENDA

    abstract fun floorArea(): Double // MUESTRA LA SUPERFICIE CALCULADA POR PLANTA

    fun getRoom() {
        if (capacity > residents) {
            residents++ // INCREMENTAR RESIDENTES
            println("You got a room!")
        } else {
            println("Sorry, at capacity and no rooms left.")
        } // SOLO AGREGAR HABITANTE SI HAY CAPACIDAD RESTANTE
    } // FUNCION PARA AGREGAR LA CAPACIDAD PARA QUE OTRA PERSONA OBTENGA UNA HABITACION
}