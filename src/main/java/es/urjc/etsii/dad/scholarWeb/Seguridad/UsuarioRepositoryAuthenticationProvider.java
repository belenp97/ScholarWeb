package es.urjc.etsii.dad.scholarWeb.Seguridad;
import java.util.List;

import javax.transaction.Transactional;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.mysql.cj.conf.PropertySet;
import com.mysql.cj.exceptions.ExceptionInterceptor;
import com.mysql.cj.protocol.AuthenticationProvider;
import com.mysql.cj.protocol.Protocol;
import com.mysql.cj.protocol.ServerSession;

import es.urjc.etsii.dad.scholarWeb.Usuario;
import es.urjc.etsii.dad.scholarWeb.Repositories.UsuarioRepository;

@Component
public class UsuarioRepositoryAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		// TODO Auto-generated method stub
		
		// Cargamos el usuario de la Base de Datos
		Usuario user = usuarioRepository.findBycorreoEquals(auth.getName());
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
	
		return new UsernamePasswordAuthenticationToken(user.getCorreo(),password,roles);
	
	}

	@Override
	public void init(Protocol prot, PropertySet propertySet, ExceptionInterceptor exceptionInterceptor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connect(ServerSession serverSession, String userName, String password, String database) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeUser(ServerSession serverSession, String userName, String password, String database) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getEncodingForHandshake() {
		// TODO Auto-generated method stub
		return null;
	}

}
