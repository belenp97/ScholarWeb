package es.urjc.etsii.dad.scholarWeb;

import javax.persistence.*;

@Entity
public class Contacto {

	@Id
	private String nombre;
	@Column
	private int telefono;
	@Column
	private String mail;
	@Column
	private String cuerpo; 


	public Contacto() {
	}

	public Contacto(String nombre, int telefono, String mail, String cuerpo) {
		super();
		this.nombre = nombre;
		this.telefono = telefono; 
		this.mail = mail; 
		this.cuerpo = cuerpo;
	}

	public String getnombre() {
		return nombre;
	}

	public void setnombre(String nombre) {
		this.nombre = nombre;
	}

	public int gettelefono() {
		return telefono;
	}

	public void settelefono(int telefono) {
		this.telefono = telefono;
	}
	
	public String getmail() {
		return mail;
	}

	public void setmail(String mail) {
		this.mail = mail;
	}
	
	public String getcuerpo() {
		return cuerpo;
	}

	public void setcuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	@Override
	public String toString() {
		return "Anuncio [nombre=" + nombre +" telefono= "+telefono +" mail= " +mail + ", cuerpo=" + cuerpo + "]";
	}

}
