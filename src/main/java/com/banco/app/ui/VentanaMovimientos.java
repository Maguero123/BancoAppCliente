package com.banco.app.ui;

import com.banco.app.Model.Cuenta;
import com.banco.app.Model.Movimiento;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentanaMovimientos {

    public static void mostrar(Cuenta cuenta) {
        Stage stage = new Stage();
        stage.setTitle("Movimientos");

        ListView<String> lista = new ListView<>();
        lista.setItems(FXCollections.observableArrayList(
                cuenta.getMovimientos().stream()
                        .map(Movimiento::toString)
                        .toList()
        ));

        VBox root = new VBox(lista);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #ffffff;");

        stage.setScene(new Scene(root, 500, 300));
        stage.show();
    }
}
