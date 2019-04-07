package es.urjc.etsii.dad.scholarWeb.Repositories;


import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Aula;

@CacheConfig(cacheNames="test")
public interface AulaRepository extends JpaRepository<Aula, Integer> {
	
	@Cacheable
	Aula findByLetra(Character letra);
	
	@Cacheable
	Aula findByidAula(Integer id);
	
	@CacheEvict(allEntries=true)
	Aula save(Aula item);
	
	@CacheEvict(allEntries=true)
	void deleteByidAula(Integer id);
	
	
	
}
