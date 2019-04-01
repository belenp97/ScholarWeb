package es.urjc.etsii.dad.scholarWeb.Repositories;

import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Alumno;
import es.urjc.etsii.dad.scholarWeb.Profesor;

@Cacheable
public interface ProfesorRepository extends JpaRepository<Profesor, Integer>{

	@CacheEvict(allEntries=true)
	Profesor save(Profesor item);
	
	
	Profesor findBynombreEquals(String nombre);
	Profesor findByid(Integer id);
	void deleteByid(Integer id);
	

	//Profesor findById(Integer id);
//	Profesor findBycorreoEquals(String correo);
	//Optional<Profesor> findById(Integer idprofesor);
	//void deleteById(Integer id_profesor);
	
	
}
