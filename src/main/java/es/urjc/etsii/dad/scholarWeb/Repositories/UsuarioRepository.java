package es.urjc.etsii.dad.scholarWeb.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findBycorreoEquals(String correo);

	List<Usuario> findByRol(String rol);

	Usuario findByNombre(String name);
	
}
