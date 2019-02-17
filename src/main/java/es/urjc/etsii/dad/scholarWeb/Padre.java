package es.urjc.etsii.dad.scholarWeb;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name ="Padre")
public class Padre {
	
	@Id
	int idPadre;
	@Column
	String correo;
	@Column
	String apellido;
	@Column
	String nombre; 
	
	@OneToMany(mappedBy="padre_alumno", targetEntity=Alumno.class)
	private List<Alumno> alumno;
	
	public Padre(List<Alumno> alumno, String correo, String apellido, String nombre) {
		this.idPadre = (int)(Math.random()*(129-1)+1);
		this.alumno = alumno;
		this.correo = correo;
		this.apellido = apellido;
		this.nombre = nombre; 
	}
	
	public int getIdPadre() {
		return idPadre;
	}

	public void setIdPadre(int idPadre) {
		this.idPadre = idPadre;
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
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Padre [alumno="  +" nombre " +nombre +" apellido " + apellido + ", correo=" + correo + "]";
	}
	
	/*FUNCIONES PROPIAS
	public void VerDatos() {}
	public void VerFaltas(){}
	public void VerNotas(){}
	public void VerCorreo(){}
	public void VerExcursiones(){}*/
}
