package org.example.Model

// CREAR UNA CLASE QUE ESTE RELACIONADA A LA CLASE DE Dwelling
// (se implementara las partes abstractas de la clase)
// SE HERDA PONIENDO ':'
// SE PASARA COMO PARAMETRO DE LA CLASE residentes
class SquareCabin(residents: Int) : Dwelling(residents){ // SE DEBEN PASAR LOS PARAMETROS OBLIGATORIOS
    // IMPLEMENTAR ATRIBUTOS DE LA CLASE ABSTRACTA
    override val buildingMaterial = "Wood"
    override val capacity = 6
}