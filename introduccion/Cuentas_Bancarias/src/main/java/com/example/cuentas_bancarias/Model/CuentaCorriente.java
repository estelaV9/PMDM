package com.example.cuentas_bancarias.Model;

import com.example.cuentas_bancarias.Interface.Imprimible;

import java.util.ArrayList;

public abstract class CuentaCorriente extends CuentaBancaria implements Imprimible {
    /** Nota: Se utiliza 'protected' para permitir que las subclases accedan directamente a este atributo,
     * facilitando así la herencia y el manejo de información. **/
    protected ArrayList<String> entidadesAutorizadas; // SE GUARDA UN ARRRAYLIST CON LAS ENTIDADES AUTORIZADAS

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
