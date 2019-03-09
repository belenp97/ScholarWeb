package es.urjc.etsii.dad.scholarWeb;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "alumnos")
public class Alumno extends Usuario{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int nexpediente;
	
	@Column(nullable=false)
	private String apellido1;
	@Column(nullable=false)
	private String apellido2;
	@Column
	private int faltas;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "Alumno_asignaturas",
			joinColumns = { @JoinColumn(name = "alumnos") },
			inverseJoinColumns = { @JoinColumn(name = "asignaturas") })
	private List<Asignatura> asignaturas = new ArrayList<>();

	@ManyToMany(mappedBy = "alumnos", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Profesor> profesores = new ArrayList<>();

	@ManyToOne(targetEntity = Aula.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "aula", nullable = false)
	private Aula aula;

	@ManyToOne(targetEntity = Padre.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "padre")
	private Padre padre_alumno;

	public Alumno(String nombre, String a1, String a2, String correo, String contraseña, String rol, String... roles) {
		super(nombre, correo, contraseña, rol, roles);
		this.apellido1 = a1;
		this.apellido2 = a2;
		this.nexpediente = (int)Math.floor(Math.random()) *1+1000;
	}
	
	
	public Alumno(String n, String a1, String a2, Asignatura asig, Aula aula,String correo, String contraseña, String rol, String... roles) {
		super(n, correo, contraseña, rol, roles);
		this.apellido1 = a1;
		this.apellido2 = a2;
		this.nexpediente = (int)Math.floor(Math.random()) *1+1000;
		this.asignaturas.add(asig);  
		this.aula = aula; 
		this.padre_alumno = null; 
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
		return profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}

	public Padre getPadre() {
		return padre_alumno;
	}

	public void setPadre(Padre padre) {
		this.padre_alumno = padre;
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

	public void setNexpediente(int n_expediente) {
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
	
	public Padre getPadre_alumno() {
		return padre_alumno;
	}

	public void setPadre_alumno(Padre padre_alumno) {
		this.padre_alumno = padre_alumno;
	}

	@Override
	public String toString() {
		return "Alumno [nexpediente=" + nexpediente + ", nombre=" + this.getNombre() + ", apellido1=" + apellido1 + ", apellido2="
				+ apellido2 + ", faltas=" + faltas + "]";
	}

	/*
	 * FUNCIONES PROPIAS public void VerDatos() {} public void VerNotas(Asignatura
	 * a) {} public void VerFaltas(Asignatura a) {} public void VerFaltasTotales()
	 * {}
	 */
}
