package es.urjc.etsii.dad.scholarWeb.Repositories;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Usuario;

@CacheConfig(cacheNames="test")
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

//	@Cacheable
	List<Usuario> findAll();
	
	@Cacheable("test")
	Usuario findBycorreo(String correo);

	@Cacheable
	List<Usuario>findByRol(String rol);

	@Cacheable("test")
	Usuario findByNombre(String nombre);
	
	@Cacheable("test")
	Usuario findByid(Integer id);
	
	@CacheEvict(value="test", allEntries=true)
	Usuario save(int id);
	
}
