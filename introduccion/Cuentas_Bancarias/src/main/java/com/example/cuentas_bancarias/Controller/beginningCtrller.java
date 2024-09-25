package com.example.cuentas_bancarias.Controller;

import com.example.cuentas_bancarias.Main;
import com.example.cuentas_bancarias.Utilities.StaticCode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class beginningCtrller {
    @FXML
    private Button startAppBtt;
    @FXML
    void onStartAppAction(ActionEvent event) {
        StaticCode.cambiarVistaBtt("Start.fxml", this, startAppBtt, "Start Application");
    } // IR A LA PAGINA PRINCIPAL DE LA APLICACION
}