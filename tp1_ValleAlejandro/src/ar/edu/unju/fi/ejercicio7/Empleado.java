package ar.edu.unju.fi.ejercicio7;

public class Empleado {
	private String nombre;
    private int legajo;
    private double salario;

    private static final double SalarioMinimo = 210000.00;
    private static final double AumentoPorMerito = 20000.00;

    public Empleado(String nombre, int legajo, double salario) {
        this.nombre = nombre;
        this.legajo = legajo;
        if (salario >= SalarioMinimo ) {
            this.salario = salario;
        } else {
            this.salario = SalarioMinimo ;
        }
    }

    public void mostrarDatos() {
        System.out.println("Nombre del empleado: " + nombre);
        System.out.println("Legajo: " + legajo);
        System.out.println("Salario : $" + salario);
    }

    public void darAumento() {
        salario += AumentoPorMerito;
    }

}
