package es.urjc.etsii.dad.scholarWeb.Repositories;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Administrador;

@CacheConfig(cacheNames="test")
public interface AdminRepository extends JpaRepository<Administrador, Integer>{
	
	@Cacheable
	Administrador findByCorreo(String correo); 
	
	@Cacheable
	List<Administrador> findAll();
	
	@CacheEvict(allEntries=true)
	Administrador save(Administrador updatedItem);

}
