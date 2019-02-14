package es.urjc.etsii.dad.scholarWeb.Repositories;

import org.springframework.data.repository.CrudRepository;

import es.urjc.etsii.dad.scholarWeb.Alumno;


public interface AlumnoRepository extends CrudRepository<Alumno, Integer> {

	Alumno saveAndFlush(Alumno updatedItem);
	

}
