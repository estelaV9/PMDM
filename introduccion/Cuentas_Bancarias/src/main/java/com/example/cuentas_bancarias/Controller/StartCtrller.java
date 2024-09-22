package com.example.cuentas_bancarias.Controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import javax.swing.*;

public class StartCtrller {
    @FXML
    private ImageView abriCuentaBtt;
    @FXML
    void onExitAction(MouseEvent event) {
        int opcion = JOptionPane.showConfirmDialog(null,
                "¿Está seguro de que desea salir?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            System.exit(0); // CERRAR APLICACIÓN
        }
    } // SALIR DE LA APLICACIÓN

    @FXML
    void onNuevaCuentaAction(MouseEvent event) {

    }
}
