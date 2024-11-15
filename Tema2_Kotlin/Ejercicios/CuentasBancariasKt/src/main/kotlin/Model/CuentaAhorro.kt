package Model

open class CuentaAhorro (
    titular: Persona,
    saldo: Double,
    iban: String,
    private var tipoInteres: Double
) : CuentaBancaria(titular, saldo, iban) {

    init {
        this.titular = titular
        this.saldo = saldo
        this.iban = iban
    }



    override fun toString(): String {
        return "CuentaAhorro(tipoInteres=$tipoInteres)"
    }


}