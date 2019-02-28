package es.urjc.etsii.dad.scholarWeb;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.*;

@Entity
@Table(name = "asignatura")
public class Asignatura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String nombre;
	@Column
	private int curso;
	@Column
	private int notas;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "asignaturas")
	private List<Alumno> alumno = new ArrayList<Alumno>();

	@ManyToOne(targetEntity = Profesor.class, fetch = FetchType.LAZY)
	private Profesor profesor;

	public Asignatura() {
	}

	public Asignatura(String nombre, int curso) {
		this.id = (int) Math.ceil(Math.random() * 1000);
		this.nombre = nombre;
		this.curso = curso;
	}

	public Profesor getProfesorPorAsignatura() {
		return profesor;
	}

	public void setProfesorPorAsignatura(Profesor profesorPorAsignatura) {
		this.profesor = profesorPorAsignatura;
	}

	public List<Alumno> getAlumnos() {
		return alumno;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumno = alumnos;
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
