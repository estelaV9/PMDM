package com.example.cuentas_bancarias.Model;

import com.example.cuentas_bancarias.Interface.Imprimible;

public class CuentaAhorro extends CuentaBancaria implements Imprimible {
    private double tipoInteres;

    public CuentaAhorro(Persona titularCuenta, double saldoActualCuenta, String numCuenta, double tipoInteres) {
        super(titularCuenta, saldoActualCuenta, numCuenta);
        this.tipoInteres = tipoInteres;
    }

    public double getTipoInteres() {
        return tipoInteres;
    }
    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    @Override
    public String devolverInfoString() {
        // SE IMPLEMENTA EL METODO DE LA CLASE ABSTRACTA Y SE AÑADE INFORMACION
        return "Titular: " + getTitularCuenta().devolverInfoString() +  // INFO TITULAR
                "\nSaldo actual: " + getSaldoActualCuenta() +  // SACDO ACTUAL
                "\nNúmero de cuenta: " + getNumCuenta() +  // NUMERO DE CUENTA
                "\nTipo de cuenta: Ahorro" +  // TIPO DE CUENTA
                "\nInterés de remuneración: " + getTipoInteres();  // INTERES
    }
}
