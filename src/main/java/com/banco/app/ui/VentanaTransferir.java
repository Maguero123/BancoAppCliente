package com.banco.app.ui;

import com.banco.app.Model.Cuenta;
import com.banco.app.Model.Movimiento;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentanaTransferir {

    public static void mostrar(Cuenta cuenta) {
        Stage stage = new Stage();
        stage.setTitle("Transferencia");

        TextField txtCbuDestino = new TextField();
        txtCbuDestino.setPromptText("CBU destino");

        TextField txtMonto = new TextField();
        txtMonto.setPromptText("Monto a transferir");

        Button btnConfirmar = new Button("Transferir");
        btnConfirmar.setStyle("-fx-background-color: #1976D2; -fx-text-fill: white;");

        btnConfirmar.setOnAction(e -> {
            try {
                double monto = Double.parseDouble(txtMonto.getText());
                if (monto <= 0 || !cuenta.extraer(monto)) {
                    throw new IllegalArgumentException();
                }
                cuenta.agregarMovimiento(new Movimiento(cuenta, "Transferencia", monto, "Transferido a " + txtCbuDestino.getText()));
                stage.close();
            } catch (Exception ex) {
                new Alert(Alert.AlertType.ERROR, "Monto inválido o saldo insuficiente").showAndWait();
            }
        });

        VBox root = new VBox(10,
                new Label("CBU destino:"), txtCbuDestino,
                new Label("Monto:"), txtMonto,
                btnConfirmar);
        root.setPadding(new Insets(20));
        stage.setScene(new Scene(root, 350, 220));
        stage.show();
    }
}
