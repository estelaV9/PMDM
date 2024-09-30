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
            // SI EL CAMPO DE IBAN ESTA VACIO LANZA UNA ALERTA
            // SE LLAMA AL METODO ESTATICO PARA GENERAR ALERTAS Y SE PASAN LOS RESPECTIVOS PARAMETROS
            StaticCode.Alerts("ERROR", "Campos vacíos.",
                    "¡ERROR!", "Por favor, rellene todos los datos antes de continuar.");
        } else if (!Validator.isValidIban(numIbanTF.getText())) {
            // SE LLAMA AL METODO PARA VALIDAR EL IBAN, SI NO ES CORRECTO LANZA UNA ALERTA
            StaticCode.Alerts("ERROR", "IBAN no válido.", "¡ERROR!",
                    "El IBAN proporcionado NO es válido.");
        } else {
            if(StaticCode.banco.obtenerSaldo(numIbanTF.getText()) == -1){
                contentPaneTxt.setText("Esa cuenta no existe.\nPruebe con otro IBAM");
            } else {
                // SI LA OPERACION FUE EXITOSA, SE SETTEA EL SALDO ACTUAL DE LA CUENTA CON ESE IBAN
                contentPaneTxt.setText("Saldo actual de la cuenta:\n" + StaticCode.banco.obtenerSaldo(numIbanTF.getText()) + "€.");
            } // DEPENDIENDO DE LO QUE DEVUELVA EL METODO, SI -1 O EL SALDO, SE MOSTRARA EL SALDO O QUE NO EXISTE
        }
    } // METODO PARA CONSULTAR LA INFORMACION DE UNA CUENTA DE UN IBAN

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // SE LE AÑADE MANUALMENTE EL ESTILO DEL FONDO Y DEL TEXTO
        /*** en el textArea no sirve cambiar el color de fondo con background (cambia el color del borde),
         * asique se pone control-inner-background para cambiar el color de fondo ***/
        contentPaneTxt.setStyle("-fx-control-inner-background: #56269c; -fx-text-fill: #FFFFFF; " +
                "-fx-font-size: 22; -fx-font-family: 'Berlin Sans FB';");
    } // AL INICIAR ESTA VISTA, SE PONE EL FONDO DEL TEXTAREA EN MORADO, EL COLOR EN BLANCO,
    // CON UN TAMAÑO DE 22 CON FUENTE Berlin Sans FB
}
