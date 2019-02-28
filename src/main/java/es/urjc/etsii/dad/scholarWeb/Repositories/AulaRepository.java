package es.urjc.etsii.dad.scholarWeb.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Aula;

public interface AulaRepository extends JpaRepository<Aula, Integer> {
	
	Aula saveAndFlush(Aula item);

}
