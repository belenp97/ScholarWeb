package es.urjc.etsii.dad.scholarWeb.Repositories;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Alumno;
import es.urjc.etsii.dad.scholarWeb.Usuario;

@Cacheable
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

	@CacheEvict(allEntries=true)
	Alumno save(Usuario alumno);
	//Alumno insertarAlumno(String Alumno);
//	Alumno findBynexpedienteEquals(Integer id);
	Alumno findBynombreEquals(String nombre);
//	Optional<Alumno> findById(Integer nexp);
	
//	Alumno deleteByNexpediente(Integer nexp);
	
	Alumno findByid(Integer id);
	void deleteByid(Integer id);
	
}
