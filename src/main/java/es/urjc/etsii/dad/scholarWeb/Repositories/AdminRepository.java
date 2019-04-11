package es.urjc.etsii.dad.scholarWeb.Repositories;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Administrador;
import es.urjc.etsii.dad.scholarWeb.Noticia;

@CacheConfig(cacheNames="test")
public interface AdminRepository extends JpaRepository<Administrador, Integer>{
//	@Cacheable("test")
	List<Administrador>findAll();
	
//	@Cacheable
//	Administrador findByCorreo(String correo); 
	
//	@CacheEvict(allEntries=true)
//	Administrador save(Administrador updatedItem);

}
