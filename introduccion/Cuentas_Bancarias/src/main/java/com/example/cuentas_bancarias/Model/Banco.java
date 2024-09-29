package com.example.cuentas_bancarias.Model;

import java.security.PublicKey;
import java.util.ArrayList;

public class Banco {
    private ArrayList<CuentaBancaria> cuentasLista; // ARRAY DE TIPO CUENTA BANCARIA PARA GUARDAR LAS CUENTAS

    public Banco() {
        this.cuentasLista = new ArrayList<>();
    } // CONSTRUCTOR SIN PARAMETROS PARA CREAR UN OBJETO DE TIPO BANCO DONDE SE CREE EL ARRAYLIST

    public boolean abrirCuenta(CuentaBancaria cuentaBancaria) {
        boolean operacionExitosa = true; // ATRIBUTO QUE INDICA SI LA OPERACION HA SIDO EXITOSA O NO

        if (this.cuentasLista.isEmpty()) {
            this.cuentasLista.add(cuentaBancaria); // SE AÑADE LA PRIMERA CUENTA
            return true; // LA OPERACION FUE EXITOSA
        } // SI LA LISTA ESTA VACIA, SE AÑADE DIRECTAMENTE

        for (CuentaBancaria CB : this.cuentasLista) {
            if (CB.getNumCuenta().equals(cuentaBancaria.getNumCuenta())) {
                operacionExitosa = false;
                break;
            } // SI EXISTE LA CUENTA, LA OPERACION NO HA SIDO EXITOSA
        }
        if (operacionExitosa) {
            this.cuentasLista.add(cuentaBancaria);
        } // SI NO EXISTE LA CUENTA, SE AÑADE

        return operacionExitosa;
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

    public String informacionCuenta(String IBAN){
        boolean existeCuenta = false; // VARIABLE PARA SABER SI EXISTE UNA CUENTA O NO
        String mensajeInfoCuenta = ""; // VARIABLE PARA GUARDAR EL MENSAJE DE LA INFORMACINO DE CUENTA
        for(CuentaBancaria cuentaBancaria: this.cuentasLista){
            if(cuentaBancaria.getNumCuenta().equals(IBAN)){
                existeCuenta = true;
                // SI EXISTE UNA CUENTA CON ESE IBAN DEVOLVERA LA INFO DE ESA CUENTA Y SALDRA DEL BUCLE
                mensajeInfoCuenta = cuentaBancaria.devolverInfoString();
                break;
            }
        }
        if(!existeCuenta){
            mensajeInfoCuenta = "null";
        } // SI NO EXISTE LA CUENTA, EL MENSAJE DEVOLVERA NULL
        return mensajeInfoCuenta; // RETORNARA EL MENSAJE DE LA INFORMACION
    } // INFORMACION CUENTAS QUE DEVUELVE INFORMACION DE LA CUENTA PASADA POR PARAMETRO


    public boolean ingresoCuenta(String IBAN, double cantIngreso){
        boolean existeCuenta = false; // VARIABLE PARA SABER SI EXISTE UNA CUENTA O NO
        double cantTotal; // VARIABLE PARA GUARDAR LA CANTIDAD TOTAL DE LA CUENTA (actual + ingresoNuevo)
        for(CuentaBancaria cuentaBancaria: this.cuentasLista){
            if(cuentaBancaria.getNumCuenta().equals(IBAN)){
                existeCuenta = true;
                cantTotal = cuentaBancaria.getSaldoActualCuenta() + cantIngreso;
                cuentaBancaria.setSaldoActualCuenta(cantTotal);
                break;
            } // SI EXISTE LA CUENTA ENTONCES SE SETTEA EL VALOR DEL SALDO Y SE SALE DEL BUCLE
        } // FOR PARA RECORRE LA CUENTA
        return  existeCuenta;
    } // METODO PARA EL INGRESO DE UNA CANTIDAD EN LA CUENTA

    /*
    o ingresoCuenta: recibe un iban por parámetro y una cantidad e ingresa la
    cantidad en la cuenta. Devuelve true o false indicando si la operación se realizó
    con éxito.
    o retiradaCuenta: recibe un iban por parámetro y una cantidad y trata de retirar
    la cantidad de la cuenta. Devuelve true o false indicando si la operación se
    realizó con éxito.
    o obtenerSaldo: Recibe un iban por parámetro y devuelve el saldo de la cuenta si
    existe. En caso contrario devuelve -1.
    *
    * */
}
