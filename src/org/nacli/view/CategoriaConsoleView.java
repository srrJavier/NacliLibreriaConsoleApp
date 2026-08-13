package org.nacli.view;

import java.util.List;
import java.util.Scanner;
import org.nacli.model.Categoria;

public class CategoriaConsoleView {

    private final Scanner leer = new Scanner(System.in);

    // =========================================================
    // MENÚ
    // =========================================================
    public int mostrarMenu() {

        System.out.println();
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
    public String solicitarNombreCategoria() {

        System.out.print("Ingrese el nombre de la categoría: ");

        return leer.nextLine();
    }
   public void mostrarCategoria(Categoria categoria) {

        if (categoria == null) {

            System.out.println("Categoría no encontrada.");
            return;
        }

        System.out.println();
        System.out.println("--- CATEGORÍA ENCONTRADA ---");
        System.out.println("Nombre: " + categoria.getNombreCategoria());
    }

   public void mostrarListaCategorias(List<Categoria> categorias) {

        System.out.println();
        System.out.println("--- LISTA DE CATEGORÍAS ---");

        if (categorias == null || categorias.isEmpty()) {

            System.out.println("No existen categorías registradas.");

            return;
        }

        System.out.printf("%-30s%n", "Nombre");
        System.out.println("--------------------------------");

        for (Categoria categoria : categorias) {

            System.out.printf(
                    "%-30s%n",
                    categoria.getNombreCategoria()
            );
        }

        System.out.println("--------------------------------");
        System.out.println("--- FIN DE LA LISTA ---");
    }

  public void mostrarMensaje(String mensaje) {

        System.out.println(mensaje);
    }
}