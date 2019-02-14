package es.urjc.etsii.dad.scholarWeb.Repositories;

import org.springframework.data.repository.CrudRepository;

import es.urjc.etsii.dad.scholarWeb.Padre;

public interface PadreRepository extends CrudRepository<Padre, String> {

	Padre saveAndFlush(Padre item);

}
