package com.banco.app.ui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentanaInicio {

    public static void mostrar(Stage stage) {
        VBox root = new VBox(20);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #F8F9FA;");

        Label titulo = new Label("Bienvenido a BancoApp");
        titulo.setStyle("-fx-font-size: 20px; -fx-text-fill: #0033A0; -fx-font-weight: bold;");

        Button btnRegistro = new Button("Crear cuenta");
        Button btnLogin = new Button("Iniciar sesión");

        for (Button b : new Button[]{btnRegistro, btnLogin}) {
            b.setPrefWidth(200);
            b.setStyle("-fx-background-color: #0033A0; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8;");
        }

        btnRegistro.setOnAction(e -> VentanaRegistro.mostrar(stage));
        btnLogin.setOnAction(e -> VentanaLogin.mostrar(stage));

        root.getChildren().addAll(titulo, btnRegistro, btnLogin);
        stage.setScene(new Scene(root, 400, 250));
        stage.setTitle("BancoApp - Inicio");
        stage.show();
    }
}
