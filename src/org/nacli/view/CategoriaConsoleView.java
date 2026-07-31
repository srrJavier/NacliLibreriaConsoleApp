package org.nacli.view;

import java.util.List;
import java.util.Scanner;
import org.nacli.model.Categoria;

public class CategoriaConsoleView {

    private final Scanner leer = new Scanner(System.in);

    // Método para mostrar el menú
    public int mostrarMenu() {
        System.out.println("--- GESTIÓN DE CATEGORÍAS ---");
        System.out.println("1. Crear nueva categoría");
        System.out.println("2. Listar todas las categorías");
        System.out.println("3. Buscar categoría por nombre");
        System.out.println("4. Modificar categoría");
        System.out.println("5. Eliminar categoría");
        System.out.println("6. Regresar al menú principal");
        System.out.print("Seleccione una opción: ");

        return Integer.parseInt(leer.nextLine());
    }

    // Solicitar nombre de la categoría
    public String solicitarNombreCategoria() {
        System.out.print("Ingrese el nombre de la categoría: ");
        return leer.nextLine();
    }

    // Solicitar ID de la categoría
    public int solicitarIdCategoria() {
        System.out.print("Ingrese el ID de la categoría: ");
        return Integer.parseInt(leer.nextLine());
    }

    // Mostrar una categoría
    public void mostrarCategoria(Categoria categoria) {
        System.out.println("--- CATEGORÍA ENCONTRADA ---");
        System.out.println("Nombre: " + categoria.getnombreCategoria());
    }

    // Mostrar lista de categorías
    public void mostrarListaCategorias(List<Categoria> categorias) {
        System.out.println("--- LISTA DE CATEGORÍAS ---");
        System.out.printf("%-10s %-30s%n", "ID", "Nombre");

        for (Categoria categoria : categorias) {
            System.out.printf("%-10d %n",
                    categoria.getnombreCategoria());
        }

        System.out.println("--- FIN DE LA LISTA ---");
    }

    // Mostrar mensajes
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}