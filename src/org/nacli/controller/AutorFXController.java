
package org.nacli.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.nacli.dao.AutorDAO;
import org.nacli.dao.impl.AutorDAOImpl;
import org.nacli.model.Autor;
import org.nacli.system.Main;

public class AutorFXController implements Initializable {

    @FXML
    private TextField txtCui;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtCorreo;
    @FXML
    private Label lblMensaje;
    @FXML
    private TableView<Autor> tablaAutor;//Tabla de entidad: cliente

    private final AutorDAO AutorDAO = new AutorDAOImpl();
    private final ObservableList<Autor> listaAutor = FXCollections.observableArrayList();//Entidad:Cliente

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cargarTabla();
        seleccionarFila();
    }

    private void cargarTabla() {
        listaAutor.setAll(AutorDAO.listarTodos());
        tablaAutor.setItems(listaAutor);
    }

    private void seleccionarFila() {
        listaAutor.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> {
                    if (newSelection != null) {
                        txtIdAutor.setText(String.valueOf(newSelection.getCui()));
                        txtNombre.setText(newSelection.getNombre());
                        txtApellido.setText(newSelection.getApellido());
                        txtNacionalidad.setText(newSelection.getNacionalidad());
                        txtBiografia.setText(newSelection.getBiografia());
                    }
                });
    }

    @FXML
    private void handleGuardar() {
        try {
            if (txtIdAutor.getText().isEmpty() || txtNombre.getText().isEmpty()
                    || txtApellido.getText().isEmpty() || txtNacionalidad.getText().isEmpty() ||
                            txt.Biografia.getText().isEmpty()){
                mostrarError("Todos los campos son obligatorios.");
                return;
            }

            Autor autor = new Autor();
            Autor.setIAutor(Long.parseLong(txtCui.getText().trim()));
            Autor.setNombre(txtNombre.getText().trim());
            Autor.setApellido(txtApellido.getText().trim());
            Autor.setNacionalidad(txtNacionalidad.getText().trim());
            Autor.setBiografia(txtBiografia.getText().trim());

            if (AutorDAO.crear(autor)) {
                lblMensaje.setText("Autor registrado exitosamente.");
                cargarTabla();
                limpiarFormulario();
            } else {
                mostrarError("No se pudo registrar al Autor.");
            }
        } catch (NumberFormatException e) {
            mostrarError("El Id debe ser un número válido.");
        } catch (Exception e) {
            mostrarError("Error al guardar: " + e.getMessage());
        }
    }

    @FXML
    private void handleLimpiar() {
        limpiarFormulario();
        lblMensaje.setText("");
    }

    @FXML
    private void handleActualizar() {
        cargarTabla();
        lblMensaje.setText("Tabla actualizada.");
    }

    @FXML
    private void handleVolver() {
        try {
            Main.cambiarVista("/org/nacli/view/MenuPrincipal.fxml");
        } catch (Exception e) {
            mostrarError("Error al volver al menú: " + e.getMessage());
        }
    }

    private void limpiarFormulario() {
        txtCui.clear();
        txtNombre.clear();
        txtApellido.clear();
        txtNacionalidad.clear();
        txtBiografia.clear();
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
