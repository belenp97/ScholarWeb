package es.urjc.etsii.dad.scholarWeb;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.*;

@Entity
@Table(name = "asignatura")
public class Asignatura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String nombre;
	@Column
	private int curso;
	@Column
	private int notas;

	@ManyToMany(mappedBy = "asignaturas", targetEntity=Alumno.class)
	private List<Alumno> alumno = new ArrayList<Alumno>();

	@ManyToOne(targetEntity = Profesor.class, fetch = FetchType.LAZY)
	@JoinColumn(name="profesor")
	private Profesor profesor_por_asignatura;

	public Profesor getProfesorPorAsignatura() {
		return profesor_por_asignatura;
	}

	public void setProfesorPorAsignatura(Profesor profesorPorAsignatura) {
		this.profesor_por_asignatura = profesorPorAsignatura;
	}

	public List<Alumno> getAlumnos() {
		return alumno;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumno = alumnos;
	}

	public Asignatura() {
	}

	public Asignatura(String nombre, int curso) {
		this.id = (long) (Math.random() * 7);
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
