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
        StaticCode.cambiarVistaImg("AccountInfo.fxml", datosCnBtt, "Account Information");
    } // IR A LA PAGINA DE OBTENER DATOS DE UNA CUENTA
    @FXML
    void onListarCuentasAction(MouseEvent event) {
        StaticCode.cambiarVistaImg("ListAccount.fxml", listadoCnBtt, "List Of Accounts");
    } // IR A LA PAGINA DE LISTAR CUENTAS
    @FXML
    void onRealizarIngresoAction(MouseEvent event) {
        StaticCode.cambiarVistaImg("DepositMoney.fxml", ingresoCnBtt, "Deposit Money");
    } // IR A LA PAGINA DE REALIZAR INGRESO
    @FXML
    void onRetirarEfectivoAction(MouseEvent event) {
        StaticCode.cambiarVistaImg("WithdrawMoney.fxml", retirarEfectivoBtt, "Withdraw Money");
    } // IR A LA PAGINA DE RETIRAR DINERO
    @FXML
    void onSaldoActualAction(MouseEvent event) {
        StaticCode.cambiarVistaImg("CheckBalance.fxml", saldoActualBtt, "Check Balance");
    } // IR A LA PAGINA DE OBTENER SALDO

    @FXML
    void onExitAction(MouseEvent event) {
        StaticCode.exitApp();
    } // SALIR DE LA APLICACIÓN

    @FXML
    void onNuevaCuentaAction(MouseEvent event) {
        StaticCode.cambiarVistaImg("UserData.fxml", abriCuentaBtt, "User Information");
    } // IR A LA VISTA DE INFORMACION DE USUARIO
}
