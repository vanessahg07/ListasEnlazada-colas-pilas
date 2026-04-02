package co.edu.uniquindio.escenario3_musica;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ListaCircular<String> lista = new ListaCircular<>();
            int opcion;
            
            System.out.println("=== LISTA DE REPRODUCCIÓN CONTINUA ===\n");
            
            do {
                System.out.println("\n--- MENÚ PRINCIPAL ---");
                System.out.println("1. Agregar canción");
                System.out.println("2. Siguiente canción");
                System.out.println("3. Ver canción actual");
                System.out.println("4. Eliminar canción");
                System.out.println("5. Mostrar lista completa");
                System.out.println("6. Ver cantidad de canciones");
                System.out.println("7. Salir");
                System.out.print("Opción: ");
                
                opcion = scanner.nextInt();
                scanner.nextLine();
                
                switch(opcion) {
                    case 1 -> {
                        System.out.print("Nombre de la canción: ");
                        String cancion = scanner.nextLine();
                        lista.agregarCancion(cancion);
                        System.out.println("✓ Canción \"" + cancion + "\" agregada a la lista");
                    }
                        
                    case 2 -> {
                        if(lista.esVacia()) {
                            System.out.println("✗ No hay canciones en la lista");
                        } else {
                            String siguiente = lista.siguienteCancion();
                            System.out.println("▶ Reproduciendo: " + siguiente);
                        }
                    }
                        
                    case 3 -> {
                        System.out.println("\n=== CANCIÓN ACTUAL ===");
                        String actual = lista.cancionActual();
                        if(actual == null) {
                            System.out.println("No hay canciones en la lista");
                        } else {
                            System.out.println("▶ Reproduciendo: " + actual);
                        }
                    }
                        
                    case 4 -> {
                        if(lista.esVacia()) {
                            System.out.println("✗ No hay canciones para eliminar");
                        } else {
                            System.out.print("Nombre de la canción a eliminar: ");
                            String eliminar = scanner.nextLine();
                            if(lista.eliminarCancion(eliminar)) {
                                System.out.println("✓ Canción \"" + eliminar + "\" eliminada");
                                if(lista.esVacia()) {
                                    System.out.println("La lista de reproducción está vacía");
                                } else {
                                    System.out.println("Canción actual: " + lista.cancionActual());
                                }
                            } else {
                                System.out.println("✗ Canción \"" + eliminar + "\" no encontrada");
                            }
                        }
                    }
                        
                    case 5 -> {
                        System.out.println("\n=== LISTA DE REPRODUCCIÓN ===");
                        System.out.println(lista.mostrarLista());
                        System.out.println("Total: " + lista.getTam() + " canción(es)");
                    }
                        
                    case 6 -> System.out.println("Canciones en la lista: " + lista.getTam());
                        
                    case 7 -> System.out.println("¡Hasta luego!");
                        
                    default -> System.out.println("Opción no válida. Seleccione 1-7");
                }
                
            } while(opcion != 7);
        }
    }
}