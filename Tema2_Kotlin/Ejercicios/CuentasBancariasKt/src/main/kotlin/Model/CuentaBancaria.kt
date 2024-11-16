package Model

abstract class CuentaBancaria(
    protected var titular: Persona,
    protected var saldo: Double,
    protected var iban: String
) : Interface {
}
