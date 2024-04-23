package ar.edu.unju.fi.ejercicio18.main;
import ar.edu.unju.fi.ejercicio18.model.Pais;
import ar.edu.unju.fi.ejercicio18.model.DestinoTuristico;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<DestinoTuristico> destinosTuristicos = new ArrayList<>();
    private static final ArrayList<Pais> paises = new ArrayList<>();

    public static void main(String[] args) {
        precargarPaises();

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    altaDestinoTuristico();
                    break;
                case 2:
                    mostrarDestinosTuristicos();
                    break;
                case 3:
                    modificarPaisDestinoTuristico();
                    break;
                case 4:
                    limpiarDestinosTuristicos();
                    break;
                case 5:
                    eliminarDestinoTuristico();
                    break;
                case 6:
                    mostrarDestinosTuristicosOrdenados();
                    break;
                case 7:
                    mostrarPaises();
                    break;
                case 8:
                    mostrarDestinosTuristicosPorPais();
                    break;
                case 9:
                    System.out.println("¡Gracias por usar la aplicación!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 9);

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n**Menú principal**");
        System.out.println("1. Alta de destino turístico");
        System.out.println("2. Mostrar todos los destinos turísticos");
        System.out.println("3. Modificar el país de un destino turístico");
        System.out.println("4. Limpiar el ArrayList de destinos turísticos");
        System.out.println("5. Eliminar un destino turístico");
        System.out.println("6. Mostrar los destinos turísticos ordenados por nombre");
        System.out.println("7. Mostrar todos los países");
        System.out.println("8. Mostrar los destinos turísticos que pertenecen a un país");
        System.out.println("9. Salir");
        System.out.print("Ingrese una opción: ");
    }

    public static void precargarPaises() {
        paises.add(new Pais(1, "Argentina"));
        paises.add(new Pais(2, "Brasil"));
        paises.add(new Pais(3, "Chile"));
        paises.add(new Pais(4, "Colombia"));
        paises.add(new Pais(5, "Perú"));
    }

    public static void altaDestinoTuristico() {
        try {
            System.out.print("Ingrese el código del destino turístico: ");
            int codigo = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Ingrese el nombre del destino turístico: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el precio del destino turístico: ");
            double precio = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Lista de países disponibles:");
            mostrarPaises();

            System.out.print("Ingrese el código del país del destino turístico: ");
            int codigoPais = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Ingrese la cantidad de días del destino turístico: ");
            int cantidadDias = scanner.nextInt();
            scanner.nextLine();

            Pais pais = buscarPais(codigoPais);
            if (pais != null) {
                DestinoTuristico destinoTuristico = new DestinoTuristico(codigo, nombre, precio, pais, cantidadDias);
                destinosTuristicos.add(destinoTuristico);
                System.out.println("Destino turístico creado con éxito.");
            } else {
                System.out.println("**No se encontró el país con el código ingresado**");
            }
        } catch (InputMismatchException e) {
            System.out.println("**Error: Se esperaba un número. Ingrese nuevamente**");
            scanner.nextLine();
        }
    }

    public static void mostrarDestinosTuristicos() {
        if (destinosTuristicos.isEmpty()) {
            System.out.println("No hay destinos turísticos registrados.");
        } else {
            System.out.println("\n**Lista de destinos turísticos**");
            for (DestinoTuristico destino : destinosTuristicos) {
            	mostrarDestinoTurustico(destino);
            }
        }
    }

    public static void modificarPaisDestinoTuristico() {
        try {
            System.out.print("Ingrese el código del destino turístico: ");
            int codigoDestino = scanner.nextInt();
            scanner.nextLine();

            DestinoTuristico destinoTuristico = buscarDestinoTuristico(codigoDestino);
            if (destinoTuristico != null) {
                System.out.println("Destino turístico actual:");
                mostrarDestinoTurustico(destinoTuristico);

                System.out.println("Lista de países disponibles:");
                mostrarPaises();

                System.out.print("Ingrese el código del nuevo país: ");
                int codigoPais = scanner.nextInt();
                scanner.nextLine();

                Pais nuevoPais = buscarPais(codigoPais);
                if (nuevoPais != null) {
                    destinoTuristico.setPais(nuevoPais);
                    System.out.println("País del destino turístico modificado con éxito.");
                    mostrarDestinoTurustico(destinoTuristico);
                } else {
                    System.out.println("**No se encontró el país con el código ingresado**");
                }
            } else {
                System.out.println("**No se encontró el destino turístico con el código ingresado**");
            }
        } catch (InputMismatchException e) {
            System.out.println("**Error: Se esperaba un número. Ingrese nuevamente**");
            scanner.nextLine();
        }
    }

    public static void limpiarDestinosTuristicos() {
        destinosTuristicos.clear();
        System.out.println("Lista de destinos turísticos limpiada con éxito.");
    }

    public static void eliminarDestinoTuristico() {
        try {
            System.out.print("Ingrese el código del destino turístico a eliminar: ");
            int codigoDestino = scanner.nextInt();
            scanner.nextLine();

            Iterator<DestinoTuristico> it = destinosTuristicos.iterator();
            while (it.hasNext()) {
                DestinoTuristico destino = it.next();
                if (destino.getCodigo() == codigoDestino) {
                	mostrarDestinoTurustico(destino);
                    it.remove();
                    System.out.println("Destino turístico eliminado con éxito.");
                    return;
                }
            }
            System.out.println("**No se encontró el destino turístico con el código ingresado**");
        } catch (InputMismatchException e) {
            System.out.println("**Error: Se esperaba un número. Ingrese nuevamente**");
            scanner.nextLine();
        }
    }

    public static void mostrarDestinosTuristicosOrdenados() {
        destinosTuristicos.sort((d1, d2) -> d1.getNombre().compareToIgnoreCase(d2.getNombre()));
        mostrarDestinosTuristicos();
    }

    public static void mostrarDestinosTuristicosPorPais() {
        try {
        	mostrarPaises();
            System.out.print("Ingrese el código del país: ");
            int codigoPais = scanner.nextInt();
            scanner.nextLine();

            Pais pais = buscarPais(codigoPais);
            if (pais != null) {
                ArrayList<DestinoTuristico> destinosPorPais = new ArrayList<>();
                for (DestinoTuristico destino : destinosTuristicos) {
                    if (destino.getPais().equals(pais)) {
                        destinosPorPais.add(destino);
                    }
                }

                if (destinosPorPais.isEmpty()) {
                    System.out.println("**No hay destinos turísticos para el país seleccionado**");
                } else {
                    System.out.println("\n**Destinos turísticos del país " + pais.getNombre() + "**");
                    for (DestinoTuristico destino : destinosPorPais) {
                    	mostrarDestinoTurustico(destino);
                    }
                }
            } else {
                System.out.println("**No se encontró el país con el código ingresado**");
            }
        } catch (InputMismatchException e) {
            System.out.println("**Error: Se esperaba un número. Ingrese nuevamente**");
            scanner.nextLine();
        }
    }
    
    public static void mostrarPaises() {
        if (paises.isEmpty()) {
            System.out.println("No hay países registrados.");
        } else {
            System.out.println("\n**Lista de países**");
            for (Pais pais : paises) {
                System.out.println("Codigo: "+pais.getCodigo()+", Nombre: "+pais.getNombre());
            }
        }
    }

    public static Pais buscarPais(int codigoPais) {
        for (Pais pais : paises) {
            if (pais.getCodigo() == codigoPais) {
                return pais;
            }
        }
        return null;
    }

    public static DestinoTuristico buscarDestinoTuristico(int codigoDestino) {
        for (DestinoTuristico destino : destinosTuristicos) {
            if (destino.getCodigo() == codigoDestino) {
                return destino;
            }
        }
        return null;
    }

    public static void mostrarDestinoTurustico(DestinoTuristico destinoTuristico) {
    	System.out.println("Codigo: "+destinoTuristico.getCodigo());
    	System.out.println("Nombre: "+destinoTuristico.getNombre());
    	System.out.println("Precio: "+destinoTuristico.getPrecio());
    	System.out.println("Cantidad de dias: "+destinoTuristico.getCantidadDias());
    	System.out.println("Pais: "+destinoTuristico.getPais().getNombre());
    	System.out.println();
    }
}
