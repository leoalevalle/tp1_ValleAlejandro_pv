package ar.edu.unju.fi.ejercicio10.main;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio10.model.Pizza;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 3; i++) {
            System.out.println("Ingrese los datos para la pizza " + i + ":");
            Pizza pizza = new Pizza();

            System.out.print("Diámetro (20, 30 o 40 cm): ");
            int diametro = Integer.parseInt(scanner.nextLine());
            pizza.setDiametro(diametro);

            System.out.print("¿Lleva ingredientes especiales? (true/false): ");
            boolean tieneIngredientes = Boolean.parseBoolean(scanner.nextLine());
            pizza.setIngredientesEspeciales(tieneIngredientes);

            pizza.calcularPrecio();
            pizza.calcularArea();

            System.out.println("\nDatos de la pizza " + i + ":");
            System.out.println("Diámetro: " + pizza.getDiametro() + " cm");
            System.out.println("Precio: $" + pizza.getPrecio());
            System.out.println("Área: " + pizza.getArea() + " cm²");

            scanner.nextLine();
        }
        scanner.close();
    }
}