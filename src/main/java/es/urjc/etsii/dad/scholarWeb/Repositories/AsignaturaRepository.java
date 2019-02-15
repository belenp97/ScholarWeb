package es.urjc.etsii.dad.scholarWeb.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Asignatura;


public interface AsignaturaRepository extends JpaRepository<Asignatura, String>{

	Asignatura saveAndFlush(Asignatura item);

	

}
