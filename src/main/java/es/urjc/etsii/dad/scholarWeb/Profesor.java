package es.urjc.etsii.dad.scholarWeb;

import java.io.File;
import javax.persistence.*;

@Entity
public class Profesor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer identificador;
	
	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}
	@Column
	private String nombre;
	@Column
	private String correo;
	@Column
	private File comedor;
	@OneToMany
	private Asignatura[] asignaturas;
	
	@OneToMany
	private Padre[] padres;
	
	public Profesor() {}

	public Profesor(String n, String c) {
		this.nombre= n;
		this.correo=c;
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



	public File getComedor() {
		return comedor;
	}



	public void setComedor(File comedor) {
		this.comedor = comedor;
	}



	public Asignatura[] getAsignaturas() {
		return asignaturas;
	}



	public void setAsignaturas(Asignatura[] asignaturas) {
		this.asignaturas = asignaturas;
	}

	public Padre[] getPadres() {
		return padres;
	}


	public void setPadres(Padre[] padres) {
		this.padres = padres;
	}
	

	/*FUNCIONES PROPIAS*/
	public void EnviarComedor(Padre[]  p, File f) {}
	public void EnviarCorreo(Padre[] p){}
	public void Añadir_falta(Alumno a, Asignatura as){}
	public void Subir_notas(Asignatura a){}
	public void EnviarInfoExcursiones(Padre[] p){}

}

