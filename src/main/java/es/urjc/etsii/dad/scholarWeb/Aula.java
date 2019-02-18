package es.urjc.etsii.dad.scholarWeb;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name ="aula")
public class Aula {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAula;
	@Column
	private Integer Curso;
	@Column
	private char letra;
	
	@OneToMany (mappedBy = "aula")
	private List<Alumno> alumnos_curso = new ArrayList<>();
	
	@ManyToMany (targetEntity = Profesor.class)
	@JoinTable(name = "aula_profesores_curso", joinColumns = { @JoinColumn(name = "aulas") },
    inverseJoinColumns = { @JoinColumn(name = "profesores_curso") })
	
	private List<Profesor> profesores_curso = new ArrayList<>();
	
	public Aula(Integer c, char l) {
		this.Curso= c;
		this.letra=l;
	}
	
	public Aula(Integer c, char l, List<Alumno> a, List<Profesor> p) {
		this.Curso= c;
		this.letra=l;
		this.alumnos_curso=a;
		this.profesores_curso=p;
	}
	
	public Aula() {}
	
	public Integer getIdAula() {
		return idAula;
	}

	public void setIdAula(Integer idAula) {
		this.idAula = idAula;
	}

	public Integer getCurso() {
		return Curso;
	}

	public void setCurso(Integer curso) {
		Curso = curso;
	}

	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}
	
	public List<Alumno> getAlumnos_curso() {
		return alumnos_curso;
	}

	public void setAlumnos_curso(List<Alumno> alumnos_curso) {
		this.alumnos_curso = alumnos_curso;
	}

	public List<Profesor> getProfesores_curso() {
		return profesores_curso;
	}

	public void setProfesores_curso(List<Profesor> profesores_curso) {
		this.profesores_curso = profesores_curso;
	}

	@Override
	public String toString() {
		return "Aula [idAula=" + idAula + ", Curso=" + Curso + ", letra=" + letra + ", alumnos_curso=" + alumnos_curso
				+ ", profesores_curso=" + profesores_curso + "]";
	}
	
	


}
