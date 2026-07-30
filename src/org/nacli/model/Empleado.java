package org.nacli.model;

public abstract class Empleado {
  
    private String id;
    private String nombre;
    
    
    public Empleado(){
    
    }
    
    public Empleado(String id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }
    

    
 
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
   
    
    public void setNombre(String nombre){
   
        this.nombre = nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    
   
    public abstract double calcularTotal();
    
}
