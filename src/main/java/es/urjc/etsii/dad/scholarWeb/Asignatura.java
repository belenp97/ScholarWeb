package es.urjc.etsii.dad.scholarWeb;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.*;

@Entity
@Table(name ="asignatura")
public class Asignatura{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	@Column
	private String nombre;
	@Column
	private int curso;
	@Column
	private int notas;
	
	@ManyToMany(targetEntity=Alumno.class, cascade = CascadeType.ALL)
	@JoinTable(name = "asignatura_alumno", joinColumns = { @JoinColumn(name = "alumno") },
    inverseJoinColumns = { @JoinColumn(name = "asignaturas") })
	
	private List<Alumno> alumno = new ArrayList<Alumno>();
	
	@ManyToOne
	private Profesor profesorPorAsignatura;
	
	
	public Profesor getProfesorPorAsignatura() {
		return profesorPorAsignatura;
	}

	public void setProfesorPorAsignatura(Profesor profesorPorAsignatura) {
		this.profesorPorAsignatura = profesorPorAsignatura;
	}

	public List<Alumno> getAlumnos() {
		return alumno;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumno = alumnos;
	}

	public Asignatura() {}
	
	public Asignatura(String nombre, int curso) {
		this.id= (long)(Math.random()*7);
		this.nombre = nombre;
		this.curso = curso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCurso() {
		return curso;
	}
	public void setCurso(int curso) {
		this.curso = curso;
	}
	public int getNotas() {
		return notas;
	}
	public void setNotas(int notas) {
		this.notas = notas;
	}
	
	
	@Override
	public String toString() {
		return "Asignatura [nombre=" + nombre + ", curso=" + curso + ", notas=" + notas + "]";
	}
	
	
}
