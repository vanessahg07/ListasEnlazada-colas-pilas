package co.edu.uniquindio.escenario4_juego;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ListaCircularDoble<String> juego = new ListaCircularDoble<>();
            int opcion;
            
            System.out.println("=== JUEGO POR TURNOS - MESA CIRCULAR ===\n");
            
            do {
                System.out.println("\n--- MENÚ PRINCIPAL ---");
                System.out.println("1. Agregar jugador");
                System.out.println("2. Siguiente turno");
                System.out.println("3. Turno anterior");
                System.out.println("4. Ver jugador actual");
                System.out.println("5. Ver siguiente jugador");
                System.out.println("6. Ver jugador anterior");
                System.out.println("7. Expulsar jugador");
                System.out.println("8. Mostrar todos los jugadores");
                System.out.println("9. Ver cantidad de jugadores");
                System.out.println("10. Salir");
                System.out.print("Opción: ");
                
                opcion = scanner.nextInt();
                scanner.nextLine();
                
                switch(opcion) {
                    case 1 -> {
                        System.out.print("Nombre del jugador: ");
                        String jugador = scanner.nextLine();
                        juego.agregarJugador(jugador);
                        System.out.println("✓ " + jugador + " se unió a la partida");
                    }
                        
                    case 2 -> {
                        if(juego.esVacia()) {
                            System.out.println("✗ No hay jugadores en la partida");
                        } else {
                            String siguiente = juego.siguienteTurno();
                            System.out.println("▶ Turno pasa a: " + siguiente);
                        }
                    }
                        
                    case 3 -> {
                        if(juego.esVacia()) {
                            System.out.println("✗ No hay jugadores en la partida");
                        } else {
                            String anterior = juego.turnoAnterior();
                            System.out.println("◀ Turno regresa a: " + anterior);
                        }
                    }
                        
                    case 4 -> {
                        System.out.println("\n=== TURNO ACTUAL ===");
                        String actual = juego.jugadorActual();
                        if(actual == null) {
                            System.out.println("No hay jugadores en la partida");
                        } else {
                            System.out.println("🎮 Jugador actual: " + actual);
                        }
                    }
                        
                    case 5 -> {
                        if(juego.esVacia()) {
                            System.out.println("No hay jugadores en la partida");
                        } else {
                            String siguiente = juego.siguienteJugador();
                            System.out.println("⏩ Siguiente jugador: " + siguiente);
                        }
                    }
                        
                    case 6 -> {
                        if(juego.esVacia()) {
                            System.out.println("No hay jugadores en la partida");
                        } else {
                            String anterior = juego.anteriorJugador();
                            System.out.println("⏪ Jugador anterior: " + anterior);
                        }
                    }
                        
                    case 7 -> {
                        if(juego.esVacia()) {
                            System.out.println("✗ No hay jugadores para expulsar");
                        } else {
                            System.out.print("Nombre del jugador a expulsar: ");
                            String expulsar = scanner.nextLine();
                            if(juego.expulsarJugador(expulsar)) {
                                System.out.println("✓ " + expulsar + " ha sido expulsado");
                                if(juego.esVacia()) {
                                    System.out.println("La partida ha terminado");
                                } else {
                                    System.out.println("Nuevo turno actual: " + juego.jugadorActual());
                                }
                            } else {
                                System.out.println("✗ Jugador " + expulsar + " no encontrado");
                            }
                        }
                    }
                        
                    case 8 -> {
                        System.out.println("\n=== JUGADORES EN LA MESA ===");
                        System.out.println(juego.mostrarJugadores());
                        System.out.println("Total: " + juego.getTam() + " jugador(es)");
                    }
                        
                    case 9 -> System.out.println("Jugadores en partida: " + juego.getTam());
                        
                    case 10 -> System.out.println("¡Gracias por jugar!");
                        
                    default -> System.out.println("Opción no válida. Seleccione 1-10");
                }
                
            } while(opcion != 10);
        }
    }
}