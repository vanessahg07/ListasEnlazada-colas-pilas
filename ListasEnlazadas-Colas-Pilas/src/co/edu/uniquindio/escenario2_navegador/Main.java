package co.edu.uniquindio.escenario2_navegador;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ListaDoble<String> historial = new ListaDoble<>();
            int opcion;
            
            System.out.println("=== NAVEGADOR WEB - HISTORIAL DE NAVEGACIÓN ===\n");
            
            do {
                System.out.println("\n--- MENÚ PRINCIPAL ---");
                System.out.println("1. Visitar nueva página");
                System.out.println("2. Retroceder página anterior");
                System.out.println("3. Avanzar página siguiente");
                System.out.println("4. Mostrar página actual");
                System.out.println("5. Mostrar historial completo");
                System.out.println("6. Ver estado de navegación");
                System.out.println("7. Salir");
                System.out.print("Seleccione una opción: ");
                
                opcion = scanner.nextInt();
                scanner.nextLine();
                
                switch(opcion) {
                    case 1 -> {
                        System.out.print("Ingrese la URL de la página: ");
                        String url = scanner.nextLine();
                        historial.visitar(url);
                        System.out.println("✓ Visitando: " + url);
                        System.out.println("Página actual: " + historial.paginaActual());
                    }
                    
                    case 2 -> {
                        String anterior = historial.retroceder();
                        if(anterior == null) {
                            System.out.println("✗ No hay página anterior para retroceder");
                        } else {
                            System.out.println("◀ Retrocediendo a: " + anterior);
                        }
                    }
                    
                    case 3 -> {
                        String siguiente = historial.avanzar();
                        if(siguiente == null) {
                            System.out.println("✗ No hay página siguiente para avanzar");
                        } else {
                            System.out.println("▶ Avanzando a: " + siguiente);
                        }
                    }
                    
                    case 4 -> {
                        System.out.println("\n=== PÁGINA ACTUAL ===");
                        String actual = historial.paginaActual();
                        if(actual == null) {
                            System.out.println("No hay páginas en el historial");
                        } else {
                            System.out.println("URL: " + actual);
                        }
                    }
                    
                    case 5 -> {
                        System.out.println("\n=== HISTORIAL COMPLETO ===");
                        System.out.println(historial.mostrarHistorial());
                        System.out.println("Total de páginas: " + historial.getTam());
                    }
                    
                    case 6 -> {
                        System.out.println("\n=== ESTADO DE NAVEGACIÓN ===");
                        System.out.println("Página actual: " + historial.paginaActual());
                        System.out.println("¿Hay página anterior?: " + (historial.hayAnterior() ? "Sí" : "No"));
                        System.out.println("¿Hay página siguiente?: " + (historial.haySiguiente() ? "Sí" : "No"));
                        System.out.println("Total de páginas: " + historial.getTam());
                    }
                    
                    case 7 -> System.out.println("¡Gracias por usar el navegador!");
                    
                    default -> System.out.println("Opción no válida. Seleccione 1-7");
                }
                
            } while(opcion != 7);
        }
    }
}
