package com.banco.app.ui;

import com.banco.app.Model.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class VentanaLogin extends VBox {

    private static final List<Usuario> usuarios = new ArrayList<>();
    private static final List<Cuenta> cuentas = new ArrayList<>();

    public static void agregarUsuario(Usuario usuario, Cuenta cuenta) {
        usuarios.add(usuario);
        cuentas.add(cuenta);
    }

    public static void mostrar(Stage stage) {
        VBox root = new VBox(15);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #F0F0F0;");

        Label titulo = new Label("Iniciar sesión");
        titulo.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #0033A0;");

        TextField txtUsuario = new TextField();
        txtUsuario.setPromptText("Correo electrónico");

        PasswordField txtClave = new PasswordField();
        txtClave.setPromptText("Contraseña");

        Button btnIngresar = new Button("Ingresar");
        btnIngresar.setStyle("-fx-background-color: #0033A0; -fx-text-fill: white; -fx-font-weight: bold;");

        btnIngresar.setOnAction(e -> {
            String user = txtUsuario.getText().trim();
            String pass = txtClave.getText().trim();

            for (int i = 0; i < usuarios.size(); i++) {
                Usuario u = usuarios.get(i);
                if (u.getUsername().equals(user) && u.getPassword().equals(pass)) {
                    VentanaPrincipal.mostrar(stage, u, cuentas.get(i));
                    return;
                }
            }

            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setContentText("Usuario o contraseña incorrectos.");
            alerta.showAndWait();
        });

        root.getChildren().addAll(titulo, txtUsuario, txtClave, btnIngresar);
        stage.setScene(new Scene(root, 400, 250));
        stage.setTitle("BancoApp - Login");
        stage.show();
    }
}
