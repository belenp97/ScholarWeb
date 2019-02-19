package es.urjc.etsii.dad.scholarWeb;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "profesor")
public class Profesor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long identificador;

	@Column
	private String nombre;
	@Column
	private String apellido1;
	@Column
	private String apellido2;
	@Column
	private String correo;

	@OneToMany(mappedBy = "profesor_por_asignatura",  targetEntity=Asignatura.class)
	private List<Asignatura> asignaturas_por_profesor = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "profesores_por_alumno", joinColumns = {
			@JoinColumn(name = "profesor_por_alumno") }, inverseJoinColumns = {
					@JoinColumn(name = "alumno_por_profesor") })
	private List<Alumno> alumnos_por_profesor = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "profesores_por_aula", joinColumns = { @JoinColumn(name = "profesor") }, inverseJoinColumns = {
			@JoinColumn(name = "aula") })
	private List<Aula> aulas = new ArrayList<>();

	public Profesor() {
	}

	public Profesor(String n, String a1, String a2, String c) {
		this.identificador = (long) Math.random() * 7;
		this.nombre = n;
		this.apellido1 = a1;
		this.apellido2 = a2;
		this.correo = c;
	}

	public long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public List<Alumno> getAlumnos() {
		return alumnos_por_profesor;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos_por_profesor = alumnos;
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

	public List<Asignatura> getAsignaturas() {
		return asignaturas_por_profesor;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas_por_profesor = asignaturas;
	}

	@Override
	public String toString() {
		return "Profesor [identificador=" + identificador + ", nombre=" + nombre + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + ", correo=" + correo + ", asignaturas=" + ", alumnos=" + ", aulas="
				+ "]";
	}

	/*
	 * FUNCIONES PROPIAS public void EnviarComedor(Padre[] p, File f) {} public void
	 * EnviarCorreo(Padre[] p){} public void Añadir_falta(Alumno a, Asignatura as){}
	 * public void Subir_notas(Asignatura a){} public void
	 * EnviarInfoExcursiones(Padre[] p){}
	 */

}
