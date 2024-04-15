package ar.edu.unju.fi.ejercicio16;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nombres = new String[5];

        for (int i = 0; i < nombres.length; i++) {
            System.out.print("Ingrese el nombre de la persona " + (i + 1) + ": ");
            nombres[i] = scanner.next();
        }

        System.out.println("Valores en el array:");
        int j = 0;
        while (j < nombres.length) {
            System.out.println("Índice " + j + ": " + nombres[j]);
            j++;
        }

        System.out.println("Tamaño del array: " + nombres.length);

        byte indiceAEliminar;
        do {
            System.out.print("Ingrese el índice del elemento a eliminar (0-4): ");
            indiceAEliminar = scanner.nextByte();
        } while (indiceAEliminar < 0 || indiceAEliminar >= nombres.length);

        for (int i = (int)indiceAEliminar; i < nombres.length - 1; i++) {
            nombres[i] = nombres[i + 1];
        }
        nombres[nombres.length - 1] = "";

        System.out.println("Arreglo después de eliminar el elemento:");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }
    }
}
