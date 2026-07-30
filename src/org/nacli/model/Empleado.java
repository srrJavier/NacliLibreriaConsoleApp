package org.nacli.model;

public abstract class Empleado {
    //atributos de clase
    private String id;
    private String nombre;
    
    //constructores: vacio y lleno
    public Empleado(){
    
    }
    
    public Empleado(String id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }
    
    //Empleado empleado = new Empleado("1","Juan Perez");
    //Empleado empleado = new Empleado();
    
    //metodos getter y setter
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    //empleado.id = "000001" X
    //sout(empleado.id) X
    
    //empleado.setId("002")
    //String id = empleado.getId()
    
    public void setNombre(String nombre){
        //asigna a los atributos de clase
        this.nombre = nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    
    //metodo abstracto para heredar
    //método abstracto no lleva cuerpo o sea sin {}
    public abstract double calcularTotal();
    
}
