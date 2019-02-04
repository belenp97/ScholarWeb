package es.urjc.etsii.dad.scholarWeb;

import java.util.Arrays;

public class Asignatura {
	String nombre;
	String curso;
	int[][] notas;
	public Asignatura(String nombre, String curso) {
		super();
		this.nombre = nombre;
		this.curso = curso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public int[][] getNotas() {
		return notas;
	}
	public void setNotas(int[][] notas) {
		this.notas = notas;
	}
	@Override
	public String toString() {
		return "Asignatura [nombre=" + nombre + ", curso=" + curso + ", notas=" + Arrays.toString(notas) + "]";
	}
	
	/*FUNCIONES PROPIAS*/
	
	public void InfoNotas() {}
	
	
}
