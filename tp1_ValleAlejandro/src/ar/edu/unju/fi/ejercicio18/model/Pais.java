package ar.edu.unju.fi.ejercicio18.model;

import java.util.Objects;

public class Pais {

    private int codigo;
    private String nombre;

    public Pais(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return codigo == pais.codigo &&
                Objects.equals(nombre, pais.nombre);
    }

    public int hashCode() {
        return Objects.hash(codigo, nombre);
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
}

