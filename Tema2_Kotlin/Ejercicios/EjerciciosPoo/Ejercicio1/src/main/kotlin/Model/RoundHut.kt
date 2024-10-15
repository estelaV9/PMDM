package org.example.Model

class RoundHut(residents: Int) : Dwelling(residents) {
    override val buildingMaterial = "Straw"
    override val capacity = 4
}