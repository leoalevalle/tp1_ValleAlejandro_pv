package ar.edu.unju.fi.ejercicio17.main;

import ar.edu.unju.fi.ejercicio17.model.Jugador;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Jugador> jugadores = new ArrayList<>();

        int opcion;
        do {
            mostrarMenu();
            opcion = obtenerOpcion(scanner);
            try {
                switch (opcion) {
                    case 1:
                        altaJugador(scanner, jugadores);
                        break;
                    case 2:
                        mostrarDatosJugador(scanner, jugadores);
                        break;
                    case 3:
                        mostrarJugadoresOrdenados(jugadores);
                        break;
                    case 4:
                        modificarJugador(scanner, jugadores);
                        break;
                    case 5:
                        eliminarJugador(scanner, jugadores);
                        break;
                    case 6:
                        mostrarCantidadJugadores(jugadores);
                        break;
                    case 7:
                        mostrarCantidadPorNacionalidad(scanner, jugadores);
                        break;
                    case 8:
                        System.out.println("Saliendo del programa");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("***Error: Debe ingresar un número***");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("***Error: " + e.getMessage()+"***");
            } finally {
                System.out.println();
            }
        } while (opcion != 8);
    }

    public static void mostrarMenu() {
        System.out.println("*** Menú ***");
        System.out.println("1 - Alta de jugador");
        System.out.println("2 - Mostrar los datos del jugador");
        System.out.println("3 - Mostrar todos los jugadores ordenados por apellido");
        System.out.println("4 - Modificar los datos de un jugador");
        System.out.println("5 - Eliminar un jugador");
        System.out.println("6 - Mostrar la cantidad total de jugadores");
        System.out.println("7 - Mostrar la cantidad de jugadores que pertenecen a una nacionalidad");
        System.out.println("8 - Salir");
        System.out.print("Ingrese una opción: ");
    }

    public static int obtenerOpcion(Scanner scanner) {
        return scanner.nextInt();
    }

    public static void mostrarDatosJugador(Scanner scanner, ArrayList<Jugador> jugadores) {
    	System.out.println("***Debe conocer el nombre y apellido del jugador***");
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el apellido del jugador: ");
        String apellido = scanner.next();

        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
                System.out.println("Datos del jugador:");
                System.out.println(jugador.getNombre()+" "+jugador.getApellido());
                System.out.println("Nacido el "+jugador.getFechaNacimiento()+" en "+jugador.getNacionalidad());
                System.out.println("Altura: "+jugador.getEstatura()+"m. Peso: "+jugador.getPeso()+"kg");
                System.out.println("Posicion: "+jugador.getPosicion());
                return;
            }
        }
        System.out.println("***Error: No se encontró el jugador***");
    }

    public static void mostrarJugadoresOrdenados(ArrayList<Jugador> jugadores) {
        Collections.sort(jugadores, (j1, j2) -> j1.getApellido().compareToIgnoreCase(j2.getApellido()));
        System.out.println("Jugadores ordenados por apellido:");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getApellido() + ", " + jugador.getNombre());
        }
    }

    public static void modificarJugador(Scanner scanner, ArrayList<Jugador> jugadores) {
    	System.out.println("***Debe conocer el nombre y apellido del jugador***");
    	System.out.println("***Debe llenar nuevamente todos los datos del jugador***");
    	
        System.out.print("Ingrese el nombre del jugador a modificar: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el apellido del jugador a modificar: ");
        String apellido = scanner.next();

        Iterator<Jugador> iterator = jugadores.iterator();
        while (iterator.hasNext()) {
            Jugador jugador = iterator.next();
            if (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
            	System.out.print("Ingrese el nuevo nombre del jugador: ");
                jugador.setNombre(scanner.next());
                System.out.print("Ingrese el nuevo apellido del jugador: ");
                jugador.setApellido(scanner.next());
                System.out.print("Ingrese la nueva fecha de nacimiento del jugador (yyyy-mm-dd ej:2000-01-21): ");
                jugador.setFechaNacimiento(LocalDate.parse(scanner.next()));
                System.out.print("Ingrese el nuevo Pais de representacion: ");
                jugador.setNacionalidad(scanner.next());
                System.out.print("Ingrese la nueva estatura del jugador (metros ej: 1,67): ");
                jugador.setEstatura(scanner.nextDouble());
                System.out.print("Ingrese el nuevo peso del jugador (kg ej: 70,5): ");
                jugador.setPeso(scanner.nextDouble());
                System.out.print("Ingrese la nueva posición del jugador: ");
                jugador.setPosicion(scanner.next());
                System.out.println("Jugador modificado correctamente.");
                return;
            }
        }
        System.out.println("***Error: No se encontró el jugador***");
    }
    
    public static void altaJugador(Scanner scanner, ArrayList<Jugador> jugadores) {
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el apellido del jugador: ");
        String apellido = scanner.next();
        System.out.print("Ingrese la fecha de nacimiento del jugador (yyyy-mm-dd ej:2000-01-30): ");
        String fechaNacimientoStr = scanner.next();
        System.out.print("Ingrese el Pais de nacimiento del jugador: ");
        String nacionalidad = scanner.next();
        System.out.print("Ingrese la estatura del jugador (metros ej: 1,67): ");
        double estatura = scanner.nextDouble();
        System.out.print("Ingrese el peso del jugador(kg ej: 70,5): ");
        double peso = scanner.nextDouble();
        System.out.print("Ingrese la posición del jugador: ");
        String posicion = scanner.next();

        Jugador jugador = new Jugador(nombre, apellido, LocalDate.parse(fechaNacimientoStr), nacionalidad, estatura, peso, posicion);
        jugadores.add(jugador);
        System.out.println("Jugador agregado correctamente.");
    }

    public static void eliminarJugador(Scanner scanner, ArrayList<Jugador> jugadores) {
    	System.out.println("***Debe conocer el nombre y apellido del jugador***");
        System.out.print("Ingrese el nombre del jugador a eliminar: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el apellido del jugador a eliminar: ");
        String apellido = scanner.next();

        Iterator<Jugador> iterator = jugadores.iterator();
        while (iterator.hasNext()) {
            Jugador jugador = iterator.next();
            if (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
                iterator.remove();
                System.out.println("Jugador eliminado correctamente.");
                return;
            }
        }
        System.out.println("***Error: No se encontró el jugador***");
    }

    public static void mostrarCantidadJugadores(ArrayList<Jugador> jugadores) {
        System.out.println("Cantidad total de jugadores: " + jugadores.size());
    }

    public static void mostrarCantidadPorNacionalidad(Scanner scanner, ArrayList<Jugador> jugadores) {
        System.out.print("Ingrese el Pais de nacimiento para contar sus jugadores: ");
        String nacionalidad = scanner.next();

        int cantidad = 0;
        for (Jugador jugador : jugadores) {
            if (jugador.getNacionalidad().equalsIgnoreCase(nacionalidad)) {
                cantidad++;
            }
        }
        System.out.println("Cantidad de jugadores nacidos en " + nacionalidad + ": " + cantidad);
    }
}
