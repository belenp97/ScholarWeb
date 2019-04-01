package es.urjc.etsii.dad.scholarWeb.Repositories;


import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Aula;

@Cacheable
public interface AulaRepository extends JpaRepository<Aula, Integer> {
	
	@CacheEvict(allEntries=true)
	Aula save(Aula item);
	//Integer save(Integer id, String name);
	Aula findByLetra(Character letra);
//	Aula findByCurso(Integer curso);
//	Aula BorrarAula(Integer id);
//	Optional<Aula> findByidAula(Integer idaula);
	
	Aula findByidAula(Integer id);
	void deleteByidAula(Integer id);
}
