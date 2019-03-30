package es.urjc.etsii.dad.scholarWeb.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import es.urjc.etsii.dad.scholarWeb.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	Usuario findBycorreoEquals(String correo);

	List<Usuario> findByRol(String rol);

	Usuario findByNombre(String nombre);
	
	Usuario findByid(Integer id);
	
}
