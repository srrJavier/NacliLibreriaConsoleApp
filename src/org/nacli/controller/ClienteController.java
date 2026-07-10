
package org.nacli.controller;

import org.nacli.dao.ClientesDAO;
import org.nacli.dao.impl.ClientesDAOImpl;
import org.nacli.model.clientes;
import org.nacli.view.ClienteConsoleView;

public class ClienteController {

    private final ClientesDAO dao;
    private final ClienteConsoleView vista;

    public ClienteController(ClienteConsoleView vista) {
        this.dao = new ClientesDAOImpl();
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
        long cui = vista.solicitarCUI();
        clientes cliente = dao.buscarPorId(cui);
        if (cliente != null) {
            vista.mostrarCliente(cliente);
        } else {
            vista.mostrarMensaje("Cliente no encontrado con el CUI: " + cui);
        }
    }
}