package com.example.cuentas_bancarias.Model;

import com.example.cuentas_bancarias.Interface.Imprimible;

public class CuentaBancaria implements Imprimible {
    private Persona titularCuenta;
    private double saldoActualCuenta;
    private String numCuenta;

    public CuentaBancaria(Persona titularCuenta, double saldoActualCuenta, String numCuenta) {
        this.titularCuenta = titularCuenta;
        this.saldoActualCuenta = saldoActualCuenta;
        this.numCuenta = numCuenta;
    }

    public Persona getTitularCuenta() {
        return titularCuenta;
    }

    public void setTitularCuenta(Persona titularCuenta) {
        this.titularCuenta = titularCuenta;
    }

    public double getSaldoActualCuenta() {
        return saldoActualCuenta;
    }

    public void setSaldoActualCuenta(double saldoActualCuenta) {
        this.saldoActualCuenta = saldoActualCuenta;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }
}
