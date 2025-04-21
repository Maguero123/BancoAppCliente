package com.banco.app;

import com.banco.app.ui.VentanaInicio;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        VentanaInicio.mostrar(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
