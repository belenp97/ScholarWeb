package es.urjc.etsii.dad.scholarWeb;

public class Administrador {
	String id;
	Alumno[] alumnos;
	Padre[] padres;
	Profesor[] profesores;
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
