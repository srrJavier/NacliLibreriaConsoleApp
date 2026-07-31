package org.nacli.dao;

import java.util.List;
import org.nacli.model.Categoria;

public interface CategoriaDAO {

    // Crear categoría
    boolean crear(Categoria categoria);

    // Listar categorías
    List<Categoria> listarTodos();

    // Buscar categoría por ID
    Categoria buscarPorId(int idCategoria);

    // Actualizar categoría
    boolean actualizar(Categoria categoria);

    // Eliminar categoría
    boolean eliminar(int idCategoria);
}
