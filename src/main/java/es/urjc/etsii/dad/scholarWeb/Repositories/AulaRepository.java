package es.urjc.etsii.dad.scholarWeb.Repositories;


import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Aula;

@CacheConfig(cacheNames="test")
public interface AulaRepository extends JpaRepository<Aula, Integer> {
	
//	@Cacheable("test")
	Aula findByLetra(Character letra);
	
//	@Cacheable("test")
	Aula findByidAula(Integer id);
	
//	@CacheEvict(value="test", allEntries=true)
	Aula save(Aula item);
	
//	@CacheEvict(value="test", allEntries=true)
	void deleteByidAula(Integer id);
	
	
	
}
