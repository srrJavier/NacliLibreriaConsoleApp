package org.nacli.model;

import org.nacli.model.Empleado;

public class EmpleadoAsalariado extends Empleado{
    
    //atributos de clase único
    private double salarioMensual;
    
    public EmpleadoAsalariado(){
        
    }
    
    public EmpleadoAsalariado(String id, String nombre, double salarioMensual){
        super(id,nombre);
        this.salarioMensual = salarioMensual;
    }


    
    public void setSalarioMensual(double salarioMensual){
        //acceder al atributo de clase y asignar el parametro del metodo
        //validaciones
        this.salarioMensual = salarioMensual;
    }
    
    public double getSalarioMensual(){
        //retorna atribos de clase
        return this.salarioMensual;
        
    }
    
    @Override
    public double calcularTotal() {
        return this.salarioMensual;
    }
            
}
