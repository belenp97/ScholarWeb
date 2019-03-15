package es.urjc.etsii.dad.scholarWeb;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
//@Table(name ="Padre")
public class Padre extends Usuario {

	@Column
	private String apellido;

	@OneToMany(mappedBy = "padre_alumno", targetEntity = Alumno.class)
	private List<Alumno> alumno = new ArrayList<>();

	public Padre() {
	}
	
	public Padre( String n, String a, String correo, String contraseña, String rol, String... roles) {
		super(n, correo, contraseña, rol, roles);
		this.apellido=a;
//		this.id_padre = (int) Math.ceil(Math.random() * 1000);
		
	}

	public Padre(String n,String ap, String correo, Alumno a, String contraseña, String rol, String... roles) {
		super(n,correo,contraseña,rol,roles);
		this.apellido = ap;
		alumno.add(a); 
	}

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

	@Override
	public String toString() {
		return  this.getNombre() + " " +apellido ;
	}


	/*
	 * FUNCIONES PROPIAS public void VerDatos() {} public void VerFaltas(){} public
	 * void VerNotas(){} public void VerCorreo(){} public void VerExcursiones(){}
	 */
}
