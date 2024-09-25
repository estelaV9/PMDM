package com.example.cuentas_bancarias.Model;

public class CuentaAhorro extends CuentaBancaria {
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
}
