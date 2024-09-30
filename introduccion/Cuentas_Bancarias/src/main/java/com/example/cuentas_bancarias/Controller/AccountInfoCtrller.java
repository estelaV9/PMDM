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
            // SI EL CAMPO DE IBAN ESTA VACIO LANZA UNA ALERTA
            // SE LLAMA AL METODO ESTATICO PARA GENERAR ALERTAS Y SE PASAN LOS RESPECTIVOS PARAMETROS
            StaticCode.Alerts("ERROR", "Campos vacíos.", "¡ERROR!",
                    "Por favor, rellene todos los datos antes de continuar.");
        } else if (!Validator.isValidIban(numIbanTF.getText())) {
            // SE LLAMA AL METODO PARA VALIDAR EL IBAN, SI NO ES CORRECTO LANZA UNA ALERA
            StaticCode.Alerts("ERROR", "IBAN no válido.", "¡ERROR!",
                    "El IBAN proporcionado NO es válido.");
        } else {
            // SI ESTA CORRECTO, SE SETTEAR LA INFORMACION EN EL TEXTAREA DE LA INFORMACION DE LA CUENTA PROPORCIONADA
            // PARA ELLO SE LLAMARA AL METODO DE BANCO DONDE RETORNE LA INFORMACION Y SE SETTEARA LO QUE RETORNE
            contentPaneTxt.setText(StaticCode.banco.informacionCuenta(numIbanTF.getText()));
        }
    } // METODO PARA BUSCAR CUENTA POR IBAN

    @FXML
    void onExitAction(MouseEvent event) {
        // SE LLAMA AL METODO ESTATICO PARA SALIR DE LA APLICACION
        StaticCode.exitApp();
    } // SALIR DE LA APLICACIÓN

    @FXML
    void onVolverAction(MouseEvent event) {
        // SE LLAMA AL METODO ESTATICO CAMBIAR VISTA POR IMAGEN PARA VOLVER A LA PAGINA PRINCIPAL
        // SE INSERTA LOS PARAMETROS: NOMBRE DEL FXML AL QUE SE QUIERE IR, UN IMAGENVIEW Y EL TITULO QUE VA A TENER ESE STAGE
        StaticCode.cambiarVistaImg("Start.fxml", volverBtt, "Start Application");
    } // IR A LA PAGINA PRINCIPAL DE LA APLICACION

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // SE LE AÑADE MANUALMENTE EL ESTILO DEL FONDO Y DEL TEXTO
        /*** en el textArea no sirve cambiar el color de fondo con background (cambia el color del borde),
         * asique se pone control-inner-background para cambiar el color de fondo ***/
        contentPaneTxt.setStyle("-fx-control-inner-background: #56269c; -fx-text-fill: #FFFFFF; " +
                "-fx-font-size: 17;  -fx-font-family: 'Berlin Sans FB';");
    } // AL INICIAR ESTA VISTA, SE PONE EL FONDO DEL TEXTAREA EN MORADO, EL COLOR EN BLANCO,
    // CON UN TAMAÑO DE 17 CON FUENTE Berlin Sans FB
}
