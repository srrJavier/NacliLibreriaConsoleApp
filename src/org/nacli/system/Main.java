package org.nacli.system;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.application.Application;

public class Main extends Application {

    public static void cambiarVista(String orgnacliviewCategoriaViewfxml) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(
            getClass().getResource("/org/nacli/view/CategoriaView.fxml")
        );

        Scene scene = new Scene(root);

        stage.setTitle("Categorías");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

