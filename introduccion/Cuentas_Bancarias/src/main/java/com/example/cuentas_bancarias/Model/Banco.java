package com.example.cuentas_bancarias.Model;

import java.util.ArrayList;

public class Banco {
    private ArrayList<CuentaBancaria> cuentasLista; // ARRAY DE TIPO CUENTA BANCARIA PARA GUARDAR LAS CUENTAS

    public Banco() {
        this.cuentasLista = new ArrayList<>(); //inicializa la lista de cuentas
    } // CONSTRUCTOR SIN PARAMETROS PARA CREAR UN OBJETO DE TIPO BANCO DONDE SE CREE EL ARRAYLIST

    public boolean abrirCuenta(CuentaBancaria cuentaBancaria) {
        // SE USA DIRECTAMENTE EL RETURN FALSE Y TRUE PARA EVITAR UNA VARIABLE TIPO BOOLEAN ADICIONAL
        for (CuentaBancaria CB : this.cuentasLista) {
            if (CB.getNumCuenta().equals(cuentaBancaria.getNumCuenta())) {
                return false; // la cuenta ya existe
            } // SE COMPRUEBA SI LA CUENTA EXISTE
        } // RECORREMOS LAS LISTAS EXISTENTES PARA VERIFICAR SI LA CUENTA YA EXISTE

        // SI NO SE ENCONTRO NINGUNA CUENTA CON EL MISMO NUMERO, SE AÑADE A LA LISTA
        this.cuentasLista.add(cuentaBancaria); // SI NO EXISTE LA CUENTA, SE AÑADE
        return true; // cuenta abierta exitosamente
    } // DEVUELVE TRUE O FALSE SI ALMACENAR LA CUENTA HA SIDO EXITOSA O NO

    public String[] listadoCuentas() {
        // SE CREA UN ARRAY DE STRINGS DEL MISMO TAMÑO QUE LA LISTA DE CUENTAS
        String[] cuentasInfo = new String[this.cuentasLista.size()];

        // SE RECORRE LA LISTA MIENTRAS SE VA CONVIRTIENDO CADA CUENTA EN UNA CADENA
        for (int i = 0; i < this.cuentasLista.size(); i++) {
            CuentaBancaria cuenta = this.cuentasLista.get(i);
            cuentasInfo[i] = cuenta.devolverInfoString();
        }
        return cuentasInfo;  // SE DEVUELVE EL ARRAY DE STRING DE CUENTAS
    } // LISTADO DE CUENTAS QUE DEVUELVE UN ARRAY DE CADENAS DE LA INFORMACION DE LAS CUENTAS

    public String informacionCuenta(String IBAN) {
        for (CuentaBancaria cuentaBancaria : this.cuentasLista) {
            if (cuentaBancaria.getNumCuenta().equals(IBAN)) {
                return cuentaBancaria.devolverInfoString(); // RETORNA LA INFO Y SALE DEL METODO
            } // SI EXISTE UNA CUENTA CON ESE IBAN, DEVOLVERA LA INFO DE ESA CUENTA Y SALDRA
        } // RECORREMOS LA LISTA DE CUENTAS
        // SI NO ENCUENTRA NINGUNA CUENTA CON ESE IBAN RETORNARA DIRECTAMENTE NULL
        return null;
    } // INFORMACION CUENTAS QUE DEVUELVE INFORMACION DE LA CUENTA PASADA POR PARAMETRO


    public boolean ingresoCuenta(String IBAN, double cantIngreso) {
        /** no se valida que el ingreso sea menor que 0 ya que no se puede ingresar una cantidad negativa en el saldo
         * ni se puede retirar mas dinero del que se posee **/
        double cantTotal; // VARIABLE PARA GUARDAR LA CANTIDAD TOTAL DE LA CUENTA (actual + ingresoNuevo)
        for (CuentaBancaria cuentaBancaria : this.cuentasLista) {
            if (cuentaBancaria.getNumCuenta().equals(IBAN)) {
                cantTotal = cuentaBancaria.getSaldoActualCuenta() + cantIngreso; // SE SUMA LA CANTIDAD ACTUAL + EL AÑADIDO INGRESADO
                cuentaBancaria.setSaldoActualCuenta(cantTotal); // SE SETTEA EL VALOR DE LA CUENTA
                return true; // DEVUELVE TRUE (la operacion fue exitosa) Y SALE DEL METODO
            } // SI EXISTE LA CUENTA ENTONCES SE SETTEA EL VALOR DEL SALDO Y SE SALE DEL METODO
        } // FOR PARA RECORRE LA LISTA DE CUENTAS
        return false; // SI NO ENCONTRO NINGUNA CUENTA, DEVUELVE FALSE (la operacion NO fue exitosa)
    } // METODO PARA EL INGRESO DE UNA CANTIDAD EN LA CUENTA

    public boolean retiradaCuenta(String IBAN, double cantRetirar) {
        /** no se valida que el ingreso sea menor que 0 ya que no se puede ingresar una cantidad negativa en el saldo
         * ni se puede retirar mas dinero del que se posee **/
        double cantTotal; // VARIABLE PARA GUARDAR LA CANTIDAD TOTAL DE LA CUENTA (actual - cantRetirar)
        for (CuentaBancaria cuentaBancaria : this.cuentasLista) {
            if (cuentaBancaria.getNumCuenta().equals(IBAN)) {
                // SI LA CANTIDAD A RETIRAR ES MAYOR A LA CANTIDAD QUE TENGA EN LA CUENTA,
                // ENTONCES SE SALE DEL METODO
                if ((cuentaBancaria.getSaldoActualCuenta() - cantRetirar) < 0) {
                    return false; // SI EL SALDO ES INSUFICIENTE DEVUELVE FALSE
                } else if (!(cantRetirar < 0)) {
                    cantTotal = cuentaBancaria.getSaldoActualCuenta() - cantRetirar; // CALCULA EL NUEVO SALDO
                    cuentaBancaria.setSaldoActualCuenta(cantTotal); // ACTUALIZA EL NUEVO SALDO
                    return true; // RETORNA true YA QUE LA OPERACION FUE EXITOSA Y SALE DEL METODO
                } // SI LA CANTIDAD A RETIRAR NO ES NEGATIVA ENTONCES SE EJECUTARA CORRECTAMENTE
            } // SI EXISTE LA CUENTA ENTONCES SE SETTEA EL VALOR DEL SALDO Y SE SALE DEL BUCLE
        } // FOR PARA RECORRER LA LISTA DE CUENTAS
        return false; // SI NO SE HA ENCONTRADO EL IBAN, DEVOLVERA FALSE (la operacion NO fue exitosa)
    } // METODO PARA RETIRAR UNA CANTIDAD DE UNA CUENTA

    public double obtenerSaldo(String IBAN) {
        for (CuentaBancaria cuentaBancaria : this.cuentasLista) {
            if (cuentaBancaria.getNumCuenta().equals(IBAN)) {
                return cuentaBancaria.getSaldoActualCuenta(); // RETORNA EL SALDO ACTUAL
            } // SI EXISTE LA CUENTA ENTONCES SE SETTEA EL VALOR DEL SALDO Y SE SALE DEL METODO
        } // FOR PARA RECORRER LA LISTA DE CUENTAS
        return -1; // SI LA CUENTA NO EXISTE DEVOLVERA -1
    } // METODO PARA OBTENER EL SALDO DE UNA CUENTA
}
