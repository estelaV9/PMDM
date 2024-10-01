package com.example.cuentas_bancarias.Controller;

import com.example.cuentas_bancarias.Utilities.StaticCode;
import com.example.cuentas_bancarias.Validator.Validator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class WithdrawMoneyCtrller {
    @FXML
    private Button retirarBtt;
    @FXML
    private TextField cantRetirarTF;
    @FXML
    private TextField numIbanTF;
    @FXML
    private Text textConfirmTxt;
    @FXML
    private ImageView volverBtt;

    @FXML
    void onRetirarAction(ActionEvent event) {
        /** Se va a validar que:
         * - Los campos a rellenar no esten vacios.
         * - En el campo de retirar cantidad no contenga letras (tambien se controla que no tenga negativos ya que el signo '-' cuenta como letra
         * - El numero de IBAN tenga un formato de ESNNNNNNNNNNNNNNNNNNNNNN donde N sean 22 numeros del 0 al 9
         * - Si el metodo de retirar dinero falla o se ejecuta correctamente se mostrara un mensaje en un color **/
        if(numIbanTF.getText().isEmpty() || cantRetirarTF.getText().isEmpty()){
            // SI EL CAMPO DE IBAN ESTA VACIO O LA CANTIDAD A INGRESAR LANZA UNA ALERTA
            StaticCode.Alerts("ERROR", "Campos vacíos.", "¡ERROR!", "Por favor, rellene todos los datos antes de continuar.");
        } else if (!Validator.contieneNumeros(cantRetirarTF.getText())){
            // SE LLAMA AL METODO PARA VALIDAR LA CANTIDAD A RETIRAR, SI NO ES CORRECTO LANZA UNA ALERTA
            /** como se valida que no contenga letras, directamente no deja poner el signo - para poner un saldo negativo **/
            StaticCode.Alerts("ERROR", "Campos erroneos.", "¡ERROR!",
                    "El campo de cantidad para retirar no debe contener letras.");
        } else if (!Validator.isValidIban(numIbanTF.getText())) {
            // SE LLAMA AL METODO PARA VALIDAR EL IBAN, SI NO ES CORRECTO LANZA UNA ALERTA
            StaticCode.Alerts("ERROR", "IBAN no válido.", "¡ERROR!",
                    "El IBAN proporcionado NO es válido.");
        } else {
            if(StaticCode.banco.retiradaCuenta(numIbanTF.getText(), Double.parseDouble(cantRetirarTF.getText()))){
                textConfirmTxt.setFill(Color.GREEN); // SE SETTEA DIRECTAMENTE EL COLOR EN VEZ DE USAR EL STYLE YA QUE NO FUNCIONA
                textConfirmTxt.setText("Retirada de cantidad realizado correctamente");
            } else {
                textConfirmTxt.setFill(Color.RED);// SE SETTEA DIRECTAMENTE EL COLOR EN VEZ DE USAR EL STYLE YA QUE NO FUNCIONA
                textConfirmTxt.setText("Retirada de cantidad NO realizado correctamente");
            } // DEPENDIENDO DE LO QUE DEVUELVA EL METODO, SI TRUE O FALSE, SE MOSTRARA UN MENSAJE DE ERROR O DE CONFIRMACION
        }
    } // METODO PARA RETIRAR UNA CANTIDAD DE UNA CUENTA

    @FXML
    void onExitAction(MouseEvent event) {
        // SE LLAMA AL METODO ESTATICO PARA SALIR DE LA APLICACION
        StaticCode.exitApp();
    } // SALIR DE LA APLICACIÓN

    @FXML
    void onVolverAction(MouseEvent event) {
        // SE LLAMA AL METODO ESTATICO CAMBIAR VISTA POR IMAGEN PARA VOLVER A LA PAGINA PRINCIPAL
        // SE INSERTA LOS PARAMETROS: NOMBRE DEL FXML AL QUE SE QUIERE IR, UN IMAGENVIEW Y
        // EL TITULO QUE VA A TENER ESE STAGE
        StaticCode.cambiarVistaImg("Start.fxml", volverBtt, "Start Application");
    } // IR A LA PAGINA PRINCIPAL DE LA APLICACION
}
