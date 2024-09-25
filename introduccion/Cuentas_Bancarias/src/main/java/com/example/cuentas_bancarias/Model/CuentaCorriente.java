package com.example.cuentas_bancarias.Model;

import java.util.ArrayList;

public class CuentaCorriente extends CuentaBancaria{
    private ArrayList<String> entidadesAutorizadas;

    public CuentaCorriente(Persona titularCuenta, double saldoActualCuenta, String numCuenta, ArrayList<String> entidadesAutorizadas) {
        super(titularCuenta, saldoActualCuenta, numCuenta);
        this.entidadesAutorizadas = entidadesAutorizadas;
    }

    public ArrayList<String> getEntidadesAutorizadas() {
        return entidadesAutorizadas;
    }

    public void setEntidadesAutorizadas(ArrayList<String> entidadesAutorizadas) {
        this.entidadesAutorizadas = entidadesAutorizadas;
    }
}
