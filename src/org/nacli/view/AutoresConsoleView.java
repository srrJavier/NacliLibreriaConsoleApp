package org.nacli.view;
import java.util.List;
import java.util.Scanner;
import org.nacli.model.Autores;
public class AutoresConsoleView {
 
    private final Scanner leer = new Scanner (System.in);
 
    //metodo para mostrar las opciones de este menu
 
    public int mostrarMenu() {
        int opcion = 0;
 
        //todo el menu
 
        
        System.out.println("\n");
        System.out.println("___________________________ ");
        System.out.println("_____Gestion Autores_____");
        System.out.println("1. crear nuevo autor");
        System.out.println("2. listar todos los autores");
        System.out.println("3. buscar autor por ID");
        System.out.println("4. modificar autor");
        System.out.println("5. eliminar nuevo autor");
        System.out.println("6. regresdar a menu principal ");
        System.out.println("Seleccione una opcion");
        opcion = Integer.parseInt(leer.nextLine()); 
        return opcion ;
 
    }
 
    public int solicitarID() {
        System.out.println("Ingrese el id del autor: ");
        return Integer.parseInt(leer.nextLine());
 
    }
 
    //nombre autor
 
    public String solicitarNombreAutor() {
        System.out.println("ingrese el nombre del autor: ");
        return leer.nextLine();
 
    }
 
        public String solicitarApellidoAutor() {
        System.out.println("ingrese el apellido del autor: ");
        return leer.nextLine();
 
    }
 
         public String solicitarNacionalidad() {
        System.out.println("ingrese la nacionalidad del autor: ");
        return leer.nextLine();
 
    }
 
    
 
         public String solicitarBiografia() {
        System.out.println("ingrese la biografia del autor: ");
        return leer.nextLine();
 
    }
 
   //Mostrar el detalle de un autor   
 
   public void mostrarAutores(Autores autor){
             System.out.println("_____Datos autor_____");
             System.out.println("ID: " + autor.getId_autor()); 
             System.out.println("Nombre: " + autor.getNombre_autor()); 
             System.out.println("Apellido: " + autor.getApellido_autor()); 
             System.out.println("Nacionalidad: " + autor.getNacionalidad()); 
             System.out.println("Biografia: " + autor.getBiografia());
 
         }
 
   public void mostrarListaAutores(List<Autores> autor) {
       System.out.println("_____Lista autores_____");
       //tabla usando la propiedad %-[tamaño columna]s
       System.out.printf("%-15s %-30s %-30s %-30s %-45s \n" ,  "id " , "nombre" , "apellido" , " nacionalidad", "biografia");
       for (Autores autores : autor) {
           System.out.printf("%-15s %-30s %-30s %-30s %-45s \n",
                          autores.getId_autor(), autores.getNombre_autor(), autores.getApellido_autor(), autores.getNacionalidad() , autores.getBiografia());
 
            }
        System.out.println(" --- fin de clientes ---\n");
 
       }
 
   
 
   //para mostrar mensaje personalizado
 
   public void mostrarMensaje(String mensaje) { 
       System.out.println("mensaje");
 
   }
 
}