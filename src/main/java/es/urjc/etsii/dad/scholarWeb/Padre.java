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
	
	@OneToMany(mappedBy="padre_alumno", targetEntity=Alumno.class)
	private List<Alumno> alumno;
	
	public Padre(int id, List<Alumno> alumno, String correo, String apellido) {
		super();
		this.idPadre = id;
		this.alumno = alumno;
		this.correo = correo;
		this.apellido = apellido;
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
	
	
	@Override
	public String toString() {
		return "Padre [alumno="  + ", correo=" + correo + "]";
	}
	
	/*FUNCIONES PROPIAS
	public void VerDatos() {}
	public void VerFaltas(){}
	public void VerNotas(){}
	public void VerCorreo(){}
	public void VerExcursiones(){}*/
}
