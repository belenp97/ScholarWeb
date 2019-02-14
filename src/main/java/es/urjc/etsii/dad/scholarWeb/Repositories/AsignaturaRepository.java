package es.urjc.etsii.dad.scholarWeb.Repositories;

import org.springframework.data.repository.CrudRepository;

import es.urjc.etsii.dad.scholarWeb.Asignatura;


public interface AsignaturaRepository extends CrudRepository<Asignatura, String>{

	Asignatura saveAndFlush(Asignatura item);

	

}
