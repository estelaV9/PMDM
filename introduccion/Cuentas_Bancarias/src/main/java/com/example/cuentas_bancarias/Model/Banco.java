package com.example.cuentas_bancarias.Model;

import java.util.ArrayList;

public class Banco {
    public static ArrayList<CuentaBancaria> cuentasLista = new ArrayList<>();

    public Banco(ArrayList<CuentaBancaria> cuentasLista) {
        this.cuentasLista = cuentasLista;
    }

    public static boolean abrirCuenta(CuentaBancaria cuentaBancaria) {
        boolean operacionExitosa = true; // ATRIBUTO QUE INDICA SI LA OPERACION HA SIDO EXITOSA O NO

        if (cuentasLista.isEmpty()) {
            cuentasLista.add(cuentaBancaria); // SE AÑADE LA PRIMERA CUENTA
            return true; // LA OPERACION FUE EXITOSA
        } // SI LA LISTA ESTA VACIA, SE AÑADE DIRECTAMENTE

        for (CuentaBancaria CB : cuentasLista) {
            if (CB.getNumCuenta().equals(cuentaBancaria.getNumCuenta())) {
                operacionExitosa = false;
                break;
            } // SI EXISTE LA CUENTA, LA OPERACION NO HA SIDO EXITOSA
        }
        if (operacionExitosa) {
            cuentasLista.add(cuentaBancaria);
        } // SI NO EXISTE LA CUENTA, SE AÑADE

        return operacionExitosa;
    } // DEVUELVE TRUE O FALSE SI ALMACENAR LA CUENTA HA SIDO EXITOSA O NO

    public static String[] listadoCuentas() {
        // SE CREA UN ARRAY DE STRINGS DEL MISMO TAMÑO QUE LA LISTA DE CUENTAS
        String[] cuentasInfo = new String[cuentasLista.size()];

        // SE RECORRE LA LISTA Y SE VA CONVIRTIENDO CADA CUENTA EN UNA CADENA
        for (int i = 0; i < cuentasLista.size(); i++) {
            CuentaBancaria cuenta = cuentasLista.get(i);
            cuentasInfo[i] = cuenta.devolverInfoString();
        }

        return cuentasInfo;  // SE DEVUELVE EL ARRAY DE STRING
    }



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
