
package org.nacli.model;

import org.nacli.model.Empleado;

public class EmpleadoComisionado extends Empleado {
    
    //atributos de clase único
    private double ventasTotales;
    private double porcentajeComision;

    public EmpleadoComisionado() {
    }

    public EmpleadoComisionado(double ventasTotales, double porcentajeComision, String id, String nombre) {
        super(id, nombre);
        this.ventasTotales = ventasTotales;
        this.porcentajeComision = porcentajeComision;
    }

    public double getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(double porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    public double getVentasTotales() {
        return ventasTotales;
    }

    public void setVentasTotales(double ventasTotales) {
        this.ventasTotales = ventasTotales;
    }
    
    @Override
    public double calcularTotal() {
        return this.ventasTotales * (this.porcentajeComision/100);
    }
      
}
