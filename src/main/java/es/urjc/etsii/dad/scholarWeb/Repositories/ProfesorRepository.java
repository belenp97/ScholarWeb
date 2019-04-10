package es.urjc.etsii.dad.scholarWeb.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Alumno;
import es.urjc.etsii.dad.scholarWeb.Noticia;
import es.urjc.etsii.dad.scholarWeb.Profesor;

@CacheConfig(cacheNames="test")
public interface ProfesorRepository extends JpaRepository<Profesor, Integer>{

//	@Cacheable("test")
	List<Profesor>findAll();
	
//	@Cacheable("test")
	Profesor findBynombreEquals(String nombre);
	
//	@Cacheable("test")
	Profesor findByid(Integer id);
	
//	@CacheEvict(allEntries=true)
//	Profesor save(Profesor item);
	
//	@CacheEvict(allEntries=true)
//	void delete(Integer id);

}
