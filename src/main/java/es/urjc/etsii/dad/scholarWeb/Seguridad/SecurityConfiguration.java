package es.urjc.etsii.dad.scholarWeb.Seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	public UsuarioRepositoryAuthenticationProvider authenticationProvider;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// Users
//		 auth.inMemoryAuthentication().withUser("user").password("pass")
//		 .roles("USER");
//
//		 auth.inMemoryAuthentication().withUser("admin").password("adminpass")
//		 .roles("USER", "ADMIN");
//
//
//		 auth.inMemoryAuthentication().withUser("profesor").password("profpass")
//		 .roles("USER","PROFESOR");
//
//		 auth.inMemoryAuthentication().withUser("padre").password("padrepass")
//		 .roles("USER","PADRE");
//		 
		// Database authentication provider,
		auth.authenticationProvider(authenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// Public pages
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/noticias").permitAll();
		http.authorizeRequests().antMatchers("/profesores").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/contacto").permitAll();
		http.authorizeRequests().antMatchers("/principal").permitAll();
//	  http.authorizeRequests().antMatchers("/administrador").permitAll();
		http.authorizeRequests().antMatchers("/css/**");

		// Private pages (all other pages)
//		http.authorizeRequests().anyRequest().authenticated();
		http.authorizeRequests().antMatchers("/administrador").hasRole("ADMIN");
//	 http.authorizeRequests().antMatchers("pagina_profesor").hasAnyRole("PROFESOR");
//	 http.authorizeRequests().antMatchers("pagina_padre").hasAnyRole("PADRE");

		// Login form
		http.formLogin().loginPage("/login");
		http.formLogin().usernameParameter("nombre");
		http.formLogin().passwordParameter("contraseña");
		http.formLogin().defaultSuccessUrl("/login_privado");
		http.formLogin().defaultSuccessUrl("/administrador");
		http.formLogin().failureUrl("/loginError");

		// Logout
		http.logout().logoutUrl("/logout");
		http.logout().logoutSuccessUrl("/");

		// deshabilitamos CSRF por el momento.
//	 http.csrf().disable();

	}

}
