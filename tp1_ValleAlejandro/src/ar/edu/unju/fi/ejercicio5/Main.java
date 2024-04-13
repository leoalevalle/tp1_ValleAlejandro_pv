package ar.edu.unju.fi.ejercicio5;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese un número entero en el rango [1, 9]
        System.out.print("Por favor, ingrese un número entero en el rango [1, 9]: ");
        int numero = scanner.nextInt();

        // Validar que el número esté dentro del rango [1, 9]
        if (numero < 1 || numero > 9) {
            System.out.println("El número ingresado está fuera del rango válido.");
        } else {
            // Mostrar la tabla de multiplicar correspondiente al número ingresado
            System.out.println("Tabla de multiplicar del número " + numero + ":");
            for (int i = 1; i <= 10; i++) {
                int resultado = numero * i;
                System.out.println(numero + " x " + i + " = " + resultado);
            }
        }

        // Cerrar el Scanner después de su uso para liberar recursos
        scanner.close();

	}

}
