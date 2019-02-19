package es.urjc.etsii.dad.scholarWeb;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "alumnos")
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long nexpediente;
	@Column
	private String nombre;
	@Column
	private String apellido1;
	@Column
	private String apellido2;
	@Column
	private int faltas;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "alumno_por_asignatura", 
				joinColumns = { @JoinColumn(name = "alumno", nullable = false) },
				inverseJoinColumns = { @JoinColumn(name = "asignatura", nullable = false) })
	private List<Asignatura> asignaturas = new ArrayList<>();

	@ManyToMany(mappedBy = "alumnos_por_profesor", targetEntity= Profesor.class)
	private List<Profesor> profesores_por_alumno = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name="alumno_aula")
	private Aula aula;

	@ManyToOne
	@JoinColumn(name="padre_alumno")
	private Padre padre_alumno;

	public Alumno(String n, String a1, String a2) {
		this.nombre = n;
		this.apellido1 = a1;
		this.apellido2 = a2;
		this.nexpediente = (long) (Math.random() * (7) + 1);
	}

	public Alumno() {
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public List<Profesor> getProfesores() {
		return profesores_por_alumno;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores_por_alumno = profesores;
	}

	public Padre getPadre() {
		return padre_alumno;
	}

	public void setPadre(Padre padre) {
		this.padre_alumno = padre;
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

	public long getNexpediente() {
		return nexpediente;
	}

	public void setNexpediente(long n_expediente) {
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

	@Override
	public String toString() {
		return "Alumno [nexpediente=" + nexpediente + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2="
				+ apellido2 + ", faltas=" + faltas + "]";
	}

	/*
	 * FUNCIONES PROPIAS public void VerDatos() {} public void VerNotas(Asignatura
	 * a) {} public void VerFaltas(Asignatura a) {} public void VerFaltasTotales()
	 * {}
	 */
}
