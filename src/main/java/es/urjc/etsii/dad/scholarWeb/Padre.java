package es.urjc.etsii.dad.scholarWeb;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
//@Table(name ="Padre")
public class Padre extends Usuario {

	@Column
	private String apellido;
	@Column
	private String nombre;

	@OneToMany(mappedBy = "padre_alumno", targetEntity = Alumno.class)
	private List<Alumno> alumno = new ArrayList<>();

	public Padre() {
	}
	
	public Padre( String n, String a, String correo, String contraseña, String rol, String... roles) {
		super(n, correo, contraseña, rol, roles);
		this.apellido=a;
//		this.id_padre = (int) Math.ceil(Math.random() * 1000);
		
	}

	public Padre(String n, String correo, Alumno a, String ap, String contraseña, String rol, String... roles) {
		super(n,correo,contraseña,rol,roles);
//		this.id_padre = (int) Math.ceil(Math.random() * 1000);
//		this.correo = correo;
		this.apellido = ap;
		alumno.add(a); 
	}

//	public long getid_padre() {
//		return id_padre;
//	}
//
//	public void setid_padre(int id_padre) {
//		this.id_padre = id_padre;
//	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public List<Alumno> getAlumno() {
		return alumno;
	}

	public void setAlumno(List<Alumno> alumno) {
		this.alumno = alumno;
	}

//	public String getCorreo() {
//		return correo;
//	}
//
//	public void setCorreo(String correo) {
//		this.correo = correo;
//	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Padre [alumno=" + " nombre " + nombre + " apellido " + apellido + ", correo=" /*+ correo*/ + "]";
	}

	/*
	 * FUNCIONES PROPIAS public void VerDatos() {} public void VerFaltas(){} public
	 * void VerNotas(){} public void VerCorreo(){} public void VerExcursiones(){}
	 */
}
