package es.urjc.etsii.dad.scholarWeb.Repositories;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Administrador;

@Cacheable
public interface AdminRepository extends JpaRepository<Administrador, Integer>{
	
	@CacheEvict(allEntries=true)
	Administrador save(Administrador updatedItem);
	Administrador findByCorreo(String correo); 

}
