package com.example.cuentas_bancarias.Controller;

import com.example.cuentas_bancarias.Main;
import com.example.cuentas_bancarias.Utilities.StaticCode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserDataCtrller implements Initializable {

    @FXML
    private TextField comisionFijaDescTF;

    @FXML
    private TextField comisionManteTF;

    @FXML
    private TextField maxDescuPermiTF;

    @FXML
    private TextField nombreCuentaTF;

    @FXML
    private TextField numCuentaTF;

    @FXML
    private Pane paneAhorro;

    @FXML
    private Pane paneCCEmpresa;

    @FXML
    private Pane paneCCPersonal;

    @FXML
    private TextField saldoInicialTF;

    @FXML
    private TextField tipoInteresDescTF;

    @FXML
    private TextField tipoInteresRemuTF;

    @FXML
    private ImageView volverIconImg;

    @FXML
    private ComboBox<String> tipoCuentaCB;

    @FXML
    void onExitAction(MouseEvent event) {
        StaticCode.exitApp();
    }

    @FXML
    void onVolverAction(MouseEvent event) {
        StaticCode.cambiarVistaImg("Start.fxml", this, volverIconImg, "Start Application");
    } // VOLVER AL MENU DE INICIO

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tipoCuentaCB.getItems().addAll(
                "Cuenta de ahorro",
                "Cuenta corriente personal",
                "Cuenta corriente de empresa"
        );

        paneAhorro.setVisible(false);
        paneCCEmpresa.setVisible(false);
        paneCCPersonal.setVisible(false);
    }
}
