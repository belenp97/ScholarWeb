package es.urjc.etsii.dad.scholarWeb;

import java.util.ArrayList;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String nombre;
	@Column
	private String correo;
	@Column
	private String pass;
	@Column
	private String rol;
	
	/*Parte de seguridad*/
	@ElementCollection(fetch=FetchType.EAGER)
	private List<String> roles;
	
	/** Constuctores de Entidad **/
	
	public Usuario() {
		
	}
	
	public Usuario(String nombre,String correo, String pass,String rol, String... roles) {
		this.nombre = nombre;
		this.correo = correo;
		//this.pass = pass;
		this.pass = new BCryptPasswordEncoder().encode(pass);
		this.rol = rol;
		this.roles = new ArrayList<>(Arrays.asList(roles));
	}
	
	/** Métodos de acceso a atributos de Usuario**/
	
	public long getId() {
		return id;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public List<String> getRoles() {
		return roles;
	}
	
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	
	@Override
	public String toString() {
		return "Usuario: " + id +" [nombre: " + nombre + ", correo: " + correo +", roles: " + Arrays.toString(roles.toArray()) + ", contraseña: " + pass +"]";
	}
	
	/** Operaciones de Usuario **/
	
	/** Públicas **/
	
	/** Protegídas || Privadas **/
}
