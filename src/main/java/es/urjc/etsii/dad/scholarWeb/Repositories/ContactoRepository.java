package es.urjc.etsii.dad.scholarWeb.Repositories;

import org.springframework.data.repository.CrudRepository;

import es.urjc.etsii.dad.scholarWeb.Contacto;

public interface ContactoRepository extends CrudRepository<Contacto, String> {

	Contacto saveAndFlush(Contacto item);

}
