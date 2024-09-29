package com.example.cuentas_bancarias.Model;

import java.util.ArrayList;

public class CuentaCorrientePersonal extends CuentaCorriente{
    private double comisionMantenimiento;

    public CuentaCorrientePersonal(Persona titularCuenta, double saldoActualCuenta, String numCuenta, ArrayList<String> entidadesAutorizadas, double comisionMantenimiento) {
        super(titularCuenta, saldoActualCuenta, numCuenta, entidadesAutorizadas);
        this.comisionMantenimiento = comisionMantenimiento;
    }

    public double getComisionMantenimiento() {
        return comisionMantenimiento;
    }
    public void setComisionMantenimiento(double comisionMantenimiento) {
        this.comisionMantenimiento = comisionMantenimiento;
    }

    @Override
    public String devolverInfoString() {
        // SE IMPLEMENTA EL METODO DE LA CLASE ABSTRACTA Y SE AÑADE INFORMACION
        return "Titular: " + getTitularCuenta().devolverInfoString() +  // INFO TITULAR
                "\nSaldo actual: " + getSaldoActualCuenta() +  // SACDO ACTUAL
                "\nNúmero de cuenta: " + getNumCuenta() +  // NUMERO DE CUENTA
                "\nTipo de cuenta: Corriente de Empresa" +  // TIPO DE CUENTA
                "\nComisión de mantenimiento: " + this.comisionMantenimiento; // COMISION DE MANTENIMIENTO
    }
}
