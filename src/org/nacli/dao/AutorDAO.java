
package org.nacli.dao;

import java.util.List;
import org.nacli.model.Autor;

public interface AutorDAO {
    //firmas de metodos
    //CRUD
    boolean insertar(Autor autor);
    List<Autor> ListarTodos();
    Autor BuscarPorID(int idAutor);
    boolean actualizar(Autor autor);
    boolean eliminar(int idAutor);
    
}
