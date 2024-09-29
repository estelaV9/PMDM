package com.example.cuentas_bancarias.Controller;

import com.example.cuentas_bancarias.Utilities.StaticCode;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class StartCtrller {
    @FXML
    private ImageView abriCuentaBtt;
    @FXML
    private ImageView datosCnBtt;
    @FXML
    private ImageView ingresoCnBtt;
    @FXML
    private ImageView listadoCnBtt;
    @FXML
    private ImageView retirarEfectivoBtt;
    @FXML
    private ImageView saldoActualBtt;

    @FXML
    void onDatosCnAction(MouseEvent event) {

    }
    @FXML
    void onListarCuentasAction(MouseEvent event) {
        StaticCode.cambiarVistaImg("ListAccount.fxml", listadoCnBtt, "List Of Accounts");
    } // IR A LA PAGINA DE LISTAR CUENTAS
    @FXML
    void onRealizarIngresoAction(MouseEvent event) {

    }
    @FXML
    void onRetirarEfectivoAction(MouseEvent event) {

    }
    @FXML
    void onSaldoActualAction(MouseEvent event) {

    }    @FXML
    void onExitAction(MouseEvent event) {
        StaticCode.exitApp();
    } // SALIR DE LA APLICACIÓN

    @FXML
    void onNuevaCuentaAction(MouseEvent event) {
        StaticCode.cambiarVistaImg("UserData.fxml", abriCuentaBtt, "User Information");
    } // IR A LA VISTA DE INFORMACION DE USUARIO
}
