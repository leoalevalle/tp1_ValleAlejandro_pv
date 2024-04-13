package ar.edu.unju.fi.ejercicio7.main;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio7.model.Empleado;


public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese nombre del empleado:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese legajo:");
        int legajo = scanner.nextInt();
        System.out.println("Ingrese salario:");
        double salario = scanner.nextDouble();

        Empleado empleado = new Empleado(nombre, legajo, salario);

        System.out.println("\nDatos del empleado:");
        empleado.mostrarDatos();
        

        empleado.darAumento();

        System.out.println("\nDespués del aumento:");
        empleado.mostrarDatos();

        scanner.close();
	}
}
