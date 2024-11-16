package Model

open class CuentaCorriente(
    titular: Persona,
    saldo: Double,
    iban: String,
) : CuentaBancaria(titular, saldo, iban) {

    // PARA QUE LAS DEMAS CLASES PUEDAN ACCEDER A ESTE ATRIBUTO SE PONE PROTECTED
    protected var listaEntidades: Array<String>

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