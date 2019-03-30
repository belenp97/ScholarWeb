package es.urjc.etsii.dad.scholarWeb.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Alumno;
import es.urjc.etsii.dad.scholarWeb.Profesor;


public interface ProfesorRepository extends JpaRepository<Profesor, Integer>{

	Profesor saveAndFlush(Profesor item);
	Profesor findBynombreEquals(String nombre);
	//Profesor findById(Integer id);
//	Profesor findBycorreoEquals(String correo);
	//Optional<Profesor> findById(Integer idprofesor);
	//void deleteById(Integer id_profesor);
	
	Profesor findByid(Integer id);
	void deleteByid(Integer id);
}
