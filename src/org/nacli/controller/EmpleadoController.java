package org.nacli.controller;

import java.util.ArrayList;
import javafx.scene.control.TabPane;
import org.nacli.model.Empleado;
import org.nacli.model.EmpleadoAsalariado;
import org.nacli.model.EmpleadoComisionado;
import org.nacli.model.EmpleadoPorHoras;
import org.nacli.view.EmpleadoView;

public class EmpleadoController {

    //elementos para acceder a mis objetos tipo nodo de la vista
    private final EmpleadoView vista;
    private final ArrayList<Empleado> listaEmpleados;

    //constructor
    public EmpleadoController(EmpleadoView vista) {
        this.vista = vista;
        this.listaEmpleados = new ArrayList<>();
        inicializarEventos();
    }

    private void inicializarEventos() {
        //combobox
        vista.getCbTipoEmpleado().setOnAction(e -> manejarTipoEmpleado());
        //boton guardar
        vista.getBtnGuardar().setOnAction(e -> guardarEmpleado());
        //boton actualizar
        vista.getBtnCalcular().setOnAction(e -> calcularNomina());
    }

    private void manejarTipoEmpleado() {
        //Accedemos al valor seleccionado de ComboBox
        String opcion = vista.getCbTipoEmpleado().getValue();
        //verificamos que no este vació
        if (opcion == null) {
        } else {
            return;
        }

        switch (opcion) {
            case "Asalariado" -> {
                //panelCambiante ---> txtSalario
                System.out.println("Se seleccion asalariado");
                vista.mostrarAsalariado();
            }
            case "Comision" -> {
                //panelCambiante ---> txtVentasTotales, txtPorcentaje
                System.out.println("Se seleccion Comision");
                vista.mostrarComisionado();
            }
            case "Por Horas" -> {
                //panelCambiante ---> txtHorasTotales, txtCostoHora
                System.out.println("Se seleccion Por horas");
                vista.mostrarPorHoras();
            }
        }
    }

    private void guardarEmpleado() {
        System.out.println("Se ha guardado en Empleado");
        String id = vista.getTxtId().getText();
        String nombre = vista.getTxtNombre().getText();
        String tipo = vista.getCbTipoEmpleado().getValue();

        Empleado nuevoEmpleado = null;

        switch (tipo) {
            case "Asalariado" -> {
                double salario = Double.parseDouble(vista.getTxtSalario().getText());
                nuevoEmpleado = new EmpleadoAsalariado(id, nombre, salario);
            }
            case "Por Horas" -> {
                //validacion de empleado por horas usando nuevoEmpleado
                int Horas = Integer.parseInt(vista.getTxtHoras().getText());
                double costoHora = Double.parseDouble(vista.getTxtCostoHoras().getText());
                nuevoEmpleado = new EmpleadoPorHoras(Horas, costoHora, id, nombre);
            }
            case "Comision" -> {
                 int Ventas;
                Ventas = Integer.parseInt(vista.getTxtHoras().getText());
                double Porcentaje = Double.parseDouble(vista.getTxtCostoHoras().getText());
                nuevoEmpleado = new EmpleadoPorHoras((int) Porcentaje,Ventas, id, nombre);
            }


        }
        //validacion de empleado Comision usando nuevoEmpleado
        listaEmpleados.add(nuevoEmpleado);

//        Empleado empleadoAsalariado = new EmpleadoAsalariado("001","Juan Perez", 1000.00);
//        Empleado empleadoAsalariado2 = new EmpleadoAsalariado("002","Mario Mario", 2000.00);
//        Empleado empPorHoras = new EmpleadoPorHoras(44, 30.00, id, nombre);
//        Empleado empComision = new EmpleadoComisionado(25000, 14, id, nombre);
//        listaEmpleados.add(empleadoAsalariado);
//        listaEmpleados.add(empleadoAsalariado2);
//        listaEmpleados.add(empPorHoras);
//        listaEmpleados.add(empComision);
        //guardar
    }

    private void calcularNomina() {
        System.out.println("Lista actualizada.");
        //vista.listaNomina <-- listaEmpleados
        //mostrar actualización de nomina
        vista.getListaNomina().getItems().clear();
        
        //recorrer la lista listaEmpleados agregado uno a uno a listaNomina de la vista
        for (Empleado empleado : listaEmpleados) {
            String fila = String.format("ID: %s | %s (%s) Pago Total: $%.2f \n",
                    empleado.getId(),
                    empleado.getNombre(),
                    empleado.getClass().getSimpleName(),
                    empleado.calcularTotal());
            vista.getListaNomina().getItems().add(fila);
        }
        
        
    }
}
