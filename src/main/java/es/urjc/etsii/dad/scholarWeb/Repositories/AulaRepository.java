package es.urjc.etsii.dad.scholarWeb.Repositories;

import org.springframework.data.repository.CrudRepository;

import es.urjc.etsii.dad.scholarWeb.Aula;

public interface AulaRepository extends CrudRepository<Aula, Integer> {

	Aula saveAndFlush(Aula item);

}
