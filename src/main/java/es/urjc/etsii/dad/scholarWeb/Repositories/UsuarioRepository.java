package es.urjc.etsii.dad.scholarWeb.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findBycorreoEquals(String correo);
}
