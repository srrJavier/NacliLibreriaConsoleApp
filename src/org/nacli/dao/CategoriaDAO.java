
package org.nacli.dao;

import java.util.List;
import org.nacli.model.Categoria;

public interface CategoriaDAO {
    //firmas de metodos
    //CRUD
    boolean crear(Categoria cliente);
    List<Categoria> listarTodos();
    Categoria buscarPorId(long cui);
    boolean actualizar(Categoria cliente);
    boolean eliminar(long cui);
    
}