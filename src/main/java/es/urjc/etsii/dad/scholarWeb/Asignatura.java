package es.urjc.etsii.dad.scholarWeb;

import java.util.Arrays;
import javax.persistence.*;

@Entity
@Table(name ="Asignatura")
public class Asignatura {
	@Id
	String nombre;
	@Column
	String curso;
	@Column
	int notas;
	
	@ManyToMany
	private Alumno[] alumnos;
	
	@ManyToOne
	private Profesor profesorPorAsignatura;
	
	
	public Profesor getProfesorPorAsignatura() {
		return profesorPorAsignatura;
	}

	public void setProfesorPorAsignatura(Profesor profesorPorAsignatura) {
		this.profesorPorAsignatura = profesorPorAsignatura;
	}

	public Alumno[] getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Alumno[] alumnos) {
		this.alumnos = alumnos;
	}

	public Asignatura() {}
	
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
	public int getNotas() {
		return notas;
	}
	public void setNotas(int notas) {
		this.notas = notas;
	}
	
	
	@Override
	public String toString() {
		return "Asignatura [nombre=" + nombre + ", curso=" + curso + ", notas=" + notas + ", alumnos="
				+ Arrays.toString(alumnos) + "]";
	}
	
	
}
