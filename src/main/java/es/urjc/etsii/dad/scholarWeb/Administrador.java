package es.urjc.etsii.dad.scholarWeb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "administrador")
public class Administrador extends Usuario{

	@Column
	private String apellido;

	public Administrador() {

	}

	public Administrador(String nombre, String apellido, String correo, String contraseña, String... roles) {
		super(nombre, correo, contraseña, roles);
//		this.id=id; 
		this.apellido=apellido;		
	}


	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "Administrador [apellido=" + apellido + ", getNombre()=" + getNombre() + ", getCorreo()=" + getCorreo()
				+ "]";
	}

}
