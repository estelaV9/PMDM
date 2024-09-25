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
}
