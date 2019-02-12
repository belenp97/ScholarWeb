package es.urjc.etsii.dad.scholarWeb;

import javax.persistence.*;

@Entity
public class Padre {
	
	@Id
	String correo;
	@OneToMany
	Alumno alumno;
	
	public Padre() {}
	
	public Padre(Alumno alumno, String correo) {
		super();
		this.alumno = alumno;
		this.correo = correo;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	@Override
	public String toString() {
		return "Padre [alumno=" + alumno + ", correo=" + correo + "]";
	}
	
	/*FUNCIONES PROPIAS */
	public void VerDatos() {}
	public void VerFaltas(){}
	public void VerNotas(){}
	public void VerCorreo(){}
	public void VerExcursiones(){}
}
