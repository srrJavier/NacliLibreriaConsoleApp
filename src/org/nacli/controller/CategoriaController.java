package org.nacli.controller;

import org.nacli.dao.CategoriaDAO;
import org.nacli.dao.impl.CategoriaDAOImpl;
import org.nacli.model.Categoria;
import org.nacli.view.CategoriaConsoleView;

public class CategoriaController {

    private final CategoriaDAO dao;
    private final CategoriaConsoleView vista;

    public CategoriaController(CategoriaConsoleView vista) {
        this.dao = new CategoriaDAOImpl();
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;

        do {
            opcion = vista.mostrarMenu();

            switch (opcion) {
                case 1:
                    break;

                case 2:
                    listar();
                    break;

                case 3:
                    buscar();
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    break;

                default:
                    vista.mostrarMensaje("Opción no válida.");
            }

        } while (opcion != 6);
    }

    private void listar() {
        vista.mostrarListaCategorias(dao.listarTodos());
    }

    private void buscar() {
        int idCategoria = vista.solicitarIdCategoria();

        Categoria categoria = dao.buscarPorId(idCategoria);

        if (categoria != null) {
            vista.mostrarCategoria(categoria);
        } else {
            vista.mostrarMensaje("Categoría no encontrada con ID: " + idCategoria);
        }
    }
}