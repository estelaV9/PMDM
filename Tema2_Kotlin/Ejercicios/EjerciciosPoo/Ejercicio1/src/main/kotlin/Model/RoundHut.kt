package org.example.Model
// open para que puedan heredar de ella
open class RoundHut(residents: Int) : Dwelling(residents) {
    override val buildingMaterial = "Straw"
    override val capacity = 4
}