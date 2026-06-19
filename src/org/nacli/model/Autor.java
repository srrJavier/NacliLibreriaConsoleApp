
package org.nacli.model;

public class Autor {
    /*id_autor int primary key auto_increment,
    nombre_autor varchar(100) not null,
    apellido_autor varchar(100) not null,
    nacionalidad varchar(100),
    biografia text
    */
    
    String idAutor;
    String nombre;
    String apellido;
    String nacionalidad;
    String biografia;
    
    //consultores: asignación de datos, instanciar objetos
    //vacio
    public Autor() {
    }
    //lleno con parametros
    public Autor(String idAutor, String nombre, String apellido, String nacionalidad, String biografia) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.biografia = biografia;
    }
    //personalizado
    
    //getter and setters:

    public String getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(String idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
       //formatear a Inicia con Mayuscula
       String nombreMayuscula = nombre.toUpperCase();
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
