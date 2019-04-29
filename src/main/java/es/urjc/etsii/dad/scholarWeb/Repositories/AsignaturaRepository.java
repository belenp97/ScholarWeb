package es.urjc.etsii.dad.scholarWeb.Repositories;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Asignatura;
import es.urjc.etsii.dad.scholarWeb.Noticia;
import es.urjc.etsii.dad.scholarWeb.Profesor;

@CacheConfig(cacheNames="test")
public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer>{

//	@Cacheable
	List<Asignatura> findAll();
	
//	@Cacheable
	Asignatura findBynombreEquals(String nombre);
	
//	@Cacheable
	Asignatura findByid(Integer id);
	
//	@Cacheable
	void delete(Integer id);

//	@CacheEvict(allEntries=true)
	Asignatura save(Asignatura item);
	
//	List<Asignatura> findByUsuario(Usuario usuario);
	
//	void borrarAsignatura(Asignatura a);
//	void delete(Integer id);
//	Optional<Asignatura> findById(Integer idasig);
	
}
