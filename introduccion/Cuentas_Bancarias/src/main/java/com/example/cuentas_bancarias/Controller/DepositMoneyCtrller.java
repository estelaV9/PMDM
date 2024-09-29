package com.example.cuentas_bancarias.Controller;

import com.example.cuentas_bancarias.Utilities.StaticCode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class DepositMoneyCtrller {
    @FXML
    private Button buscarBtt;
    @FXML
    private TextField cantIngresoTF;
    @FXML
    private TextField numIbanTF;
    @FXML
    private Text textConfirmTxt;
    @FXML
    private ImageView volverBtt;

    @FXML
    void onBuscarCuentaAction(ActionEvent event) {
        if(numIbanTF.getText().isEmpty() || cantIngresoTF.getText().isEmpty()){
            StaticCode.Alerts("ERROR", "Campos vacíos.", "¡ERROR!", "Por favor, rellene todos los datos antes de continuar.");
        } else {
            if(StaticCode.banco.ingresoCuenta(numIbanTF.getText(), Double.parseDouble(cantIngresoTF.getText()))){
                textConfirmTxt.setFill(Color.GREEN); // SE SETTEA DIRECTAMENTE EL COLOR EN VEZ DE USAR EL STYLE YA QUE NO FUNCIONA
                textConfirmTxt.setText("Ingreso de cantidad realizado correctamente");
            } else {
                textConfirmTxt.setFill(Color.RED);// SE SETTEA DIRECTAMENTE EL COLOR EN VEZ DE USAR EL STYLE YA QUE NO FUNCIONA
                textConfirmTxt.setText("Ingreso de cantidad NO realizado correctamente");
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
