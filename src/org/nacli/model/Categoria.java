package org.nacli.model;

/**
 * POJO de la entidad Categoria.
 */
public class Categoria {

    private String nombreCategoria;

    // Constructor vacío
    public Categoria() {
    }

    // Constructor con parámetros
    public Categoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    // Getter
    public String getNombreCategoria() {
        return nombreCategoria;
    }

    // Setter
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    @Override
    public String toString() {
        return nombreCategoria;
    }
}
