package Model

class CCPersonal(
    titular: Persona,
    saldo: Double,
    iban: String,
    private var comisionMantenimiento: Int
) : CuentaCorriente(titular, saldo, iban) {

    init {
        this.titular = titular
        this.saldo = saldo
        this.iban = iban
    }

    override fun devolverInfo(): String {
        return """
        Cuenta Corriente Personal:
        -----------------
        Titular         : $titular
        Saldo           : $saldo
        IBAN            : $iban
        Lista Entidades : ${listaEntidades.joinToString {", " }}
        Comision de Mantenimiento : $comisionMantenimiento
    """.trimIndent()
    }

}