
package org.nacli.model;

//POJO: Nombre, atributos, constructores, getters y setters
public class Categoria {

    private String nombreCategoria;

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    //atributos de clase
    


    //constructores: asignación de datos, instanciar objetos
    //vacio
    public Categoria() {
    }
    //lleno o con parametros
    public Categoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    //personalizador
    
    
    //getter and setters

    public String getNombre() {        
        return nombreCategoria;
    }

    public void setNombre(String nombre) {
        //formatear a Mayusucual
        String nombreMayusculas = nombre.toUpperCase();
        //formatear a Inicia con Mayusuculas
        this.nombreCategoria = nombreMayusculas;
    }

    public void setnombreCategoria(String string) {
       
    }

    public String getnombreCategoria() {
        
        return null;
        
    }
  
    
}