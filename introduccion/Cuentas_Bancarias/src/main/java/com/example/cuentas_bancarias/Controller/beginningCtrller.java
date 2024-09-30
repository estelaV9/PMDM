package com.example.cuentas_bancarias.Controller;

import com.example.cuentas_bancarias.Utilities.StaticCode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class beginningCtrller {
    @FXML
    private Button startAppBtt;
    @FXML
    void onStartAppAction(ActionEvent event) {
        // SE LLAMA AL METODO ESTATICO CAMBIAR VISTA POR BOTON PARA IR A LA PAGINA PRINCIPAL
        // SE INSERTA LOS PARAMETROS: NOMBRE DEL FXML AL QUE SE QUIERE IR, UN BOTON Y EL TITULO QUE VA A TENER ESE STAGE
        StaticCode.cambiarVistaBtt("Start.fxml", startAppBtt, "Start Application");
    } // IR A LA PAGINA PRINCIPAL DE LA APLICACION
}