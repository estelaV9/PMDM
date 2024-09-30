package com.example.cuentas_bancarias.Utilities;

import com.example.cuentas_bancarias.App;
import com.example.cuentas_bancarias.Model.Banco;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.*;
import java.io.IOException;

public class StaticCode {
    public static Banco banco = new Banco(); // SE CREA ESTE OBJETO DE TIPO BANCO DE FORMA ESTATICA YA QUE SE UTILIZARA VARIAS VECES

    public static void exitApp() {
        int opcion = JOptionPane.showConfirmDialog(null,
                "¿Está seguro de que desea salir?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            System.exit(0); // CERRAR APLICACIÓN
        }
    } // SALIR DE LA APLICACIÓN

    public static void cambiarVistaBtt(String nameFxml, Button button, String title){
        try {
            // CARGAR EL ARCHIVO FXML
            FXMLLoader fxmlLoader = new
                    FXMLLoader(App.class.getResource(nameFxml));
            Parent root = fxmlLoader.load();
            // OBTENER CONTROLLER
            Object controller = fxmlLoader.getController();
            Scene scene = new Scene(root); // CREAR UNA NUEVA ESCENA
            Stage stage = (Stage) button.getScene().getWindow(); // OBTENER EL STAGE ACTUAL A PARTIR DEL BOTON QUE SE HA CLICADO
            stage.setTitle(title); // TITULO DE LA VENTANA
            stage.setScene(scene); // ESTABLECER LA NUEVA ESCENA AL STAGE ACTUAL
            // MOSTRAR VENTANA SI NO ESTA VISIBLE
            if (!stage.isShowing()) {
                stage.show();
            }
        } catch (IOException e) {
            e.printStackTrace(); // SI HAY ERROR EN LA CARGA DEL FXML, SE LANZA LA EXCEPCION
        }
    } // MATODO ESTATICO PARA CAMBIAR DE VISTA CON UN ID DE UN BOTON

    public static void cambiarVistaImg(String nameFxml, ImageView button, String title){
        try {
            // CARGAR EL ARCHIVO FXML
            FXMLLoader fxmlLoader = new
                    FXMLLoader(App.class.getResource(nameFxml));
            Parent root = fxmlLoader.load();
            // OBTENER CONTROLLER
            Object controller = fxmlLoader.getController();
            Scene scene = new Scene(root);
            Stage stage = (Stage) button.getScene().getWindow();
            stage.setTitle(title);
            stage.setScene(scene);
            // MOSTRAR VENTANA SI NO ESTA VISIBLE
            if (!stage.isShowing()) {
                stage.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // METODO ESTATICO PARA CAMBIAR DE VISTA CON ID DE UN IMAGEVIEW

    public static void Alerts (String tipoAlert, String tituloAlert, String headerText, String contentText){
        Alert alert = new Alert(Alert.AlertType.valueOf(tipoAlert.toUpperCase()));
        alert.setTitle(tituloAlert);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    } // METODO ESTATICO PARA GENERA UNA ALERTA

    public static void alertAbrirCuenta (boolean cuentaCreadaExito, String tipoCuenta){
        if(cuentaCreadaExito){
            // SI ESTA CORRECTO, SE MUESTRA UN ALERT DE CONFIRMACION
            StaticCode.Alerts("CONFIRMATION", "Añadir cuenta.", "CONFIRMATION",
                    "Se ha añadido correctamente una cuenta " + tipoCuenta + ".");
        } else {
            // SI LA OPERACION HA FALLADO, SE MUESTRA UN ALERT DE ERROR
            StaticCode.Alerts("ERROR", "Cuenta duplicada.", "¡ERROR!",
                    "La cuenta ya existe en el sistema."); // SI EL IBAN ESTA YA REGISTRADO, GENERA UN ERROR
        } // LLAMAR AL METODO ABRIR CUENTA PARA AÑADIRLA Y GENERAR ALERTAS
    } // METODO ESTATICO PARA COMPROBAR SI SE HA CREADO CORRECTAMENTE LAS CUENTAS (uso para no repetir codigo)
}
