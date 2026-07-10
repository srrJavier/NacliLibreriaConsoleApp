
package org.nacli.controller;

import java.util.List;
import org.nacli.dao.AutorDAO;
import org.nacli.dao.impl.AutorDAOImpl;
import org.nacli.model.Autor;
import org.nacli.view.AutorConsoleView;

public class AutorController {
    private final AutorDAO dao;
    private final AutorConsoleView vista;

    public AutorController(AutorConsoleView vista) {
        this.dao = new AutorDAOImpl() {
            @Override
            public Autor buscarPorID(Autor autor) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public List<Autor> listarTodos() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
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
                    throw new AssertionError();
            }
        } while (opcion != 6);
    }

    private void listar() {
      vista.mostrarListaClientes(dao.listarTodos());
    }

    private void buscar() {
        long idAutor = vista.solicitarID();
        Autor autor = null;
        autor = dao.buscarPorID(autor);
            
        if (autor != null) {
            vista.mostrarAutor(autor);
        } else {
            vista.mostrarMensaje("Autor no encontrado con el ID: " + idAutor);
        }
    }
}