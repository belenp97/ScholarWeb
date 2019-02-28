package es.urjc.etsii.dad.scholarWeb.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Profesor;


public interface ProfesorRepository extends JpaRepository<Profesor, Integer>{

	Profesor saveAndFlush(Profesor item);
	Profesor findBynombreEquals(String nombre);
}
