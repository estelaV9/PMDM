package com.example.cuentas_bancarias.Controller;

import com.example.cuentas_bancarias.Utilities.StaticCode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountInfoCtrller implements Initializable {
    @FXML
    private Button buscarBtt;
    @FXML
    private TextArea contentPaneTxt;
    @FXML
    private TextField numIbanTF;
    @FXML
    private ImageView volverBtt;

    @FXML
    void onBuscarCuentaAction(ActionEvent event) {
        if(numIbanTF.getText().isEmpty()){
            StaticCode.Alerts("ERROR", "Campos vacíos.", "¡ERROR!", "Por favor, rellene todos los datos antes de continuar.");
        } else {
            // SETTEAR LA INFORMACION EN EL TEXT AREA DE LA INFORMACION DE LA CUENTA PROPORCIONADA
            contentPaneTxt.setText(StaticCode.banco.informacionCuenta(numIbanTF.getText()));
        } // SI EL CAMPO DE IBAN ESTA VACIO LANZA UNA ALERTA
    }

    @FXML
    void onExitAction(MouseEvent event) {
        StaticCode.exitApp();
    } // SALIR DE LA APLICACIÓN

    @FXML
    void onVolverAction(MouseEvent event) {
        StaticCode.cambiarVistaImg("Start.fxml", volverBtt, "Start Application");
    } // IR A LA PAGINA PRINCIPAL DE LA APLICACION

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        contentPaneTxt.setStyle("-fx-control-inner-background: #56269c; -fx-text-fill: #FFFFFF; -fx-font-size: 17;");
    } // AL INICIAR ESTA VISTA SE PONE EL FONDO DEL TEXTAREA EN MORADO, EL COLOR EN BLANCO, CON UN TAMAÑO DE 17
}
