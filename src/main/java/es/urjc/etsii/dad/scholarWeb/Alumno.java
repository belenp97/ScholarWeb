package es.urjc.etsii.dad.scholarWeb;

import java.util.Arrays;
import javax.persistence.*;


@Entity
public class Alumno {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer n_expediente;
	@Column
	String nombre;
	@Column
	String apellido;
	@Column
	String correo;
	@Column
	String letra_curso;
	@OneToMany
	Asignatura[] asignaturas;
	
	
	@Column
	int[][] faltas = new int[asignaturas.length][1];   //la idea es que las filas sean asignaturas y las columnas el nº de faltas.
	
	
	public Alumno() {}
	
	public Alumno(String n, String a,String c) {
		this.nombre=n;
		this.apellido=a;
		this.correo=c;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getN_expediente() {
		return n_expediente;
	}

	public void setN_expediente(Integer n_expediente) {
		this.n_expediente = n_expediente;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Asignatura[] getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Asignatura[] asignaturas) {
		this.asignaturas = asignaturas;
	}

	public int[][] getFaltas() {
		return faltas;
	}


	public String getLetra_curso() {
		return letra_curso;
	}
	
	
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", n_expediente=" + n_expediente + ", correo="
				+ correo + ", asignaturas=" + Arrays.toString(asignaturas) + ", faltas=" + Arrays.toString(faltas)
				+ ", letra_curso=" + letra_curso + "]";
	}

	/* FUNCIONES PROPIAS */ 
	public void VerDatos() {}
	public void VerNotas(Asignatura a) {}
	public void VerFaltas(Asignatura a) {}
	public void VerFaltasTotales() {}
}
