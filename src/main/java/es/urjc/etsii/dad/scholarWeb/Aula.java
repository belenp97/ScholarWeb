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
	
	public Aula() {}
	
	public Aula(Integer c, Integer l) {
		
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

}
