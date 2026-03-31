package co.edu.uniquindio.escenario1_panaderia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Cola<String> colaClientes = new Cola<>();
            int opcion;
            
            System.out.println("=== SISTEMA DE TURNOS - PANADERÍA ===\n");
            
            do {
                System.out.println("\n--- MENÚ PRINCIPAL ---");
                System.out.println("1. Agregar cliente a la cola");
                System.out.println("2. Atender cliente");
                System.out.println("3. Ver cola actual");
                System.out.println("4. Ver próximo cliente en turno");
                System.out.println("5. Buscar posición de un cliente");
                System.out.println("6. Ver cantidad de clientes en cola");
                System.out.println("7. Salir");
                System.out.print("Seleccione una opción: ");
                
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                
                switch(opcion) {
                    case 1 -> {
                        System.out.print("Ingrese el nombre del cliente: ");
                        String nombreCliente = scanner.nextLine();
                        colaClientes.agregar(nombreCliente);
                        System.out.println("✓ Cliente " + nombreCliente + " agregado a la cola.");
                        System.out.println("Turno #" + colaClientes.getTam());
                    }
                    
                    case 2 -> {
                        if(colaClientes.isVacia()) {
                            System.out.println("✗ No hay clientes en la cola para atender.");
                        } else {
                            String clienteAtendido = colaClientes.obtenerInicio();
                            colaClientes.eliminar();
                            System.out.println("✓ Atendiendo a: " + clienteAtendido);
                            System.out.println("Cliente atendido exitosamente.");
                        }
                    }
                    
                    case 3 -> {
                        System.out.println("\n=== COLA ACTUAL ===");
                        if(colaClientes.isVacia()) {
                            System.out.println("No hay clientes en la cola.");
                        } else {
                            System.out.println("Clientes en orden de atención:");
                            System.out.println(colaClientes.mostrarCola());
                            System.out.println("Total: " + colaClientes.getTam() + " cliente(s)");
                        }
                    }
                    
                    case 4 -> {
                        if(colaClientes.isVacia()) {
                            System.out.println("No hay clientes en espera.");
                        } else {
                            System.out.println("Próximo cliente en turno: " + colaClientes.obtenerInicio());
                        }
                    }
                    
                    case 5 -> {
                        if(colaClientes.isVacia()) {
                            System.out.println("No hay clientes en la cola.");
                        } else {
                            System.out.print("Ingrese el nombre del cliente a buscar: ");
                            String buscarCliente = scanner.nextLine();
                            int posicion = colaClientes.localizar(buscarCliente);
                            if(posicion == -1) {
                                System.out.println("Cliente " + buscarCliente + " no encontrado en la cola.");
                            } else {
                                System.out.println("Cliente " + buscarCliente + " está en la posición: " + (posicion + 1));
                            }
                        }
                    }
                    
                    case 6 -> System.out.println("Cantidad de clientes en cola: " + colaClientes.getTam());
                    
                    case 7 -> System.out.println("¡Gracias por usar el sistema! Cerrando...");
                    
                    default -> System.out.println("Opción no válida. Por favor seleccione una opción del 1 al 7.");
                }
                
            } while(opcion != 7);
        }
    }
}