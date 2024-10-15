package org.example.Model

// ES UNA SUBCLASE DE RoundHut
class RoundTower(residents: Int): RoundHut(residents) {
    override val buildingMaterial = "Stone"
    override val capacity = 4
}