package org.nacli.dao;

import java.util.List;
import org.nacli.model.Categoria;

public interface CategoriaDAO {

    // Crear categoría
    boolean crear(Categoria categoria);

    // Listar todas las categorías
    List<Categoria> listarTodos();

    // Buscar categoría por nombre
    Categoria buscarPorNombre(String nombreCategoria);

    // Actualizar categoría por nombre
    boolean actualizarPorNombre(
            String nombreActual,
            String nuevoNombre
    );

    // Eliminar categoría por nombre
    boolean eliminarPorNombre(String nombreCategoria);
}