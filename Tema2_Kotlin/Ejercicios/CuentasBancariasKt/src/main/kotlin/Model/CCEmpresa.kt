package Model

class CCEmpresa(
    titular: Persona,
    saldo: Double,
    iban: String,
    private var maxDescubierto: Int,
    private var tipoInteresDescubierto: Int
) : CuentaCorriente(titular, saldo, iban) {

    init {
        this.titular = titular
        this.saldo = saldo
        this.iban = iban
    }

    override fun devolverInfo(): String {
        return """
        Cuenta Corriente de Empresa:
        -----------------
        Titular         : $titular
        Saldo           : $saldo
        IBAN            : $iban
        Lista Entidades : ${listaEntidades.joinToString { ", " }}
        Maximo Descubierto : $maxDescubierto
        Tipo Interes Descubierto : $tipoInteresDescubierto
    """.trimIndent()
    }
}