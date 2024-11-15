package Model

import kotlin.properties.Delegates

abstract class CuentaBancaria(
    protected var titular: Persona,
    protected var saldo: Double,
    protected var iban: String
) {


    override fun toString(): String {
        return "CuentaBancaria(titular=$titular, saldo=$saldo, iban='$iban')"
    }
}
