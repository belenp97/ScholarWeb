package es.urjc.etsii.dad.scholarWeb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Administrador {
	@Id
	String id;
	@Column
	Alumno[] alumnos;
	@Column
	Padre[] padres;
	@Column
	Profesor[] profesores;
	@Column
	Asignatura[] asignaturas;
	
	
	public Administrador(String id) {
		super();
		this.id = id;
	}


	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public Alumno[] getAlumnos() {
		return alumnos;
	}



	public void setAlumnos(Alumno[] alumnos) {
		this.alumnos = alumnos;
	}



	public Padre[] getPadres() {
		return padres;
	}



	public void setPadres(Padre[] padres) {
		this.padres = padres;
	}



	public Profesor[] getProfesores() {
		return profesores;
	}



	public void setProfesores(Profesor[] profesores) {
		this.profesores = profesores;
	}



	public Asignatura[] getAsignaturas() {
		return asignaturas;
	}



	public void setAsignaturas(Asignatura[] asignaturas) {
		this.asignaturas = asignaturas;
	}



	@Override
	public String toString() {
		return "Administrador [id=" + id + "]";
	}
	
	
	
	
}
