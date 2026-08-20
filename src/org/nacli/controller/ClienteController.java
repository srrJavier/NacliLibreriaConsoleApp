package org.nacli.controller;
 
import org.nacli.dao.ClienteDAO;

import org.nacli.dao.impl.ClienteDaoimpl;

import org.nacli.model.Cliente;

import org.nacli.view.ClienteConsoleView;
 
public class ClienteController {
 
    private final ClienteDAO dao;

    private final ClienteConsoleView vista;
 
    public ClienteController(ClienteConsoleView vista) {

        this.dao = (ClienteDAO) new ClienteDaoimpl();

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
 
        Cliente cliente = dao.buscarPorId(cui);
 
        if (cliente != null) {

            vista.mostrarCliente(cliente);

        } else {

            vista.mostrarMensaje("Cliente no encontrado con el CUI: " + cui);

        }

    }

}
 