package org.nacli.model;

import org.nacli.model.Empleado;

public class EmpleadoPorHoras extends Empleado {

    //atributos de clase único
    private int horasTrabajadas;
    private double costoHora;

    public EmpleadoPorHoras() {
    }

    public EmpleadoPorHoras(int horasTrabajadas, double costoHora, String id, String nombre) {
        super(id, nombre);
        this.horasTrabajadas = horasTrabajadas;
        this.costoHora = costoHora;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getCostoHora() {
        return costoHora;
    }

    public void setCostoHora(double costoHora) {
        this.costoHora = costoHora;
    }

    @Override
    public double calcularTotal() {
        return horasTrabajadas * costoHora;
    }

}
