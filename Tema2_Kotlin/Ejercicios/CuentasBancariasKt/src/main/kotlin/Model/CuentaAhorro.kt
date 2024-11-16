package Model

class CuentaAhorro(
    titular: Persona,
    saldo: Double,
    iban: String,
    private var tipoInteres: Double
) : CuentaBancaria(titular, saldo, iban) {

    override fun devolverInfo(): String {
        return """
        Cuenta Ahorro:
        -----------------
        Titular         : $titular
        Saldo           : $saldo
        IBAN            : $iban
        Tipo Interes : $tipoInteres
    """.trimIndent()
    }
}