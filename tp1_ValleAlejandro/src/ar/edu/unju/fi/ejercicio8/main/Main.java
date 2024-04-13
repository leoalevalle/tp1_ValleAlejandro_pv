package ar.edu.unju.fi.ejercicio8.main;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio8.model.CalculadoraEspecial;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el valor de n:");
        int n = scanner.nextInt();

        CalculadoraEspecial calculadora = new CalculadoraEspecial(n);

        double sumatoria = calculadora.calcularSumatoria();
        System.out.println("La sumatoria es: " + sumatoria);

        double productoria = calculadora.calcularProductoria();
        System.out.println("La productoria es: " + productoria);

        scanner.close();
	}
}
