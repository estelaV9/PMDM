package com.example.cuentas_bancarias.Controller;

import com.example.cuentas_bancarias.Main;
import com.example.cuentas_bancarias.Model.Banco;
import com.example.cuentas_bancarias.Model.CuentaBancaria;
import com.example.cuentas_bancarias.Model.Persona;
import com.example.cuentas_bancarias.Utilities.StaticCode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private TextField dniTF;
    @FXML
    private TextField apellidosTF;
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
    private Button añadirBtt;

    @FXML
    void onExitAction(MouseEvent event) {
        StaticCode.exitApp();
    } // SALIR DE LA APLICACION

    @FXML
    void onVolverAction(MouseEvent event) {
        StaticCode.cambiarVistaImg("Start.fxml", volverIconImg, "Start Application");
    } // VOLVER AL MENU DE INICIO

    @FXML
    void onTipoCuentaAction(ActionEvent event) {
        String tipoCuenta = tipoCuentaCB.getValue(); // GUARDA LA OPCION ELEGIDA
        switch (tipoCuenta) {
            case "Cuenta de ahorro":
                paneCCPersonal.setVisible(false);
                paneCCEmpresa.setVisible(false);
                paneAhorro.setVisible(true);
                break;

            case "Cuenta corriente personal":
                paneCCPersonal.setVisible(true);
                paneCCEmpresa.setVisible(false);
                paneAhorro.setVisible(false);
                break;

            case "Cuenta corriente de empresa":
                paneCCPersonal.setVisible(false);
                paneCCEmpresa.setVisible(true);
                paneAhorro.setVisible(false);
                break;
        }// SEGUN EL TIPO DE CUENTA QUE ELIJA SE APARECERA UN TIPO DE PANEL
    }

    @FXML
    void onAñadirAction(ActionEvent event) {
        if (nombreCuentaTF.getText().isEmpty() || saldoInicialTF.getText().isEmpty() || numCuentaTF.getText().isEmpty() ||
                tipoCuentaCB.getValue() == null || dniTF.getText().isEmpty() || apellidosTF.getText().isEmpty()) {
            StaticCode.Alerts("ERROR", "Campos vacíos.", "¡ERROR!", "Por favor, rellene todos los datos antes de continuar.");
        } else {
            String tipoCuenta = tipoCuentaCB.getValue(); // GUARDA LA OPCION ELEGIDA
            Persona persona = new Persona(nombreCuentaTF.getText(), apellidosTF.getText(), dniTF.getText());
            switch (tipoCuenta) {
                case "Cuenta de ahorro":
                    if (tipoInteresRemuTF.getText().isEmpty()) {
                        StaticCode.Alerts("ERROR", "Campos vacíos.", "¡ERROR!",
                                "Por favor, rellene todos los datos antes de continuar."); // GENERAR ALERTA
                    } else {
                        StaticCode.añadirCuenta(persona, Double.parseDouble(saldoInicialTF.getText()), numCuentaTF.getText(), "de ahorro");
                    }
                    break;

                case "Cuenta corriente personal":
                    if (comisionManteTF.getText().isEmpty()) {
                        StaticCode.Alerts("ERROR", "Campos vacíos.", "¡ERROR!", "Por favor, rellene todos los datos antes de continuar.");
                    } else {
                        StaticCode.añadirCuenta(persona, Double.parseDouble(saldoInicialTF.getText()), numCuentaTF.getText(), "corriente personal");
                    }
                    break;

                case "Cuenta corriente de empresa":
                    if (maxDescuPermiTF.getText().isEmpty() || tipoInteresDescTF.getText().isEmpty() || comisionFijaDescTF.getText().isEmpty()) {
                        StaticCode.Alerts("ERROR", "Campos vacíos.", "¡ERROR!", "Por favor, rellene todos los datos antes de continuar.");
                    } else {
                        StaticCode.añadirCuenta(persona, Double.parseDouble(saldoInicialTF.getText()), numCuentaTF.getText(), "corriente de empresa");
                    }
                    break;
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tipoCuentaCB.getItems().addAll(
                "Cuenta de ahorro",
                "Cuenta corriente personal",
                "Cuenta corriente de empresa"
        ); // AÑADIR LOS VALORES DEL COMBOBOX

        // ESCONDER LOS PANELES
        paneAhorro.setVisible(false);
        paneCCEmpresa.setVisible(false);
        paneCCPersonal.setVisible(false);
    }
}
