package es.urjc.etsii.dad.scholarWeb;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
//@Table(name = "profesor")
public class Profesor extends Usuario {
	@Column
	private String apellido1;
	@Column
	private String apellido2;

	@OneToMany(mappedBy = "profesor",  targetEntity=Asignatura.class)
	private List<Asignatura> asignaturas_por_profesor = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "profesores_por_alumno", joinColumns = {
			@JoinColumn(name = "profesor") }, inverseJoinColumns = {
			@JoinColumn(name = "alumno") })
	private List<Alumno> alumnos = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "profesores_por_aula", joinColumns = { 
			@JoinColumn(name = "profesor") }, inverseJoinColumns = {
			@JoinColumn(name = "aula") })
	private List<Aula> aulas = new ArrayList<>();

	public Profesor() {
	}

	public Profesor(String nombre, String apellido, String ap2, String correo, String contraseña, String rol, String... roles) {
		super(nombre, correo, contraseña, rol, roles);
		this.apellido1=apellido;
		this.apellido2=ap2;
	}
	
	public Profesor(String n, String a1, String a2, Asignatura a, Alumno alu, Aula aul, String correo, String contraseña, String rol, String... roles) {
		super(n, correo, contraseña, rol, roles);
//		this.id_profesor =(int) Math.ceil(Math.random() * 1000);
		this.apellido1 = a1;
		this.apellido2 = a2;
		this.asignaturas_por_profesor.add(a); 
		this.alumnos.add(alu); 
		this.aulas.add(aul);
	}

	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
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


	public List<Asignatura> getAsignaturas() {
		return asignaturas_por_profesor;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas_por_profesor = asignaturas;
	}

	@Override
	public String toString() {
		return "Profesor [nombre=" + this.getNombre() + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + ", correo=" + this.getCorreo() + ", asignaturas=" + ", alumnos=" + ", aulas="
				+ "]";
	}

	/*
	 * FUNCIONES PROPIAS public void EnviarComedor(Padre[] p, File f) {} public void
	 * EnviarCorreo(Padre[] p){} public void Añadir_falta(Alumno a, Asignatura as){}
	 * public void Subir_notas(Asignatura a){} public void
	 * EnviarInfoExcursiones(Padre[] p){}
	 */

}
