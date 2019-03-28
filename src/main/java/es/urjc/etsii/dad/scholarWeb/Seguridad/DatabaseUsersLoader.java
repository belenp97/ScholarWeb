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
//    	
//    	userRepository.save(new Usuario("user", "user@gmail.com", "pass", "ROLE_ALUMNO"));
//		userRepository.save(new Usuario("admin", "admin@gmail.com", "adminpass", "ROLE_ALUMNO", "ROLE_ADMIN"));
//    }

}
