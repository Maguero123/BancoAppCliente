package com.banco.app.ui;

import com.banco.app.Model.Cuenta;
import com.banco.app.Model.Movimiento;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentanaDepositar {

    public static void mostrar(Cuenta cuenta) {
        Stage stage = new Stage();
        stage.setTitle("Depositar");

        TextField txtMonto = new TextField();
        txtMonto.setPromptText("Monto a depositar");

        Button btnConfirmar = new Button("Depositar");
        btnConfirmar.setStyle("-fx-background-color: #2E7D32; -fx-text-fill: white;");

        btnConfirmar.setOnAction(e -> {
            try {
                double monto = Double.parseDouble(txtMonto.getText());
                if (monto <= 0) throw new NumberFormatException();
                cuenta.depositar(monto);
                cuenta.agregarMovimiento(new Movimiento(cuenta, "Depósito", monto, "Depósito realizado"));
                stage.close();
            } catch (NumberFormatException ex) {
                new Alert(Alert.AlertType.ERROR, "Monto inválido").showAndWait();
            }
        });

        VBox root = new VBox(10, new Label("Ingrese el monto:"), txtMonto, btnConfirmar);
        root.setPadding(new Insets(20));
        stage.setScene(new Scene(root, 300, 180));
        stage.show();
    }
}
