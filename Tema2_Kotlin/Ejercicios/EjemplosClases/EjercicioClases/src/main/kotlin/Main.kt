package org.example

import Circulo
import Persona
import Trabajador

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    /*********** CLASE VEHICULO *********/
    // OBJETO CON CONSTRUCTOR PRINCIPAL
    var miVehiculo = Vehiculo("Renault", "Kadjar", "9843KLS")

    // OBJETO CON NUMERO DE PLAZAS Y MOTOR (constructor secundario)
    var miVehiculo2 = Vehiculo("Volkswagen", "Tuareg", "2333MMM", 4, "2000cc")

    miVehiculo2.modelo = "nuevo modelo" // LLAMAR AL METODO SET
    println(miVehiculo.modelo) // LLAMAR AL METODO GET

    /*********** CLASE PERSONA *********/
    // INVOCA AL CONTRUCTOR PINCIPAL CON EL VALOR POR DEFECTO PARA EL TELEFONO
    var p: Persona = Persona()
    var p2: Persona = Persona("76452154F")

    var t: Trabajador = Trabajador(1500.toDouble(), 983454545) // OBJETO TRABAJADOR
    var t1: Trabajador = Trabajador() // OBJETO VACIO
    var p4: Persona = Trabajador(2000.toDouble(), 83223322) // OBJETO POLIMORFISMO

    println(p4.devolver_Info()) // DEVUELVE INFO DE LA CLASE HIJA

    /* t.
     var p3:Persona=Persona("12422124R","luis",983454543)
     println("Dni: ${p3.dni} , Nombre:${p3.nombre}, Telefono:${p3.telefono}") */

    /* p.telefono
    p.nombre="luis"
    println(p.nombre)*/


    /*********** CLASE ABSTRACTA *********/
    var circulo: Circulo = Circulo((5).toDouble())

    circulo.dibujar()
    println(circulo.area)
}