package com.banco.app.ui;

import com.banco.app.Model.Cliente;
import com.banco.app.Model.Cuenta;
import com.banco.app.Model.Usuario;
import com.banco.app.util.GeneradorCBU;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class VentanaRegistro {

    public static void mostrar(Stage stage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #F9F9F9;");

        Label titulo = new Label("Crear nueva cuenta");
        titulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        TextField txtNombre = new TextField(); txtNombre.setPromptText("Nombre completo");
        TextField txtDni = new TextField(); txtDni.setPromptText("DNI");
        TextField txtEmail = new TextField(); txtEmail.setPromptText("Correo electrónico");
        PasswordField txtClave = new PasswordField(); txtClave.setPromptText("Contraseña");
        TextField txtDireccion = new TextField(); txtDireccion.setPromptText("Dirección");
        TextField txtNacimiento = new TextField(); txtNacimiento.setPromptText("Fecha de nacimiento (dd/mm/yyyy)");
        TextField txtTelefono = new TextField(); txtTelefono.setPromptText("Teléfono");

        Button btnRegistrar = new Button("Registrarse");
        btnRegistrar.setStyle("-fx-background-color: #0033A0; -fx-text-fill: white; -fx-font-weight: bold;");

        btnRegistrar.setOnAction(e -> {
            if (txtNombre.getText().isEmpty() || txtDni.getText().isEmpty() || txtClave.getText().isEmpty()) {
                mostrarAlerta("Completá todos los campos obligatorios.");
                return;
            }

            Cliente cliente = new Cliente(
                    txtDni.getText(),
                    txtNombre.getText(),
                    txtEmail.getText()
            );

            Usuario nuevoUsuario = new Usuario(
                    txtEmail.getText(), // se usa email como usuario
                    txtClave.getText(),
                    cliente
            );

            Cuenta cuenta = new Cuenta(
                    GeneradorCBU.generar(),
                    cliente,
                    "Caja de Ahorro",
                    0.0
            );

            VentanaLogin.agregarUsuario(nuevoUsuario, cuenta);

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Cuenta creada");
            alerta.setHeaderText(null);
            alerta.setContentText("Tu cuenta fue creada exitosamente.");
            alerta.showAndWait();

            VentanaLogin.mostrar(stage);
        });

        root.getChildren().addAll(titulo, txtNombre, txtDni, txtEmail, txtClave, txtDireccion, txtNacimiento, txtTelefono, btnRegistrar);
        stage.setScene(new Scene(root, 400, 450));
        stage.setTitle("Registro");
        stage.show();
    }

    private static void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
