package es.urjc.etsii.dad.scholarWeb;

import java.io.File;
import javax.persistence.*;
import java.util.Arrays;

@Entity
public class Profesor {
	
	@Id
	private int identificador;
	@Column
	private String nombre;
	@Column
	private String correo;
	@Column
	private File comedor;
	@OneToMany
	private Asignatura[] asignaturas;
	@OneToMany
	private Alumno[] alumnos;
	@OneToMany
	private Padre[] padres;
	
	public Profesor() {}

	public Profesor(String n, String c) {
		this.nombre= n;
		this.correo=c;
	}

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public File getComedor() {
		return comedor;
	}



	public void setComedor(File comedor) {
		this.comedor = comedor;
	}



	public Asignatura[] getAsignaturas() {
		return asignaturas;
	}



	public void setAsignaturas(Asignatura[] asignaturas) {
		this.asignaturas = asignaturas;
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
	
	
	
 @Override
	public String toString() {
		return "Profesor [nombre=" + nombre + ", correo=" + correo + ", asignaturas="
				+ Arrays.toString(asignaturas) + ", alumnos=" + Arrays.toString(alumnos); //puede ser mejor idea imprimir solo los cursos que imparte en lugar de los alumnos.
	}

	/*FUNCIONES PROPIAS*/
	public void EnviarComedor(Padre[]  p, File f) {}
	public void EnviarCorreo(Padre[] p){}
	public void Añadir_falta(Alumno a, Asignatura as){}
	public void Subir_notas(Asignatura a){}
	public void EnviarInfoExcursiones(Padre[] p){}

}

