package es.urjc.etsii.dad.scholarWeb.Repositories;

import org.springframework.data.repository.CrudRepository;

import es.urjc.etsii.dad.scholarWeb.Noticia;


public interface NoticiaRepository extends CrudRepository<Noticia, String> {

	Noticia saveAndFlush(Noticia item);

}
