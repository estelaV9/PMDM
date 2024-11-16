package Model

class Banco {
    private var listaCuentas:MutableList<CuentaBancaria> = mutableListOf()

    // METODOS
    fun abrirCuenta(cuenta:CuentaBancaria): Boolean{
        for (cuentas in listaCuentas){
            if(cuentas.iban == cuenta.iban){
                return false
            } // SI YA EXISTE ESA CUENTA, DEVEULVE FALSE
        }
        listaCuentas.add(cuenta)
        return true
    } // FUNCION PARA ABRIR UNA CUENTA
}