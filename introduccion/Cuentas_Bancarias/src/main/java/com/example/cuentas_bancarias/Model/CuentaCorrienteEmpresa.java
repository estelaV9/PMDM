package com.example.cuentas_bancarias.Model;

import java.util.ArrayList;

public class CuentaCorrienteEmpresa extends CuentaCorriente {
    private double tipoInteresDescubierto; // SE GUARDA EL TIPO DE INTERES POR DESCUBIERTO
    private double maxDescubiertoPermitido; // SE GUARDA EL MAXIMO DESCUBIERTO PERMITIDO
    private double comisionFijaDescubierto; // SE GUARDA LA COMISION FIJA POR DESCUBIERTO

    public CuentaCorrienteEmpresa(Persona titularCuenta, double saldoActualCuenta, String numCuenta, ArrayList<String> entidadesAutorizadas, double tipoInteresDescubierto, double maxDescubiertoPermitido, double comisionFijaDescubierto) {
        super(titularCuenta, saldoActualCuenta, numCuenta, entidadesAutorizadas);
        this.tipoInteresDescubierto = tipoInteresDescubierto;
        this.maxDescubiertoPermitido = maxDescubiertoPermitido;
        this.comisionFijaDescubierto = comisionFijaDescubierto;
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
    public double getComisionFijaDescubierto() {
        return comisionFijaDescubierto;
    }
    public void setComisionFijaDescubierto(double comisionFijaDescubierto) {
        this.comisionFijaDescubierto = comisionFijaDescubierto;
    }

    @Override
    public String devolverInfoString() {
        // SE IMPLEMENTA EL METODO DE LA CLASE ABSTRACTA Y SE AÑADE INFORMACION
        return "Titular: " + getTitularCuenta().devolverInfoString() +  // INFO TITULAR
                "\nSaldo actual: " + getSaldoActualCuenta() +  // SACDO ACTUAL
                "\nNúmero de cuenta: " + getNumCuenta() +  // NUMERO DE CUENTA
                "\nTipo de cuenta: Corriente de Empresa" +  // TIPO DE CUENTA
                "\nMáximo descubierto permitido: " + this.maxDescubiertoPermitido +
                "\nTipo de interés por descubierto " + this.tipoInteresDescubierto +
                "\nComisión fija por cada descubierto: " + this.comisionFijaDescubierto;
    }
}
