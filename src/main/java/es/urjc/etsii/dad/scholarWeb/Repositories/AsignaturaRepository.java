package es.urjc.etsii.dad.scholarWeb.Repositories;


import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import es.urjc.etsii.dad.scholarWeb.Asignatura;

@Cacheable
public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer>{

	@CacheEvict(allEntries=true)
	Asignatura save(Asignatura item);
	
	Asignatura findBynombreEquals(String nombre);
//	void borrarAsignatura(Asignatura a);
//	void delete(Integer id);
//	Optional<Asignatura> findById(Integer idasig);
	void deleteByid(Integer id);
	Asignatura findByid(Integer id);
}
