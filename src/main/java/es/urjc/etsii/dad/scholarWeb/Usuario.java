package es.urjc.etsii.dad.scholarWeb;

import java.util.ArrayList;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.context.annotation.SessionScope;

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
@SessionScope
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
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
	
	public Usuario(String nombre,String correo, String pass, String... roles) {
		this.nombre = nombre;
		this.correo = correo;
		//this.pass = pass;
		this.pass = new BCryptPasswordEncoder().encode(pass);
		this.roles = new ArrayList<>(Arrays.asList(roles));
	}
	
	public Usuario(Integer id, String nombre,String correo, String pass, String... roles) {
		this.id = id; 
		this.nombre = nombre;
		this.correo = correo;
		//this.pass = pass;
		this.pass = new BCryptPasswordEncoder().encode(pass);
		this.roles = new ArrayList<>(Arrays.asList(roles));
	}
	
	/** Métodos de acceso a atributos de Usuario**/
	
	public Integer getId() {
		if(id == null) {
			id = (int) Math.random()*100; 
		}
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
