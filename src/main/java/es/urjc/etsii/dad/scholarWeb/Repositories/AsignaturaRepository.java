package es.urjc.etsii.dad.scholarWeb.Repositories;

import org.springframework.data.repository.CrudRepository;

import es.urjc.etsii.dad.scholarWeb.Asignatura;


public interface AsignaturaRepository extends CrudRepository<Asignatura, Integer>{

	Asignatura saveAndFlush(Asignatura item);
	Asignatura findBynombreEquals(String nombre);
//	void borrarAsignatura(Asignatura a);
//	void delete(Integer id);
}
