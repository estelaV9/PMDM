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
        if(numIbanTF.getText().isEmpty() || cantRetirarTF.getText().isEmpty()){
            StaticCode.Alerts("ERROR", "Campos vacíos.", "¡ERROR!", "Por favor, rellene todos los datos antes de continuar.");
        } else if (!Validator.contieneNumeros(cantRetirarTF.getText())){
            // COMPROBAR QUE EL CAMPO CANTRETIRAR NO CONTENGAN CADENAS
            StaticCode.Alerts("ERROR", "Campos erroneos.", "¡ERROR!",
                    "El campo de cantidad para retirar no debe contener letras.");
        } else if (!Validator.isValidIban(numIbanTF.getText())) {
            // COMPROBAR QUE EL NUMERO DE IBAN ESTE BIEN
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
        } // SI EL CAMPO DE IBAN ESTA VACIO O LA CANTIDAD A INGRESAR LANZA UNA ALERTA
    }

    @FXML
    void onExitAction(MouseEvent event) {
        StaticCode.exitApp();
    } // SALIR DE LA APLICACIÓN

    @FXML
    void onVolverAction(MouseEvent event) {
        StaticCode.cambiarVistaImg("Start.fxml", volverBtt, "Start Application");
    } // IR A LA PAGINA PRINCIPAL DE LA APLICACION

}
