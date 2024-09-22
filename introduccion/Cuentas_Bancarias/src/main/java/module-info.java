module com.example.cuentas_bancarias {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens com.example.cuentas_bancarias to javafx.fxml;
    opens com.example.cuentas_bancarias.Controller to javafx.fxml;
    exports com.example.cuentas_bancarias;
}