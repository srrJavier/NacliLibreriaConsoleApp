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

    private TableView<Autores> tablaAutores;//Tabla de entidad: cliente
 
    private final AutoresDAO autoresDAO = new AutorDAOImpl();

    private final ObservableList<Autores> listaAutores = FXCollections.observableArrayList();//Entidad:Cliente
 
    @Override

    public void initialize(URL location, ResourceBundle resources) {

        cargarTabla();

        seleccionarFila();

    }
 
    private void cargarTabla() {

        listaAutores.setAll(autoresDAO.listarTodos());

        tablaAutores.setItems(listaAutores);

    }
 
    private void seleccionarFila() {

        tablaAutores.getSelectionModel().selectedItemProperty().addListener(

                (obs, oldSelection, newSelection) -> {

                    if (newSelection != null) {

                        txtId_autor.setText(String.valueOf(newSelection.getId_autor()));

                        txtNombre_autor.setText(newSelection.getNombre_autor());

                        txtNacionalidad.setText(newSelection.getNacionalidad());

                        txtApellido_autor.setText(newSelection.getApellido_autor());

                        txtBiografia.setText(newSelection.getBiografia());

                    }

                });

    }
 
    @FXML

    private void handleGuardar() {

        try {

            if (txtId_autor.getText().isEmpty() || txtNombre_autor.getText().isEmpty()

                    || txtNacionalidad.getText().isEmpty() || txtApellido_autor.getText().isEmpty() || txtBiografia.getText().isEmpty()) {

                mostrarError("Todos los campos son obligatorios.");

                return;

            }
 
            Autores autor = new Autores();

            autor.setId_autor(Integer.parseInt(txtId_autor.getText().trim()));

            autor.setNombre_autor(txtNombre_autor.getText().trim());

            autor.setNacionalidad(txtNacionalidad.getText().trim());

            autor.setApellido_autor(txtApellido_autor.getText().trim());

            autor.setBiografia(txtBiografia.getText().trim());
 
            if (autoresDAO.insertar(autor)) {

                lblMensaje.setText("Autor registrado exitosamente.");

                cargarTabla();

                limpiarFormulario();

            } else {

                mostrarError("No se pudo registrar el autor.");

            }

        } catch (NumberFormatException e) {

            mostrarError("El ID debe ser un número válido.");

        } catch (Exception e) {

            mostrarError("Error al guardar: " + e.getMessage());

        }

    }
    

 
   
    @FXML
    private void handleLimpiar() {

        limpiarFormulario();
        tablaAutores.getSelectionModel().clearSelection();
        lblMensaje.setText("");
    }
    
 
    @FXML

    private void handleActualizar() {

        cargarTabla();

        lblMensaje.setText("Tabla actualizada.");

    }
 
    @FXML

  
 
    private void limpiarFormulario() {

        txtId_autor.clear();

        txtNombre_autor.clear();

        txtNacionalidad.clear();

        txtApellido_autor.clear();

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
 