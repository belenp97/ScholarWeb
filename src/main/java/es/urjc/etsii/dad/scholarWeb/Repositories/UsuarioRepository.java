package es.urjc.etsii.dad.scholarWeb.Repositories;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Usuario;

@CacheConfig(cacheNames = "test")
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findBycorreoEquals(String correo);

	List<Usuario> findByRol(String rol);

	Usuario findByNombre(String nombre);
	
	Usuario findByid(Integer id);
	
	@CacheEvict(allEntries=true)
	Usuario save(Usuario u);
	
}
