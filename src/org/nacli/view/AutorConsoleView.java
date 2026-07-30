
package org.nacli.view;

import java.util.List;
import java.util.Scanner;
import org.nacli.model.Autor;

public class AutorConsoleView {
   
    private final Scanner leer = new Scanner(System.in);
    
    //metodo para mostrar las opciones de este menu
    
    public int mostrarMenu() {
        int opcion = 0;
        // todo el menu
        System.out.println("--- GESTION DE AUTOR ---");
        System.out.println("-1 CREAR nuevo Autor ---");
        System.out.println("-2 LISTAR todos los Autores ---");
        System.out.println("-3 BUSCAR Autores por ID ---");
        System.out.println("-4 MODIFICAR Autor ---");
        System.out.println("-5 ELIMINAR nuevo Autor ---");
        System.out.println("-6 REGRESAR a menú PRIMCIPAL ---");
        System.out.print("SELECCIONE UNA OPCION -->");
        opcion = Integer.parseInt(leer.nextLine());
        return opcion;
    }

    public long solicitarID() {
        System.out.println("Ingrese el ID del autor: ");
        return Long.parseLong(leer.nextLine());
    }

    //nombreCliente
    public String solicitarNombreAutor() {
        String nombre;
        System.out.println("Ingrese el NOMBRE del autor");
        nombre = leer.nextLine();
        return nombre;
        //return leer.nextLine();
    }

    //apellidoCliente
    public String solicitarApellidoAutor() {
        System.out.println("Ingrese el APELLIDO del autor");
        return leer.nextLine();
    }

    //correoEctronico
    public String solicitarNacionalidadAutor() {
        System.out.println("Ingres la NACIONALIDAD del autor");
        return leer.nextLine();
    }
    
    //mostrar el detalle de un CLIENTE
    public void mostrarAutor(Autor autor){
        System.out.println("--- DATOS DEL AUTOR ---");
        System.out.println("ID: " + autor.getIdAutor());
        System.out.println("NOMBRE: " + autor.getNombre());
        System.out.println("APELLIDO: " + autor.getApellido());
        System.out.println("NACIONALIDAD: "+ autor.getNacionalidad());
        System.out.println("BIOGRAFIA: "+ autor.getBiografia());
    }
    
    //mostrar la lista de CLIENTES -- lista de objeto List<T>, ArrayList<Cliente>
    public void mostrarListaAutor(List<Autor> autor){
        System.out.println("--- LISTA DE AUTOR ---");
        //tabla usando la propiedad %-[tamaño de columa]s
        System.out.printf("%-15s %-10s %-10s %-10s\n", "CUI","NOMBRE","APELLIDO","CORREO");        
        for (Autor Autor : autor) {
        System.out.printf("%-10s %-10s %-10s %-10s\n",
         Autor.getIdAutor(), Autor.getNombre(), Autor.getApellido(), Autor.getNacionalidad());
        }
    }
    
    //para mostrar mensaje personalizado
    public void mostrarMensaje(String mensaje){
        System.out.println(" --- fin de autores ---\n");
    }

    
}