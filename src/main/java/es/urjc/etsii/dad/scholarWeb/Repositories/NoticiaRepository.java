package es.urjc.etsii.dad.scholarWeb.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Noticia;


public interface NoticiaRepository extends JpaRepository<Noticia, String> {

	Noticia saveAndFlush(Noticia item);
	Noticia findBytituloEquals(String titulo);

}
