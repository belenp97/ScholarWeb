package es.urjc.etsii.dad.scholarWeb.Repositories;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Noticia;

@CacheConfig(cacheNames="test")
public interface NoticiaRepository extends JpaRepository<Noticia, String> {

	@Cacheable("test")
	List<Noticia> findAll();
	
	@Cacheable("test")
	Noticia findBytituloEquals(String titulo);
	
	@CacheEvict(value="test", allEntries=true)
	Noticia save(Noticia item);

	@CacheEvict(value="test", allEntries=true)
	void delete(Noticia noticia);
}
