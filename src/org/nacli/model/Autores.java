package org.nacli.model;

// POJO: NOMBRE ATRIBUTOS CONSTRUCTORES GETTERS Y SETTERS 
public class Autores {
    /*
    create table autores(
    id_autor int primary key auto_increment,
    nombre_autor varchar(100) not null,
    apellido_autor varchar(100) not null,
    nacionalidad varchar(100),
    biografia text
    );
    */

    // Atributos de clase
    private long id_autor;
    private String nombre_autor;
    private String apellido_autor;
    private String nacionalidad;
    private String biografia;

    // Constructor vacío
    public Autores() {
    }

    // Constructor con parámetros en el orden correcto: ID, Nombre, Apellido, Nacionalidad, Biografía
    public Autores(Long id_autor, String nombre_autor, String apellido_autor, String nacionalidad, String biografia) {
        this.id_autor = (id_autor != null) ? id_autor : 0L;
        this.nombre_autor = nombre_autor;
        this.apellido_autor = apellido_autor;
        this.nacionalidad = nacionalidad;
        this.biografia = biografia;
    }

    // Getters y Setters
    public long getId_autor() {
        return id_autor;
    }

    public void setId_autor(long id_autor) {
        this.id_autor = id_autor;
    }

    public String getNombre_autor() {
        return nombre_autor;
    }

    public void setNombre_autor(String nombre_autor) {
        this.nombre_autor = nombre_autor;
    }

    public String getApellido_autor() {
        return apellido_autor;
    }

    public void setApellido_autor(String apellido_autor) {
        this.apellido_autor = apellido_autor;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
}