package es.urjc.etsii.dad.scholarWeb.Repositories;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Alumno;
import es.urjc.etsii.dad.scholarWeb.Noticia;
import es.urjc.etsii.dad.scholarWeb.Usuario;

@CacheConfig(cacheNames="test")
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

	@Cacheable
	List<Alumno> findAll();
	
//	@Cacheable
	Alumno findBynombre(String nombre);
	
//	@Cacheable
	Alumno findByid(Integer id);
	
//	@CacheEvict(allEntries=true)
//	void deleteByid(Integer id);
	
//	@CacheEvict(allEntries=true)
//	Alumno save(Usuario alumno);
	
}
