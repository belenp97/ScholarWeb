package es.urjc.etsii.dad.scholarWeb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Administrador")
public class Administrador {
	@Id
	String id;
	@Column

	String nombre;
	@Column
	String apellido;
	
	public Administrador(String id) {
		super();
		this.id = id;
	}


	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getnombre() {
		return nombre;
	}



	public void setnombre(String nombre) {
		this.nombre = nombre;
	}



	public String getapellido() {
		return apellido;
	}



	public void setapellido(String apellido) {
		this.nombre = apellido;
	}


	@Override
	public String toString() {
		return "Administrador [id=" + id + "]";
	}
	
	
	
	
}
