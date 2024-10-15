package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    // OBJETO CON CONSTRUCTOR PRINCIPAL
    var miVehiculo = Vehiculo("Renault", "Kadjar", "9843KLS")

    // OBJETO CON NUMERO DE PLAZAS Y MOTOR (constructor secundario)
    var miVehiculo2 = Vehiculo("Volkswagen", "Tuareg", "2333MMM", 4, "2000cc")

    miVehiculo2.modelo = "nuevo modelo" // LLAMAR AL METODO SET
    println(miVehiculo.modelo) // LLAMAR AL METODO GET
}