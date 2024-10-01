package com.example.cuentas_bancarias.Validator;

public class Validator {
    public static boolean noContieneNumeros(String texto) {
        /** Este método verifica si la cadena de texto proporcionada NO contiene números.
         * Utiliza el método matches() para comprobar si la cadena contiene al menos un digito(número)
         * con una expresión regular para comprobar.
         * En este caso, la expresión regular usada es ".*\\d.*", que significa:
         *  - .*: Cero o más de cualquier carácter (excepto saltos de línea).
         *  - \\d: Representa cualquier dígito (del 0 al 9).
         *  - .*: Cero o más de cualquier carácter nuevamente.
         * Si la cadena contiene números, devolverá true. */
        return texto.matches(".*\\d.*");
    } // VALIDACION PARA QUE LOS CAMPOS NO CONTENGAN NUMEROS

    public static boolean contieneNumeros(String texto) {
        /** Este método verifica si la cadena de texto proporcionada contiene solamente números.
         * Se utiliza el método matches() para comprobar si la cadena coincide con la expresión regular.
         * En este caso, la expresión regular utilizada es "\\d+", que significa:
         *  - '\\d': representa cualquier dígito (del 0 al 9).
         *  - '+': indica que debe haber al menos uno o más dígitos consecutivos.
         * Si la cadena contiene solo números, el método `matches()` devolverá true.
         * Si la cadena contiene cualquier otro carácter que no sea un número, devolverá false. */
        return texto.matches("\\d+");
    } // VALIDACION PARA QUE LOS CAMPOS NO CONTENGAN CADENAS

    public static boolean validarDNI(String dni) {
        if (dni.length() != 9) {
            // SI EL DNI NO TIENE 9 DIGITOS, DEVUELVE FALSE
            return false;
        } else if (!dni.substring(0, 8).matches("\\d+")) {
            // SUBSTRAE LOS PRIMEROS 8 DIGITOS Y VERIFICA QUE ESA CADENA SUBSTRAIDA SOLO CONTENGA NUMEROS
            // SI ESTO NO SE CUMPLE, DEVOLVERA FALSE
            return false;
        } else if (!dni.substring(8).matches("[A-Za-z]")) {
            // SUBSTRAE EL ULTIMO DIGITO Y VERIFICA QUE TENGA CUALQUIER LETRA (A-Z o a-z)
            // SI ESTO NO SE CUMPLE, DEVOLVERA FALSE
            return false;
        } else {
            return true;
        }
    } // METODO PARA VALIDAR QUE EL DNI ESTE BIEN

    public static boolean isValidIban(String iban) {
        // ES + 22N (digitos del 0 al 9)
        if (iban.length() != 24) {
            // SI EL IBAN NO TIENE 24 DIGITOS, DEVUELVE FALSE
            return false;
        } else if (!iban.substring(0, 2).matches("ES")) {
            // SI LOS DOS PRIMEROS DIGITOS NO SON 'ES', DEVOLVERA FALSE
            return false;
        } else if (!iban.substring(2, 24).matches("\\d+")) {
            // SI LOS 20 SIGUIENTES DIGITOS NO SON NUMERICOS, DEVOLVERA FALSE
            return false;
        } else {
            return true;
        }
    } // VALIDAR EL NUMERO DE IBAN DE UNA CUENTA

}
