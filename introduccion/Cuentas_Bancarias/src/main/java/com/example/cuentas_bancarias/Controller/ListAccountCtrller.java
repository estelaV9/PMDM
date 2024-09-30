package com.example.cuentas_bancarias.Controller;

import com.example.cuentas_bancarias.Utilities.StaticCode;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class ListAccountCtrller implements Initializable {
    @FXML
    private TextArea contentPaneTxt;
    @FXML
    private ImageView volverBtt;

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
        contentPaneTxt.setStyle("-fx-control-inner-background: #56269c; -fx-text-fill: #FFFFFF; -fx-font-size: 17; " +
                "-fx-font-family: 'Berlin Sans FB';");
        String[] accountsList = StaticCode.banco.listadoCuentas(); // SE CREA LA LISTA CON EL LISTADO DE CEUNTAS
        for (String accountInfo : accountsList) {
            // SE USA APPEND PARA AGREGAR EL NUEVO TEXTO AL CONTENIDO ACTUAL.
            // YA QUE CON setText() REEMPLAZA EL CONTENIDO
            contentPaneTxt.appendText(accountInfo + "\n\n");
        } // FOR PARA SE RECORRE LAS CUENTAS Y SE VA AÑADIENDO LA INFORMACION
    } // AL INICIAR ESTA VISTA, SE PONE EL FONDO DEL TEXTAREA EN MORADO, EL COLOR EN BLANCO,
    // CON UN TAMAÑO DE 17 CON FUENTE Berlin Sans FB
}
