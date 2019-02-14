package es.urjc.etsii.dad.scholarWeb.Repositories;

import org.springframework.data.repository.CrudRepository;

import es.urjc.etsii.dad.scholarWeb.Profesor;


public interface ProfesorRepository extends CrudRepository<Profesor, Integer>{

	Profesor saveAndFlush(Profesor item);

}
