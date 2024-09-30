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
        StaticCode.cambiarVistaBtt("Start.fxml", startAppBtt, "Start Application");
    } // IR A LA PAGINA PRINCIPAL DE LA APLICACION
}