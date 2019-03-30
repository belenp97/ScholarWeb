package es.urjc.etsii.dad.scholarWeb.Repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import es.urjc.etsii.dad.scholarWeb.Alumno;
import es.urjc.etsii.dad.scholarWeb.Padre;
import es.urjc.etsii.dad.scholarWeb.Usuario;


public interface AlumnoRepository extends CrudRepository<Alumno, Integer> {

	Alumno saveAndFlush(Usuario alumno);
	//Alumno insertarAlumno(String Alumno);
//	Alumno findBynexpedienteEquals(Integer id);
	Alumno findBynombreEquals(String nombre);
//	Optional<Alumno> findById(Integer nexp);
	
//	Alumno deleteByNexpediente(Integer nexp);
	
	Alumno findByid(Integer id);
	void deleteByid(Integer id);
	
}
