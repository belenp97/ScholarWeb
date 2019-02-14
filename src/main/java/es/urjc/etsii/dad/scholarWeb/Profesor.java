package es.urjc.etsii.dad.scholarWeb;

import java.io.File;
import java.util.Arrays;

import javax.persistence.*;

@Entity
public class Profesor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer identificador;
	
	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}
	@Column
	private String nombre;
	@Column
	private String apellido1;
	@Column
	private String apellido2;
	@Column
	private String correo;
	@OneToMany (mappedBy = "Asignatura")
	private Asignatura[] asignaturas;
	@ManyToMany (mappedBy = "Alumno")
	private Alumno[] alumnos;
	@ManyToMany (mappedBy = "Aula")
	private Aula[] aulas;
	
	
	public Aula[] getAulas() {
		return aulas;
	}

	public void setAulas(Aula[] aulas) {
		this.aulas = aulas;
	}

	public Alumno[] getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Alumno[] alumnos) {
		this.alumnos = alumnos;
	}

	public Profesor(String n, String c, String a1, String a2) {
		this.nombre= n;
		this.apellido1 = a1;
		this.apellido2 = a2;
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



	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
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
	
	
	
	@Override
	public String toString() {
		return "Profesor [identificador=" + identificador + ", nombre=" + nombre + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + ", correo=" + correo + ", asignaturas=" + Arrays.toString(asignaturas)
				+ ", alumnos=" + Arrays.toString(alumnos) + ", aulas=" + Arrays.toString(aulas) + "]";
	}

	/*FUNCIONES PROPIAS*/
	public void EnviarComedor(Padre[]  p, File f) {}
	public void EnviarCorreo(Padre[] p){}
	public void Añadir_falta(Alumno a, Asignatura as){}
	public void Subir_notas(Asignatura a){}
	public void EnviarInfoExcursiones(Padre[] p){}

}

