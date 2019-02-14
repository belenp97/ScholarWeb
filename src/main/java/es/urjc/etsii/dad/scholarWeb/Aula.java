package es.urjc.etsii.dad.scholarWeb;

import javax.persistence.*;


@Entity
public class Aula {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAula;
	@Column
	private Integer Curso;
	@Column
	private char letra;
	
	@OneToMany (mappedBy = "Alumno")
	private Alumno[] alumnos_curso;
	@ManyToMany (mappedBy = "Profesor")
	private Profesor[] profesores_curso;
	
	public Aula(Integer c, char l) {
		this.Curso= c;
		this.letra=l;
	}
	
	public Aula(Integer c, char l, Alumno[] a, Profesor[] p) {
		this.Curso= c;
		this.letra=l;
		this.alumnos_curso=a;
		this.profesores_curso=p;
	}
	
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
	
	public Alumno[] getAlumnos_curso() {
		return alumnos_curso;
	}

	public void setAlumnos_curso(Alumno[] alumnos_curso) {
		this.alumnos_curso = alumnos_curso;
	}

	public Profesor[] getProfesores_curso() {
		return profesores_curso;
	}

	public void setProfesores_curso(Profesor[] profesores_curso) {
		this.profesores_curso = profesores_curso;
	}


}
