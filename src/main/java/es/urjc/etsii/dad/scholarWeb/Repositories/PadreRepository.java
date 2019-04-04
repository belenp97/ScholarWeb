package es.urjc.etsii.dad.scholarWeb.Repositories;

import java.util.Optional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Alumno;
import es.urjc.etsii.dad.scholarWeb.Padre;
import es.urjc.etsii.dad.scholarWeb.Profesor;
import es.urjc.etsii.dad.scholarWeb.Usuario;

@CacheConfig(cacheNames="test")
public interface PadreRepository extends JpaRepository<Padre, Integer> {

	@Cacheable
	Padre findBycorreoEquals(String correo);
	
	@Cacheable
	Padre findByNombreEquals(String nombre);
	
	@Cacheable
	Padre findByid(Integer id);

	@CacheEvict(allEntries=true)
	Padre save(Usuario padre);
	
	@CacheEvict(allEntries=true)
	void deleteByid(Integer id);
	

	//void deleteById(Integer id_padre);
	//Optional<Padre> findById(Integer id_padre);
}
