package com.example.cuentas_bancarias.Model;

import com.example.cuentas_bancarias.Interface.Imprimible;

import java.util.ArrayList;

public abstract class CuentaCorriente extends CuentaBancaria implements Imprimible {
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

    @Override
    public abstract String devolverInfoString(); // METODO ABSTRACTO PARA SER IMPLEMENTADO EN LAS DEMAS CLASES
                                                 // Y DEVOLVER INFORMACION SOBRE LA CUENTA

}
