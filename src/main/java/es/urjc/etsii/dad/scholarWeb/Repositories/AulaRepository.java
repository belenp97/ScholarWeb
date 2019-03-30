package es.urjc.etsii.dad.scholarWeb.Repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Aula;

public interface AulaRepository extends JpaRepository<Aula, Integer> {
	
	Aula saveAndFlush(Aula item);
	//Integer save(Integer id, String name);
	Aula findByLetra(Character letra);
//	Aula findByCurso(Integer curso);
//	Aula BorrarAula(Integer id);
//	Optional<Aula> findByidAula(Integer idaula);
	
	Aula findByidAula(Integer id);
	void deleteByidAula(Integer id);
}
