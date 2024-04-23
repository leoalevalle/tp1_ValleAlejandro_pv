package ar.edu.unju.fi.ejercicio18.model;
import java.util.Objects;

public class DestinoTuristico {

    private int codigo;
    private String nombre;
    private double precio;
    private Pais pais;
    private int cantidadDias;

    public DestinoTuristico(int codigo, String nombre, double precio, Pais pais, int cantidadDias) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.pais = pais;
        this.cantidadDias = cantidadDias;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DestinoTuristico that = (DestinoTuristico) o;
        return codigo == that.codigo &&
                Double.compare(precio, that.precio) == 0 &&
                cantidadDias == that.cantidadDias &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(pais, that.pais);
    }

    public int hashCode() {
        return Objects.hash(codigo, nombre, precio, pais, cantidadDias);
    }

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public int getCantidadDias() {
		return cantidadDias;
	}

	public void setCantidadDias(int cantidadDias) {
		this.cantidadDias = cantidadDias;
	}
    
}
