package com.example.cuentas_bancarias.Controller;

import com.example.cuentas_bancarias.Model.*;
import com.example.cuentas_bancarias.Utilities.StaticCode;
import com.example.cuentas_bancarias.Validator.Validator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.VLineTo;

import java.net.URL;
import java.util.ArrayList;
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
    ArrayList<String> nombreEntidades = new ArrayList<>();

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
        } else if (Validator.noContieneNumeros(nombreCuentaTF.getText()) || Validator.noContieneNumeros(apellidosTF.getText())) {
            // COMPROBAR QUE LOS CAMPOS DE CADENA NO CONTENGAN NUMEROS
            StaticCode.Alerts("ERROR", "Campos erroneos.", "¡ERROR!",
                    "Los campos de nombre y apellido no deben contener numeros.");
        } else if (!Validator.contieneNumeros(saldoInicialTF.getText())){
            // COMPROBAR QUE LOS CAMPOS NUMERICOS NO CONTENGAN CADENAS
            StaticCode.Alerts("ERROR", "Campos erroneos.", "¡ERROR!",
                    "El campo de saldo inicial no debe contener letras.");
        } else if (!Validator.validarDNI(dniTF.getText())) {
            // COMPROBAR QUE EL DNI ESTE BIEN ESCRITO
            StaticCode.Alerts("ERROR", "DNI no válido.", "¡ERROR!",
                    "El DNI proporcionado NO es válido.");
        } else if (!Validator.isValidIban(numCuentaTF.getText())) {
            // COMPROBAR QUE EL NUMERO DE IBAN ESTE BIEN
            StaticCode.Alerts("ERROR", "IBAN no válido.", "¡ERROR!",
                    "El IBAN proporcionado NO es válido.");
        } else{
            String tipoCuenta = tipoCuentaCB.getValue(); // GUARDA LA OPCION ELEGIDA
            Persona persona = new Persona(nombreCuentaTF.getText(), apellidosTF.getText(), dniTF.getText());
            CuentaBancaria cuentaBancaria;
            switch (tipoCuenta) {
                case "Cuenta de ahorro":
                    if (tipoInteresRemuTF.getText().isEmpty()) {
                        StaticCode.Alerts("ERROR", "Campos vacíos.", "¡ERROR!",
                                "Por favor, rellene todos los datos antes de continuar."); // GENERAR ALERTA
                    } else if (!Validator.contieneNumeros(tipoInteresRemuTF.getText())) {
                        // COMPROBAR QUE LOS CAMPOS NUMERICOS NO CONTENGAN CADENAS
                        StaticCode.Alerts("ERROR", "Campos erroneos.", "¡ERROR!",
                                "El campo de tipo de interes de remuneración no debe contener letras.");
                    } else {
                        // CREAR UN OBJETO DE LA CUENTA BANCARIA DE TIPO CUENTA AHORRO (uso de polimorfismo)
                        cuentaBancaria = new CuentaAhorro(persona, Double.parseDouble(saldoInicialTF.getText()),
                                numCuentaTF.getText(), Double.parseDouble(tipoInteresRemuTF.getText()));
                        StaticCode.alertAbrirCuenta(StaticCode.banco.abrirCuenta(cuentaBancaria), "de ahorro");
                    }
                    break;

                case "Cuenta corriente personal":
                    if (comisionManteTF.getText().isEmpty()) {
                        StaticCode.Alerts("ERROR", "Campos vacíos.", "¡ERROR!", "Por favor, rellene todos los datos antes de continuar.");
                    } else if (!Validator.contieneNumeros(comisionManteTF.getText())) {
                        // COMPROBAR QUE LOS CAMPOS NUMERICOS NO CONTENGAN CADENAS
                        StaticCode.Alerts("ERROR", "Campos erroneos.", "¡ERROR!",
                                "El campo de comisión de mantenimiento no debe contener letras.");
                    } else {
                        // CREAR UN OBJETO DE LA CUENTA BANCARIA DE TIPO CUENTA CORRIENTE PERSONAL (uso de polimorfismo)
                        cuentaBancaria = new CuentaCorrientePersonal(persona, Double.parseDouble(saldoInicialTF.getText()),
                                numCuentaTF.getText(), nombreEntidades, Double.parseDouble(comisionManteTF.getText()));
                        StaticCode.alertAbrirCuenta(StaticCode.banco.abrirCuenta(cuentaBancaria), "corriente personal");
                    }
                    break;

                case "Cuenta corriente de empresa":
                    if (maxDescuPermiTF.getText().isEmpty() || tipoInteresDescTF.getText().isEmpty() || comisionFijaDescTF.getText().isEmpty()) {
                        StaticCode.Alerts("ERROR", "Campos vacíos.", "¡ERROR!", "Por favor, rellene todos los datos antes de continuar.");
                    } else if (!Validator.contieneNumeros(maxDescuPermiTF.getText()) || !Validator.contieneNumeros(tipoInteresDescTF.getText()) ||
                        !Validator.contieneNumeros(comisionFijaDescTF.getText())) {
                        // COMPROBAR QUE LOS CAMPOS NUMERICOS NO CONTENGAN CADENAS
                        StaticCode.Alerts("ERROR", "Campos erroneos.", "¡ERROR!",
                                "Todos los campos a rellenar de Cuenta Corriente de empresa no debe contener letras.");
                    } else {
                        // CREAR UN OBJETO DE LA CUENTA BANCARIA DE TIPO CUENTA CORRIENTE DE EMPRESA (uso de polimorfismo)
                        cuentaBancaria = new CuentaCorrienteEmpresa(persona, Double.parseDouble(saldoInicialTF.getText()),
                                numCuentaTF.getText(), nombreEntidades, Double.parseDouble(maxDescuPermiTF.getText()),
                                Double.parseDouble(tipoInteresDescTF.getText()), Double.parseDouble(comisionFijaDescTF.getText()));
                        StaticCode.alertAbrirCuenta(StaticCode.banco.abrirCuenta(cuentaBancaria), "corriente de empresa");
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

        // CUANDO SE INICIA SE AÑADEN LOS VALORES DE LA LISTA DE ENTIDADES
        nombreEntidades.add("Banco Nacional");
        nombreEntidades.add("Compañía Eléctrica S.A.");
        nombreEntidades.add("Proveedor de Internet GlobalNet");
        nombreEntidades.add("Servicios Médicos SaludPlus");
        nombreEntidades.add("Asociación de Consumidores de Agua");
        nombreEntidades.add("Telefónica Móvil S.A.");
        nombreEntidades.add("Proveedores de Gas Natural");
        nombreEntidades.add("Servicios Financieros ABC");
        nombreEntidades.add("Agencia de Viajes TravelPro");
        nombreEntidades.add("Cines Cineplex");
        nombreEntidades.add("Supermercados MercadoGrande");
    }
}
