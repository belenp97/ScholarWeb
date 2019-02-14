package es.urjc.etsii.dad.scholarWeb;

import java.util.Arrays;
import javax.persistence.*;


@Entity
public class Alumno {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer nexpediente;
	@Column
	String nombre;
	@Column
	String apellido1;
	@Column

	String apellido2;
	
	@ManyToMany (mappedBy="Asignatura")
	private Asignatura[] asignaturas;
	
	@ManyToMany (mappedBy="Profesor")
	private Profesor[] profesores;
	
	@ManyToOne
	private Aula aula;
	
	@Column
	int faltas; 
	
	@ManyToOne
	private Padre padre;
	
	
	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public Profesor[] getProfesores() {
		return profesores;
	}

	public void setProfesores(Profesor[] profesores) {
		this.profesores = profesores;
	}

	public Padre getPadre() {
		return padre;
	}

	public void setPadre(Padre padre) {
		this.padre = padre;
	}

	public Alumno(String n, String a1,String a2) {
		this.nombre=n;
		this.apellido1=a1;
		this.apellido2=a2;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}
	
	public String getApellido2() {
		return apellido2;
	}

	public void setApellido1(String apellido) {
		this.apellido1 = apellido;
	}
	
	public void setApellido2(String apellido) {
		this.apellido2 = apellido;
	}

	public int getNexpediente() {
		return nexpediente;
	}

	public void setNexpediente(Integer n_expediente) {
		this.nexpediente = n_expediente;
	}

	public Asignatura[] getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Asignatura[] asignaturas) {
		this.asignaturas = asignaturas;
	}

	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	@Override
	public String toString() {
		return "Alumno [nexpediente=" + nexpediente + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2="
				+ apellido2 + ", asignaturas=" + Arrays.toString(asignaturas) + ", profesores="
				+ Arrays.toString(profesores) + ", faltas=" + faltas + ", padre=" + padre + "]";
	}

	/* FUNCIONES PROPIAS */ 
	public void VerDatos() {}
	public void VerNotas(Asignatura a) {}
	public void VerFaltas(Asignatura a) {}
	public void VerFaltasTotales() {}
}
