package Model

abstract class CuentaBancaria(
    protected var titular: Persona,
    protected var saldo: Double,
    protected var _iban: String
) : Interface {

    // SE AÑADE UN GETTER
    val iban: String
        get() = _iban
}