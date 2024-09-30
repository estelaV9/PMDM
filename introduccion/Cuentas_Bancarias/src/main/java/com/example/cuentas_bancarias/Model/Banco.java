package com.example.cuentas_bancarias.Model;

import java.security.PublicKey;
import java.util.ArrayList;

public class Banco {
    private ArrayList<CuentaBancaria> cuentasLista; // ARRAY DE TIPO CUENTA BANCARIA PARA GUARDAR LAS CUENTAS

    public Banco() {
        this.cuentasLista = new ArrayList<>();
    } // CONSTRUCTOR SIN PARAMETROS PARA CREAR UN OBJETO DE TIPO BANCO DONDE SE CREE EL ARRAYLIST

    public boolean abrirCuenta(CuentaBancaria cuentaBancaria) {
        // SE USA DIRECTAMENTE EL RETURN FALSE Y TRUE PARA EVITAR UNA VARIABLE TIPO BOOLEAN ADICIONAL
        for (CuentaBancaria CB : this.cuentasLista) {
            if (CB.getNumCuenta().equals(cuentaBancaria.getNumCuenta())) {
                return false; // DEVUELVE FALSE Y SALE DEL METODO
            } // SE COMPRUEBA SI LA CUENTA EXISTE
        } // RECORREMOS LAS LISTAS EXISTENTES

        // SI NO SE ENCONTRO NINGUNA CUENTA CON EL MISMO NUMERO, SE AÑADE A LA LISTA
        this.cuentasLista.add(cuentaBancaria); // SI NO EXISTE LA CUENTA, SE AÑADE
        return true; // LA OPERACION FUE EXITOSA
    } // DEVUELVE TRUE O FALSE SI ALMACENAR LA CUENTA HA SIDO EXITOSA O NO

    public String[] listadoCuentas() {
        // SE CREA UN ARRAY DE STRINGS DEL MISMO TAMÑO QUE LA LISTA DE CUENTAS
        String[] cuentasInfo = new String[this.cuentasLista.size()];

        // SE RECORRE LA LISTA MIENTRAS SE VA CONVIRTIENDO CADA CUENTA EN UNA CADENA
        for (int i = 0; i < this.cuentasLista.size(); i++) {
            CuentaBancaria cuenta = this.cuentasLista.get(i);
            cuentasInfo[i] = cuenta.devolverInfoString();
        }
        return cuentasInfo;  // SE DEVUELVE EL ARRAY DE STRING
    } // LISTADO DE CUENTAS QUE DEVUELVE UN ARRAY DE CADENAS DE LA INFORMACION DE LAS CUENTAS

    public String informacionCuenta(String IBAN) {
        boolean existeCuenta = false; // VARIABLE PARA SABER SI EXISTE UNA CUENTA O NO
        String mensajeInfoCuenta = ""; // VARIABLE PARA GUARDAR EL MENSAJE DE LA INFORMACINO DE CUENTA
        for (CuentaBancaria cuentaBancaria : this.cuentasLista) {
            if (cuentaBancaria.getNumCuenta().equals(IBAN)) {
                existeCuenta = true;
                // SI EXISTE UNA CUENTA CON ESE IBAN DEVOLVERA LA INFO DE ESA CUENTA Y SALDRA DEL BUCLE
                mensajeInfoCuenta = cuentaBancaria.devolverInfoString();
                break;
            }
        }
        if (!existeCuenta) {
            mensajeInfoCuenta = "null";
        } // SI NO EXISTE LA CUENTA, EL MENSAJE DEVOLVERA NULL
        return mensajeInfoCuenta; // RETORNARA EL MENSAJE DE LA INFORMACION
    } // INFORMACION CUENTAS QUE DEVUELVE INFORMACION DE LA CUENTA PASADA POR PARAMETRO


    public boolean ingresoCuenta(String IBAN, double cantIngreso) {
        boolean existeCuenta = false; // VARIABLE PARA SABER SI EXISTE UNA CUENTA O NO
        double cantTotal; // VARIABLE PARA GUARDAR LA CANTIDAD TOTAL DE LA CUENTA (actual + ingresoNuevo)
        for (CuentaBancaria cuentaBancaria : this.cuentasLista) {
            if (cuentaBancaria.getNumCuenta().equals(IBAN)) {
                existeCuenta = true;
                cantTotal = cuentaBancaria.getSaldoActualCuenta() + cantIngreso;
                cuentaBancaria.setSaldoActualCuenta(cantTotal);
                break;
            } // SI EXISTE LA CUENTA ENTONCES SE SETTEA EL VALOR DEL SALDO Y SE SALE DEL BUCLE
        } // FOR PARA RECORRE LA CUENTA
        return existeCuenta;
    } // METODO PARA EL INGRESO DE UNA CANTIDAD EN LA CUENTA

    public boolean retiradaCuenta(String IBAN, double cantRetirar) {
        boolean existeCuenta = false; // VARIABLE PARA SABER SI EXISTE UNA CUENTA O NO
        double cantTotal; // VARIABLE PARA GUARDAR LA CANTIDAD TOTAL DE LA CUENTA (actual - cantRetirar)
        for (CuentaBancaria cuentaBancaria : this.cuentasLista) {
            if (cuentaBancaria.getNumCuenta().equals(IBAN)) {
                if ((cuentaBancaria.getSaldoActualCuenta() - cantRetirar) < 0) {
                    // SI LA CANTIDAD A RETIRAR ES MAYOR A LA CANTIDAD QUE TENGA EN LA CUENTA, ENTONCES SE SALE DEL BUCLE (en modo false)
                    break;
                } else if (!(cantRetirar < 0)) {
                    existeCuenta = true;
                    cantTotal = cuentaBancaria.getSaldoActualCuenta() - cantRetirar;
                    cuentaBancaria.setSaldoActualCuenta(cantTotal);
                } // SI LA CANTIDAD A RETIRAR NO ES NEGATIVA ENTONCES SE EJECUTARA CORRECTAMENTE
                break;
            } // SI EXISTE LA CUENTA ENTONCES SE SETTEA EL VALOR DEL SALDO Y SE SALE DEL BUCLE
        } // FOR PARA RECORRE LA CUENTA
        return existeCuenta;
    } // METODO PARA RETIRAR UNA CANTIDAD DE UNA CUENTA

    public double obtenerSaldo(String IBAN) {
        double existeCuenta = -1; // VARIABLE PARA SABER SI EXISTE UNA CUENTA O NO. SI NO EXISTE DEVUELVE -1
        for (CuentaBancaria cuentaBancaria : this.cuentasLista) {
            if (cuentaBancaria.getNumCuenta().equals(IBAN)) {
                existeCuenta = 0;
                return cuentaBancaria.getSaldoActualCuenta();
            } // SI EXISTE LA CUENTA ENTONCES SE SETTEA EL VALOR DEL SALDO Y SE SALE DEL BUCLE
        } // FOR PARA RECORRE LA CUENTA
        return existeCuenta;
    } // METODO PARA OBTENER EL SALDO DE UNA CUENTA
}
