package com.example.cuentas_bancarias.Model;

import java.util.ArrayList;

public class CuentaCorrienteEmpresa extends CuentaCorriente{
    private double tipoInteresDescubierto;
    private double maxDescubiertoPermitido;

    public CuentaCorrienteEmpresa(Persona titularCuenta, double saldoActualCuenta, String numCuenta, ArrayList<String> entidadesAutorizadas, double tipoInteresDescubierto, double maxDescubiertoPermitido) {
        super(titularCuenta, saldoActualCuenta, numCuenta, entidadesAutorizadas);
        this.tipoInteresDescubierto = tipoInteresDescubierto;
        this.maxDescubiertoPermitido = maxDescubiertoPermitido;
    }

    public double getTipoInteresDescubierto() {
        return tipoInteresDescubierto;
    }

    public void setTipoInteresDescubierto(double tipoInteresDescubierto) {
        this.tipoInteresDescubierto = tipoInteresDescubierto;
    }

    public double getMaxDescubiertoPermitido() {
        return maxDescubiertoPermitido;
    }

    public void setMaxDescubiertoPermitido(double maxDescubiertoPermitido) {
        this.maxDescubiertoPermitido = maxDescubiertoPermitido;
    }
}
