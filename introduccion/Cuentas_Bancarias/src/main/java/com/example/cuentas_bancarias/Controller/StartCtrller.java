package com.example.cuentas_bancarias.Controller;

import com.example.cuentas_bancarias.Utilities.StaticCode;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import javax.swing.text.Utilities;

public class StartCtrller {
    @FXML
    private ImageView abriCuentaBtt;
    @FXML
    void onExitAction(MouseEvent event) {
        StaticCode.exitApp();
    } // SALIR DE LA APLICACIÓN

    @FXML
    void onNuevaCuentaAction(MouseEvent event) {
        StaticCode.cambiarVistaImg("UserData.fxml", abriCuentaBtt, "User Information");
    } // IR A LA VISTA DE INFORMACION DE USUARIO
}
