package Model

class CuentaCorriente(
    titular: Persona,
    saldo: Double,
    iban: String,
    private var listaEntidades: Array<String>
) : CuentaBancaria(titular, saldo, iban) {

    init {
        this.titular = titular
        this.saldo = saldo
        this.iban = iban
        this.listaEntidades = arrayOf("Cafeteria", "Panaderia", "Entidad3", "Entidad4")
    }

    override fun toString(): String {
        return """
        Cuenta Corriente:
        -----------------
        Titular         : $titular
        Saldo           : $saldo
        IBAN            : $iban
        Lista Entidades : ${listaEntidades.joinToString(", ")}
    """.trimIndent()
    }
}