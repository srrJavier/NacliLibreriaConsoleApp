
package org.nacli.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import org.nacli.system.Main;


public class MenuPrincipalController {

    @FXML
    private void handleCategorias() {
        try {
            Main.cambiarVista("/org/nacli/view/CategoriaView.fxml");
        } catch (Exception e) {
            mostrarError("Error al cargar la vista de categorias:\n" + e.getMessage());
        }
    }

    @FXML
    private void handleNoDisponible() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Módulo no disponible");
        alert.setHeaderText(null);
        alert.setContentText("Este módulo no está disponible aún.");
        alert.showAndWait();
    }

    @FXML
    private void handleSalir() {
        Platform.exit();
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}