package org.example.Model

/*// ES UNA SUBCLASE DE RoundHut
class RoundTower(residents: Int): RoundHut(residents) {
    override val buildingMaterial = "Stone"
    override val capacity = 4
}*/


// MODIFICAR LA CLASE PARA QUE TENGA VARIOS PISOS Y AJUSTAR LA CAPACIDAD
// SEGUN SU CANTIDAD
// SE AÑADE UN NUEVO PARAMETRO PARA RECOGER LA CANTIDAD DE PISOS
// SE INICIALIZA CON 2 PARA DARLE UN VALOR PREDETERMINADO
class RoundTower(residents: Int, val floors: Int = 2): RoundHut(residents) {
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors // ACTUALIZAR capacity Y MULTIPLICARLA POR LA CANTIDAD DE PISOS
}