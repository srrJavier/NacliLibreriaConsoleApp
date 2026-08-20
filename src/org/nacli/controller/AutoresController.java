
package org.nacli.controller;

import java.util.List;
import org.nacli.dao.impl.AutorDAOImpl;
import org.nacli.model.Autores;
import org.nacli.view.AutoresConsoleView;
import org.nacli.dao.AutoresDAO;

public class AutoresController {

    private final AutoresDAO dao; 

    private final AutoresConsoleView vista; 

    public AutoresController(AutoresConsoleView vista) { 

        this.dao = new AutorDAOImpl() {}; 

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

        vista.mostrarListaAutores(dao.listarTodos()); 

    }


     private void buscar() {

        int id_autor = vista.solicitarID(); 

        Autores autor = dao.buscarPorId(id_autor);

        if(autor != null){

            vista.mostrarAutores(autor);

        } else {

            vista.mostrarMensaje("Autor no encontrado por el id: " + id_autor);

        }

    }

}
 