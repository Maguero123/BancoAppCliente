package com.banco.app.ui;

import com.banco.app.Model.Cuenta;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentanaCuenta {

    public static void mostrar(Cuenta cuenta) {
        Stage stage = new Stage();
        stage.setTitle("Detalle de Cuenta");

        Label lblCbu = new Label("CBU: " + cuenta.getCbu());
        Label lblTipo = new Label("Tipo: " + cuenta.getTipo());
        Label lblSaldo = new Label("Saldo actual: $" + String.format("%.2f", cuenta.getSaldo()));

        for (Label l : new Label[]{lblCbu, lblTipo, lblSaldo}) {
            l.setStyle("-fx-font-size: 16px;");
        }

        VBox root = new VBox(15, lblCbu, lblTipo, lblSaldo);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #ffffff;");

        stage.setScene(new Scene(root, 350, 200));
        stage.show();
    }
}
