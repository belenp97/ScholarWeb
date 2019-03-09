package es.urjc.etsii.dad.scholarWeb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "administrador")
public class Administrador extends Usuario{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	@Column
	private String apellido;

	public Administrador() {

	}

	public Administrador(Integer id, String nombre, String apellido, String correo, String contraseña, String rol/*, String... roles*/) {
		super(nombre, correo, contraseña, rol/*, roles*/);
		this.id=id; 
		this.apellido=apellido;		
	}


	public long getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "Administrador [id=" + id + "]";
	}

}
