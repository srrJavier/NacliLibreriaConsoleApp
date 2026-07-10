
package org.nacli.dao;

import java.util.List;
import org.nacli.model.clientes;


public interface ClientesDAO {
    //firmas de metodos 
    boolean insetar(clientes cliente);
    List<clientes> listar();
    clientes buscar(long cui);
    boolean actualizar(clientes cliente);
    boolean eliminar (long cui);

    public List<clientes> listarTodos();

    public clientes buscarPorId(long cui);
}
