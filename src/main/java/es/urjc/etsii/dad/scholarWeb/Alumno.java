package es.urjc.etsii.dad.scholarWeb;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name ="alumnos")
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
	@Column
	int faltas; 
	//@Column
	//private Alumno alumnos;
	
	@ManyToMany (mappedBy="alumno", targetEntity=Asignatura.class)
	private List<Asignatura> asignaturas = new ArrayList<>();
	
	@ManyToMany (targetEntity = Profesor.class)
	private List<Profesor> profesorePorAlumno = new ArrayList<>();
	
	@ManyToOne
	private Aula aula;
	
	@ManyToOne(targetEntity=Padre.class, fetch = FetchType.LAZY)
	private Padre padre_alumno;
	
	
	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public List<Profesor> getProfesores() {
		return profesorePorAlumno;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesorePorAlumno = profesores;
	}

	public Padre getPadre() {
		return padre_alumno;
	}

	public void setPadre(Padre padre) {
		this.padre_alumno = padre;
	}

	public Alumno(String n, String a1,String a2) {
		this.nombre=n;
		this.apellido1=a1;
		this.apellido2=a2;
		this.nexpediente= (int) (Math.random()*(120-1)+1);
	}
	
	public Alumno() {} 
	
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

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	
	/*public Alumno getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Alumno alumnos) {
		this.alumnos = alumnos;
	}*/

	@Override
	public String toString() {
		return "Alumno [nexpediente=" + nexpediente + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2="
				+ apellido2  + ", faltas=" + faltas + ", padre="  + "]";
	}

	/* FUNCIONES PROPIAS  
	public void VerDatos() {}
	public void VerNotas(Asignatura a) {}
	public void VerFaltas(Asignatura a) {}
	public void VerFaltasTotales() {}*/
}
