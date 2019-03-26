package es.urjc.etsii.dad.scholarWeb.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Asignatura;


public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer>{

	Asignatura saveAndFlush(Asignatura item);
	Asignatura findBynombreEquals(String nombre);
	Asignatura findById(Integer id);
	Asignatura deleteById(Integer id);
}
