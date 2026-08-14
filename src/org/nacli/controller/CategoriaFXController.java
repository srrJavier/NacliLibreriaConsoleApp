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
import javafx.scene.control.cell.PropertyValueFactory;

import org.nacli.dao.CategoriaDAO;
import org.nacli.dao.impl.CategoriaDAOImpl;
import org.nacli.model.Categoria;
import org.nacli.system.Main;

public class CategoriaFXController implements Initializable {

    @FXML
    private TextField txtNombre;

    @FXML
    private Label lblMensaje;

    @FXML
    private TableView<Categoria> tablaCategoria;

    @FXML
    private TableColumn<Categoria, String> colnombreCategoria;

    private final CategoriaDAO categoriaDAO = new CategoriaDAOImpl();

    private final ObservableList<Categoria> listaCategoria
            = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        configurarTabla();
        cargarTabla();
        seleccionarFila();
    }

    private void configurarTabla() {

        colnombreCategoria.setCellValueFactory(
                new PropertyValueFactory<>("nombreCategoria")
        );

        tablaCategoria.setItems(listaCategoria);
    }

    private void cargarTabla() {

        try {

            listaCategoria.setAll(
                    categoriaDAO.listarTodos()
            );

        } catch (Exception e) {

            mostrarError(
                    "Error al listar categorías:\n"
                    + e.getMessage()
            );
        }
    }

    private void seleccionarFila() {

        tablaCategoria.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (obs, oldSelection, newSelection) -> {

                            if (newSelection != null) {

                                txtNombre.setText(
                                        newSelection.getNombreCategoria()
                                );
                            }
                        }
                );
    }

    @FXML
    private void handleGuardar() {

        try {

            String nombre = txtNombre.getText().trim();

            if (nombre.isEmpty()) {

                mostrarError(
                        "El nombre de la categoría es obligatorio."
                );

                return;
            }

            // Crear categoría
            Categoria categoria = new Categoria();

            categoria.setNombreCategoria(nombre);

            // Guardar
            if (categoriaDAO.crear(categoria)) {

                lblMensaje.setText(
                        "Categoría registrada correctamente."
                );

                cargarTabla();

                limpiarFormulario();

            } else {

                mostrarError(
                        "No fue posible registrar la categoría."
                );
            }

        } catch (Exception e) {

            mostrarError(
                    "Error al guardar la categoría:\n"
                    + e.getMessage()
            );
        }
    }

    @FXML
    private void handleLimpiar() {

        limpiarFormulario();

        lblMensaje.setText("");
    }

    private void limpiarFormulario() {

        txtNombre.clear();

        tablaCategoria.getSelectionModel()
                .clearSelection();
    }

    @FXML
    private void handleActualizar() {

        cargarTabla();

        lblMensaje.setText(
                "Tabla actualizada."
        );
    }

    @FXML
    private void handleVolver() {

        try {

            Main.cambiarVista(
                    "/org/key/view/MenuPrincipal.fxml"
            );

        } catch (Exception e) {

            mostrarError(
                    "Error al volver al menú: "
                    + e.getMessage()
            );
        }
    }

    private void mostrarError(String mensaje) {

        Alert alert = new Alert(
                Alert.AlertType.ERROR
        );

        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
