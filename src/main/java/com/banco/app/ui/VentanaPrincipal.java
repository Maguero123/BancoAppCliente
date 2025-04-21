package com.banco.app.ui;

import com.banco.app.Model.Cuenta;
import com.banco.app.Model.Usuario;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class VentanaPrincipal {

    public static void mostrar(Stage stage, Usuario usuario, Cuenta cuenta) {
        VBox root = new VBox(20);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #ffffff;");

        Label bienvenida = new Label("¡Hola, " + usuario.getCliente().getNombre() + "!");
        bienvenida.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #0033A0;");

        Label resumenCuenta = new Label("Saldo actual: $" + String.format("%.2f", cuenta.getSaldo()));
        resumenCuenta.setStyle("-fx-font-size: 16px; -fx-text-fill: #2E7D32;");

        // Botones principales
        Button btnCuenta = new Button("Ver cuenta");
        Button btnMovimientos = new Button("Movimientos");
        Button btnDepositar = new Button("Depositar");
        Button btnExtraer = new Button("Extraer");
        Button btnTransferir = new Button("Transferir");

        for (Button b : new Button[]{btnCuenta, btnMovimientos, btnDepositar, btnExtraer, btnTransferir}) {
            b.setPrefWidth(200);
            b.setStyle("-fx-background-color: #0033A0; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8;");
        }

        btnCuenta.setOnAction(e -> VentanaCuenta.mostrar(cuenta));
        btnMovimientos.setOnAction(e -> VentanaMovimientos.mostrar(cuenta));
        btnDepositar.setOnAction(e -> VentanaDepositar.mostrar(cuenta));
        btnExtraer.setOnAction(e -> VentanaExtraer.mostrar(cuenta));
        btnTransferir.setOnAction(e -> VentanaTransferir.mostrar(cuenta));

        VBox botones = new VBox(10, btnCuenta, btnMovimientos, btnDepositar, btnExtraer, btnTransferir);

        root.getChildren().addAll(bienvenida, resumenCuenta, botones);
        stage.setScene(new Scene(root, 400, 500));
        stage.setTitle("BancoApp - Inicio");
        stage.show();
    }
}
