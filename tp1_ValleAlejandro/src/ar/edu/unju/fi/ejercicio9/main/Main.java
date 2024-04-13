package ar.edu.unju.fi.ejercicio9.main;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio9.model.Producto;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 3; i++) {
            System.out.println("Ingrese los datos para el producto " + i + ":");
            Producto producto = new Producto();

            System.out.print("Nombre: ");
            producto.setNombre(scanner.nextLine());

            System.out.print("Código: ");
            producto.setCodigo(scanner.nextLine());

            System.out.print("Precio: ");
            producto.setPrecio(Double.parseDouble(scanner.nextLine()));

            System.out.print("Descuento (%): ");
            producto.setDescuento(Integer.parseInt(scanner.nextLine()));

            System.out.println("\nDatos del producto " + i + ":");
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Código: " + producto.getCodigo());
            System.out.println("Precio: $" + producto.getPrecio());
            System.out.println("Descuento: " + producto.getDescuento() + "%");
            System.out.println("Precio con descuento: $" + producto.calcularDescuento());

            scanner.nextLine();
        }
        scanner.close();
	}
}
