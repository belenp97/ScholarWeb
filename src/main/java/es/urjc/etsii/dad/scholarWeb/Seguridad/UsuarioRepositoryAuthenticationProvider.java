package es.urjc.etsii.dad.scholarWeb.Seguridad;
import java.util.List;

import javax.transaction.Transactional;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class UsuarioRepositoryAuthenticationProvider /*implements AuthenticationProvider*/ {

/*	@Autowired
	private UsuarioService userService;
	
	@Override
	@Transactional
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		// TODO Auto-generated method stub
		
		// Cargamos el usuario de la Base de Datos
		Usuario user = userService.findByLogin(auth.getName());
		System.out.println(auth.getDetails().toString());
		
		if(user == null) {
			throw new BadCredentialsException("User not found");
		}
		
		String password = (String) auth.getCredentials();
		if(!new BCryptPasswordEncoder().matches(password, user.getPass())) {
			throw new BadCredentialsException("Wrong password");
		}
		
		List<GrantedAuthority> roles = new ArrayList<>();
		for(String role : user.getRoles()) {
			roles.add(new SimpleGrantedAuthority(role));
		}
	
		return new UsernamePasswordAuthenticationToken(user.getLogin(),password,roles);
	
	}

	@Override
	public boolean supports(Class<?> authenticationObject) {
		// TODO Auto-generated method stub
		return true;
	}

	*/
}
