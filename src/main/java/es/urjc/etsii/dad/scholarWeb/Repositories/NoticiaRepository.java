package es.urjc.etsii.dad.scholarWeb.Repositories;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Noticia;

@Cacheable
public interface NoticiaRepository extends JpaRepository<Noticia, String> {

	@CacheEvict(allEntries=true)
	Noticia save(Noticia item);
	
	Noticia findBytituloEquals(String titulo);

}
