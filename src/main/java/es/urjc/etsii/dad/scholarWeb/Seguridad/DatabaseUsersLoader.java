package es.urjc.etsii.dad.scholarWeb.Seguridad;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.urjc.etsii.dad.scholarWeb.Usuario;
import es.urjc.etsii.dad.scholarWeb.Repositories.UsuarioRepository;

@Component
public class DatabaseUsersLoader {

    @Autowired
    private UsuarioRepository userRepository;

//    @PostConstruct
//    private void initDatabase() {
//    	userRepository.save(new Usuario("Lucas", "lucas@gmail.com", "lucas", "ROLE_ADMIN", "ROLE_PROFESOR", "ROLE_PADRE"));
//    }

}
