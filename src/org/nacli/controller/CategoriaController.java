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

            try {

                opcion = vista.mostrarMenu();

                switch (opcion) {

                    case 1:
                        crear();
                        break;

                    case 2:
                        listar();
                        break;

                    case 3:
                        buscar();
                        break;

                    case 4:
                        modificar();
                        break;

                    case 5:
                        eliminar();
                        break;

                    case 6:
                        vista.mostrarMensaje(
                                "Regresando al menú principal..."
                        );
                        break;

                    default:
                        vista.mostrarMensaje(
                                "Opción no válida."
                        );
                }

            } catch (NumberFormatException e) {

                vista.mostrarMensaje(
                        "Debe ingresar un número válido."
                );

                opcion = 0;
            }

        } while (opcion != 6);
    }

    // CREAR
    private void crear() {

        String nombre = vista.solicitarNombreCategoria();

        if (nombre == null || nombre.trim().isEmpty()) {

            vista.mostrarMensaje(
                    "El nombre de la categoría es obligatorio."
            );

            return;
        }

        Categoria categoria = new Categoria();

        categoria.setNombreCategoria(
                nombre.trim()
        );

        if (dao.crear(categoria)) {

            vista.mostrarMensaje(
                    "Categoría creada correctamente."
            );

        } else {

            vista.mostrarMensaje(
                    "No fue posible crear la categoría."
            );
        }
    }

    // LISTAR
    private void listar() {

        vista.mostrarListaCategorias(
                dao.listarTodos()
        );
    }

    // BUSCAR POR NOMBRE
    private void buscar() {

        String nombre = vista.solicitarNombreCategoria();

        if (nombre == null || nombre.trim().isEmpty()) {

            vista.mostrarMensaje(
                    "Debe ingresar el nombre de la categoría."
            );

            return;
        }

        Categoria categoria = dao.buscarPorNombre(
                nombre.trim()
        );

        if (categoria != null) {

            vista.mostrarCategoria(categoria);

        } else {

            vista.mostrarMensaje(
                    "Categoría no encontrada: " + nombre
            );
        }
    }

    // MODIFICAR
    private void modificar() {

        String nombreActual
                = vista.solicitarNombreCategoria();

        if (nombreActual == null
                || nombreActual.trim().isEmpty()) {

            vista.mostrarMensaje(
                    "Debe ingresar el nombre actual."
            );

            return;
        }

        Categoria categoria
                = dao.buscarPorNombre(nombreActual.trim());

        if (categoria == null) {

            vista.mostrarMensaje(
                    "La categoría no existe."
            );

            return;
        }

        String nuevoNombre
                = vista.solicitarNombreCategoria();

        if (nuevoNombre == null
                || nuevoNombre.trim().isEmpty()) {

            vista.mostrarMensaje(
                    "El nuevo nombre es obligatorio."
            );

            return;
        }

        /*
         * Como Categoria no tiene ID, el DAO debe tener
         * un método actualizarPorNombre().
         */
        if (dao.actualizarPorNombre(
                nombreActual.trim(),
                nuevoNombre.trim())) {

            vista.mostrarMensaje(
                    "Categoría modificada correctamente."
            );

        } else {

            vista.mostrarMensaje(
                    "No fue posible modificar la categoría."
            );
        }
    }

    // ELIMINAR
    private void eliminar() {

        String nombre
                = vista.solicitarNombreCategoria();

        if (nombre == null
                || nombre.trim().isEmpty()) {

            vista.mostrarMensaje(
                    "Debe ingresar el nombre de la categoría."
            );

            return;
        }

        if (dao.eliminarPorNombre(nombre.trim())) {

            vista.mostrarMensaje(
                    "Categoría eliminada correctamente."
            );

        } else {

            vista.mostrarMensaje(
                    "No fue posible eliminar la categoría."
            );
        }
    }
}
