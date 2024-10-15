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

/* Cambiar el constructor de RoundTower de modo que también tome el radius.
 Recuerda pasar el radius al constructor de la clase superior.*/
class RoundTower(residents: Int, radius: Double, val floors: Int = 2): RoundHut(residents, radius) {
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors // ACTUALIZAR capacity Y MULTIPLICARLA POR LA CANTIDAD DE PISOS

    override fun floorArea(): Double {
        // La superficie de la planta de una vivienda circular es igual a PI * radio * radio.
        // PARA NO REPETIR CODIGO COMO : return PI * radius * radius * floors USAMOS:
        return super.floorArea() * floors
    } // IMPLEMENTAR LA FUNCION DE LA CLASE ABSTRACTA
}