package org.nacli.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.nacli.dao.CategoriaDAO;
import org.nacli.dao.impl.CategoriaDAOImpl;
import org.nacli.model.Categoria;
import org.nacli.system.Main;
import javafx.scene.control.cell.PropertyValueFactory;

public class CategoriaFXController implements Initializable {

    @FXML
    private TextField txtNombre;

    @FXML
    private Label lblMensaje;

    @FXML
    private TableView<Categoria> tablaCategoria;

    private final CategoriaDAO categoriaDAO = new CategoriaDAOImpl();
    private final ObservableList<Categoria> listaCategoria = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cargarTabla();
        seleccionarFila();
   colnombreCategoria.setCellValueFactory(new PropertyValueFactory<>("nombreCategoria"));

    }

    private void cargarTabla() {
        listaCategoria.setAll(categoriaDAO.listarTodos());
        tablaCategoria.setItems(listaCategoria);
    }

    private void seleccionarFila() {
        tablaCategoria.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> {
                    if (newSelection != null) {
                        txtNombre.setText(newSelection.getnombreCategoria());
                    }
                });
    }

    @FXML
    private void handleGuardar() {
 
        try {
 
            if (txtNombre.getText().trim().isEmpty()) {
 
                mostrarError("Todos los campos son obligatorios.");
                return;
            }
 
            Categoria cliente = new Categoria();
 
            cliente.setNombre(txtNombre.getText().trim());
 
            if (categoriaDAO.crear(cliente)) {
 
                lblMensaje.setText("Cliente registrado correctamente.");
 
                cargarTabla();
 
                limpiarFormulario();
            } else {
                mostrarError("No fue posible registrar la categoria.");
            }
        } catch (NumberFormatException e) {
            mostrarError("El nombre de la cxateogria no existe.");
        } catch (Exception e) {
            mostrarError(e.getMessage());
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
private TableColumn<Categoria, String> colnombreCategoria;

    @FXML
    private void handleVolver() {
        try {
            Main.cambiarVista("/org/key/view/MenuPrincipal.fxml");
        } catch (Exception e) {
            mostrarError("Error al volver al menú: " + e.getMessage());
        }
    }

    private void limpiarFormulario() {
        txtNombre.clear();
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
