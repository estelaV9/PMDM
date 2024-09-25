package com.example.cuentas_bancarias.Model;

import java.util.ArrayList;

public class Banco {
    private static ArrayList<CuentaBancaria> cuentasLista;

    public Banco(ArrayList<CuentaBancaria> cuentasLista) {
        this.cuentasLista = cuentasLista;
    }

    public static boolean abrirCuenta (CuentaBancaria cuentaBancaria){
        boolean operacionExitosa = true; // ATRIBUTO QUE INDICA SI LA OPERACION HA SIDO EXITOSA O NO
        for(CuentaBancaria CB: cuentasLista){
            if(CB.equals(cuentaBancaria)){
                operacionExitosa = false;
                break;
            } // SI EXISTE LA CUENTA, LA OPERACION NO HA SIDO EXITOSA
        }
        if(!operacionExitosa){
            cuentasLista.add(cuentaBancaria);
        } // SI NO EXISTE LA CUENTA, SE AÑADE
        return operacionExitosa;
    } // DEVUELVE TRUE O FALSE SI ALMACENAR LA CUENTA HA SIDO EXITOSA O NO


    /*
    o listadoCuentas: no recibe parámetro y devuelve un array donde cada elemento
    es una cadena que representa la información de una cuenta.
    o informacionCuenta: recibe un iban por parámetro y devuelve una cadena con
    la información de la cuenta o null si la cuenta no existe.
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
