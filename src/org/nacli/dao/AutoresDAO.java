package org.nacli.dao;
 
import java.util.List;
import org.nacli.model.Autores;
public interface AutoresDAO {
    //FIRMAS DE METODOS
    //CRUD
    boolean insertar(Autores autores);
    List<Autores> listarTodos();
    Autores buscarPorId(int id_autor);
    boolean actualizar(Autores autores);
    boolean eliminar(int id_autores);
    
}
