package es.urjc.etsii.dad.scholarWeb.Repositories;

import java.util.Optional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Alumno;
import es.urjc.etsii.dad.scholarWeb.Profesor;

@CacheConfig(cacheNames="test")
public interface ProfesorRepository extends JpaRepository<Profesor, Integer>{

	@Cacheable
	Profesor findBynombreEquals(String nombre);
	
	@Cacheable
	Profesor findByid(Integer id);
	
	@CacheEvict(allEntries=true)
	Profesor save(Profesor item);
	
	@CacheEvict(allEntries=true)
	void deleteByid(Integer id);
	

	//Profesor findById(Integer id);
//	Profesor findBycorreoEquals(String correo);
	//Optional<Profesor> findById(Integer idprofesor);
	//void deleteById(Integer id_profesor);
	
	
}
