package org.nacli.view;
 
import java.util.List;

import java.util.Scanner;

import org.nacli.model.Cliente;
 
public class ClienteConsoleView {
 
    private final Scanner leer = new Scanner(System.in);
 
    // Método para mostrar las opciones de este menú

    public int mostrarMenu() {

        int opcion = 0;
 
        // Todo el menú

        System.out.println("--- GESTION DE CLIENTES ---");

        System.out.println("-1 CREAR nuevo Cliente ---");

        System.out.println("-2 LISTAR todos los Clientes ---");

        System.out.println("-3 BUSCAR Cliente por ID ---");

        System.out.println("-4 MODIFICAR Cliente ---");

        System.out.println("-5 ELIMINAR nuevo Cliente ---");

        System.out.println("-6 REGRESAR a menú PRINCIPAL ---");

        System.out.print("SELECCIONE UNA OPCION -->");
 
        opcion = Integer.parseInt(leer.nextLine());
 
        return opcion;

    }
 
    public long solicitarCUI() {

        System.out.println("Ingrese el CUI del cliente: ");

        return Long.parseLong(leer.nextLine());

    }
 
    // nombreCliente

    public String solicitarNombreCliente() {

        String nombre;
 
        System.out.println("Ingrese el NOMBRE del cliente");

        nombre = leer.nextLine();
 
        return nombre;

    }
 
    // apellidoCliente

    public String solicitarApellidoCliente() {

        System.out.println("Ingrese el APELLIDO del cliente");

        return leer.nextLine();

    }
 
    // correoElectronico

    public String solicitarCorreoElectronico() {

        System.out.println("Ingrese el CORREO electrónico del cliente");

        return leer.nextLine();

    }
 
    // Mostrar el detalle de un CLIENTE

    public void mostrarCliente(Cliente cliente) {
 
        System.out.println("--- DATOS DEL CLIENTE ---");

        System.out.println("CUI: " + cliente.getCui());

        System.out.println("NOMBRE: " + cliente.getNombre());

        System.out.println("APELLIDO: " + cliente.getApellido());

        System.out.println("CORREO E: " + cliente.getCorreoElectronico());

        System.out.println("---\n");

    }
 
    // Mostrar la lista de CLIENTES

    public void mostrarListaClientes(List<Cliente> clientes) {
 
        System.out.println("--- LISTA DE CLIENTES ---");
 
        // Tabla usando la propiedad %-[tamaño de columna]s

        System.out.printf(

                "%-15s %-10s %-10s %-10s\n",

                "CUI",

                "NOMBRE",

                "APELLIDO",

                "CORREO"

        );
 
        for (Cliente cliente : clientes) {
 
            System.out.printf(

                    "%-10s %-10s %-10s %-10s\n",

                    cliente.getCui(),

                    cliente.getNombre(),

                    cliente.getApellido(),

                    cliente.getCorreoElectronico()

            );

        }
 
        System.out.println(" --- fin de clientes ---\n");

    }
 
    // Para mostrar mensaje personalizado

    public void mostrarMensaje(String mensaje) {

        System.out.println(mensaje);

    }

}
 