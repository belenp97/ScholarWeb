package es.urjc.etsii.dad.scholarWeb;

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
	
	@OneToMany(mappedBy="Alumno")
	private Alumno alumno;
	
	public Padre(int id, Alumno alumno, String correo, String apellido) {
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
