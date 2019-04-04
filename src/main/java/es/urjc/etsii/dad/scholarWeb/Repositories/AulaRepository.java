package es.urjc.etsii.dad.scholarWeb.Repositories;


import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Aula;

@CacheConfig(cacheNames="test")
public interface AulaRepository extends JpaRepository<Aula, Integer> {
	
	/*@Cacheable
	List<Aula> findAll();*/
	
	@Cacheable
	Aula findByLetra(Character letra);
	
	@Cacheable
	Aula findByidAula(Integer id);
	
	
	@CacheEvict(allEntries=true)
	Aula save(Aula item);
	//Integer save(Integer id, String name);
	
	@CacheEvict(allEntries=true)
	void deleteByidAula(Integer id);
	
//	Aula findByCurso(Integer curso);
//	Aula BorrarAula(Integer id);
//	Optional<Aula> findByidAula(Integer idaula);
	
	
}
