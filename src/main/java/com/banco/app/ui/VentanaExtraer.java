package com.banco.app.ui;

import com.banco.app.Model.Cuenta;
import com.banco.app.Model.Movimiento;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentanaExtraer {

    public static void mostrar(Cuenta cuenta) {
        Stage stage = new Stage();
        stage.setTitle("Extracción");

        TextField txtMonto = new TextField();
        txtMonto.setPromptText("Monto a extraer");

        Button btnConfirmar = new Button("Extraer");
        btnConfirmar.setStyle("-fx-background-color: #d32f2f; -fx-text-fill: white;");

        btnConfirmar.setOnAction(e -> {
            try {
                double monto = Double.parseDouble(txtMonto.getText());
                if (monto <= 0 || !cuenta.extraer(monto)) {
                    throw new IllegalArgumentException();
                }
                cuenta.agregarMovimiento(new Movimiento(cuenta, "Extracción", monto, "Retiro de dinero"));
                stage.close();
            } catch (Exception ex) {
                new Alert(Alert.AlertType.ERROR, "Monto inválido o saldo insuficiente").showAndWait();
            }
        });

        VBox root = new VBox(10, new Label("Ingrese el monto:"), txtMonto, btnConfirmar);
        root.setPadding(new Insets(20));
        stage.setScene(new Scene(root, 300, 180));
        stage.show();
    }
}
