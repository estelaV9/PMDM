package com.example.cuentas_bancarias.Controller;

import com.example.cuentas_bancarias.Utilities.StaticCode;
import com.example.cuentas_bancarias.Validator.Validator;
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

public class CheckBalanceCtrller implements Initializable {
    @FXML
    private Button consultarBtt;
    @FXML
    private TextArea contentPaneTxt;
    @FXML
    private TextField numIbanTF;
    @FXML
    private ImageView volverBtt;

    @FXML
    void onConsultarAction(ActionEvent event) {
        if(numIbanTF.getText().isEmpty()){
            StaticCode.Alerts("ERROR", "Campos vacíos.", "¡ERROR!", "Por favor, rellene todos los datos antes de continuar.");
        } else if (!Validator.isValidIban(numIbanTF.getText())) {
            // COMPROBAR QUE EL NUMERO DE IBAN ESTE BIEN
            StaticCode.Alerts("ERROR", "IBAN no válido.", "¡ERROR!",
                    "El IBAN proporcionado NO es válido.");
        } else {
            if(StaticCode.banco.obtenerSaldo(numIbanTF.getText()) == -1){
                contentPaneTxt.setText("Esa cuenta no existe.\nPruebe con otro IBAM");
            } else {
                contentPaneTxt.setText("Saldo actual de la cuenta:\n" + StaticCode.banco.obtenerSaldo(numIbanTF.getText()) + "€.");
            } // DEPENDIENDO DE LO QUE DEVUELVA EL METODO, SI -1 O OTRO, SE MOSTRARA EL SALDO O QUE NO EXISTE
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
        /*** en el textArea no sirve cambiar el color de fondo con background (cambia el color del borde),
         * asique se pone control-inner-background para cambiar el color de fondo ***/
        contentPaneTxt.setStyle("-fx-control-inner-background: #56269c; -fx-text-fill: #FFFFFF; -fx-font-size: 22; -fx-font-family: 'Berlin Sans FB';");
    }
}
