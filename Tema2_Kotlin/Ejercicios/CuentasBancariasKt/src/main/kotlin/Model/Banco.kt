package Model

class Banco {
    private var _listaCuentas: MutableList<CuentaBancaria> = mutableListOf()

    val listaCuentas: MutableList<CuentaBancaria>
        get() = _listaCuentas


    // METODOS
    fun abrirCuenta(cuenta: CuentaBancaria): Boolean {
        for (cuentas in _listaCuentas) {
            if (cuentas.iban == cuenta.iban) {
                return false
            } // SI YA EXISTE ESA CUENTA, DEVEULVE FALSE
        }
        _listaCuentas.add(cuenta)
        return true
    } // FUNCION PARA ABRIR UNA CUENTA

    fun listadoCuentas():List<CuentaBancaria>{
        return _listaCuentas.toList()
    }
}