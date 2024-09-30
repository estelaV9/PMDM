package com.example.cuentas_bancarias.Model;

import com.example.cuentas_bancarias.Interface.Imprimible;

public abstract class CuentaBancaria implements Imprimible {
    /** Nota: Se utiliza 'protected' para permitir que las subclases accedan directamente a este atributo,
     * facilitando así la herencia y el manejo de información. **/
    protected Persona titularCuenta; // OBJETO DE TIPO PERSONA PARA GUARDAR LA INFORMACION DEL TITULAR DE LA CUENTA
    protected double saldoActualCuenta; // SE GUARDA EL SALDO ACTUAL DE LA CUENTA
    protected String numCuenta; // SE GUARDA EL NUMERO DE IBAN DE LA CUENTA

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
    public String getNumCuenta() {return numCuenta;}
    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }


    @Override
    public abstract String devolverInfoString(); // METODO ABSTRACTO PARA SER IMPLEMENTADO EN LAS DEMAS CLASES Y
                                                 // DEVOLVER INFORMACION SOBRE LA CUENTA
}
