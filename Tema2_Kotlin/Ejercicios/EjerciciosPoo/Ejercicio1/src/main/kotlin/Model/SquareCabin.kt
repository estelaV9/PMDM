package org.example.Model

// CREAR UNA CLASE QUE ESTE RELACIONADA A LA CLASE DE Dwelling
// (se implementara las partes abstractas de la clase)
// SE HERDA PONIENDO ':'
// SE PASARA COMO PARAMETRO DE LA CLASE residentes
// SE AGREGA EL PARAMETRO length Y SE DECLARA COMO VAL YA QUE LA LONGUITUD DE UN EDIFICIO NO CAMBIA
class SquareCabin(residents: Int, val length: Double) : Dwelling(residents){ // SE DEBEN PASAR LOS PARAMETROS OBLIGATORIOS
    // IMPLEMENTAR ATRIBUTOS DE LA CLASE ABSTRACTA
    override val buildingMaterial = "Wood"
    override val capacity = 6

    override fun floorArea(): Double {
        return length * length
    } // IMPLEMENTAR LA FUNCION floorArea
}