package Model

class CCEmpresa(
    titular: Persona,
    saldo: Double,
    iban: String,
    private var maxDescubierto: Int,
    private var tipoInteresDescubierto: Double,
    private var comisionPorDescubierto: Double
) : CuentaCorriente(titular, saldo, iban) {

    override fun devolverInfo(): String {
        return """
        Cuenta Corriente de Empresa:
        -----------------
        Titular         : ${titular.devolverInfo()}
        Saldo           : $saldo
        IBAN            : $iban
        Lista Entidades : ${listaEntidades.joinToString()}
        Maximo Descubierto : $maxDescubierto€
        Tipo Interes Descubierto : $tipoInteresDescubierto
        Comision Por Descubierto : $comisionPorDescubierto€
    """.trimIndent()
    }
}