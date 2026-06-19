
package org.nacli.dao;

import java.util.List;
import org.nacli.model.Autor;

public interface AutorDAO {
    //firmas de metodos
    //CRUD
    boolean insertar(Autor autor);
    List<Autor> listar();
    Autor buscar(int idAutor);
    boolean actualizar(Autor autor);
    boolean eliminar(int idAutor);
    
}
