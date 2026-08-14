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

import org.nacli.dao.AutoresDAO;
import org.nacli.dao.impl.AutorDAOImpl;
import org.nacli.model.Autores;
import org.nacli.system.Main;

public class AutoresFXController implements Initializable {

    @FXML
    private TextField txtId_autor;

    @FXML
    private TextField txtNombre_autor; 

    @FXML
    private TextField txtApellido_autor;

    @FXML
    private TextField txtNacionalidad;

    @FXML
    private TextField txtBiografia;

    @FXML
    private Label lblMensaje;

    @FXML
    private TableView<Autores> tablaAutores;

    @FXML
    private TableColumn<Autores, Long> colId;

    @FXML
    private TableColumn<Autores, String> colNombre;

    @FXML
    private TableColumn<Autores, String> colApellido;

    @FXML
    private TableColumn<Autores, String> colNacionalidad;

    @FXML
    private TableColumn<Autores, String> colBiografia;

    private final AutoresDAO autoresDAO = new AutorDAOImpl();

    private final ObservableList<Autores> listaAutores =
            FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configurarTabla();
        cargarTabla();
        seleccionarFila();
    }

    private void configurarTabla() {
        if (colId != null) {
            colId.setCellValueFactory(new PropertyValueFactory<>("id_autor"));
        }
        if (colNombre != null) {
            colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre_autor"));
        }
        if (colApellido != null) {
            colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido_autor"));
        }
        if (colNacionalidad != null) {
            colNacionalidad.setCellValueFactory(new PropertyValueFactory<>("nacionalidad"));
        }
        if (colBiografia != null) {
            colBiografia.setCellValueFactory(new PropertyValueFactory<>("biografia"));
        }
    }

    private void cargarTabla() {
        try {
            listaAutores.clear();
            listaAutores.addAll(autoresDAO.listarTodos());
            if (tablaAutores != null) {
                tablaAutores.setItems(listaAutores);
                tablaAutores.refresh(); 
            } else {
                System.err.println("Error: tablaAutores es nulo (no está inyectado desde el FXML).");
            }
        } catch (Exception e) {
            mostrarError("Error al cargar autores: " + e.getMessage());
        }
    }

    private void seleccionarFila() {
        if (tablaAutores == null) {
            return;
        }

        tablaAutores.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (obs, oldSelection, newSelection) -> {
                            if (newSelection != null) {
                                if (txtId_autor != null) {
                                    txtId_autor.setText(String.valueOf(newSelection.getId_autor()));
                                }
                                if (txtNombre_autor != null) {
                                    txtNombre_autor.setText(newSelection.getNombre_autor());
                                }
                                if (txtApellido_autor != null) {
                                    txtApellido_autor.setText(newSelection.getApellido_autor());
                                }
                                if (txtNacionalidad != null) {
                                    txtNacionalidad.setText(newSelection.getNacionalidad());
                                }
                                if (txtBiografia != null) {
                                    txtBiografia.setText(newSelection.getBiografia());
                                }
                            }
                        }
                );
    }

    @FXML
    private void handleGuardar() {
        try {
            if (txtNombre_autor == null) {
                mostrarError("El campo de nombre no está conectado con el FXML.");
                return;
            }
            
            String idStr = (txtId_autor != null) ? txtId_autor.getText().trim() : "";
            String nombre = txtNombre_autor.getText().trim();
            String apellido = (txtApellido_autor != null) ? txtApellido_autor.getText().trim() : "";
            String nacionalidad = (txtNacionalidad != null) ? txtNacionalidad.getText().trim() : "";
            String biografia = (txtBiografia != null) ? txtBiografia.getText().trim() : "";

            if (nombre.isBlank() || apellido.isBlank() || nacionalidad.isBlank()) {
                mostrarError("Por favor, completa los campos obligatorios (Nombre, Apellido, Nacionalidad).");
                return;
            }

            Autores autor = new Autores();

            if (!idStr.isBlank()) {
                autor.setId_autor(Integer.parseInt(idStr));
            }

            autor.setNombre_autor(nombre);
            autor.setApellido_autor(apellido);
            autor.setNacionalidad(nacionalidad);
            autor.setBiografia(biografia);

            if (autoresDAO.insertar(autor)) {
                if (lblMensaje != null) {
                    lblMensaje.setText("Autor registrado exitosamente.");
                }
                cargarTabla();
                limpiarFormulario();
            } else {
                mostrarError("No se pudo registrar el autor en la base de datos.");
            }

        } catch (NumberFormatException e) {
            mostrarError("El ID debe ser un número entero válido.");
        } catch (Exception e) {
            mostrarError("Error al guardar: " + e.getMessage());
        }
    }

    @FXML
    private void handleLimpiar() {
        limpiarFormulario();
        if (tablaAutores != null) {
            tablaAutores.getSelectionModel().clearSelection();
        }
        if (lblMensaje != null) {
            lblMensaje.setText("");
        }
    }

    @FXML
    private void handleActualizar() {
        cargarTabla();
        if (lblMensaje != null) {
            lblMensaje.setText("Tabla actualizada.");
        }
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
        if (txtId_autor != null) txtId_autor.clear();
        if (txtNombre_autor != null) txtNombre_autor.clear();
        if (txtApellido_autor != null) txtApellido_autor.clear();
        if (txtNacionalidad != null) txtNacionalidad.clear();
        if (txtBiografia != null) txtBiografia.clear();
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}