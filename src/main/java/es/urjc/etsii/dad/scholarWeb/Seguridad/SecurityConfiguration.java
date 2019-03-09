package es.urjc.etsii.dad.scholarWeb.Seguridad;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfiguration /*extends WebSecurityConfigurerAdapter */ {
/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		 // Users
		 auth.inMemoryAuthentication().withUser("user").password("pass")
		 .roles("USER");

		 auth.inMemoryAuthentication().withUser("admin").password("adminpass")
		 .roles("USER", "ADMIN");

		 auth.inMemoryAuthentication().withUser("alumno").password("alumpass")
		 .roles("USER", "ALUMNO");

		 auth.inMemoryAuthentication().withUser("profesor").password("profpass")
		 .roles("USER","PROFESOR");

		 auth.inMemoryAuthentication().withUser("padre").password("padrepass")
		 .roles("USER","PADRE");
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
	  http.authorizeRequests().antMatchers("/css/**");
	  
	 // Private pages (all other pages)
	 http.authorizeRequests().antMatchers("/admin").hasAnyRole("ADMIN").;
	 http.authorizeRequests().antMatchers("login/pagina_alumno").hasAnyRole("ALUMNO");
	 http.authorizeRequests().antMatchers("login/pagina_profesor").hasAnyRole("PROFESOR");
	 http.authorizeRequests().antMatchers("login/pagina_padre").hasAnyRole("PADRE");
	 
	 // Login form
	 http.formLogin().loginPage("/login");
	 http.formLogin().usernameParameter("nombre");
	 http.formLogin().passwordParameter("contraseña");
	 http.formLogin().defaultSuccessUrl("/login_privado");
	 http.formLogin().failureUrl("/loginError"); 
	 
	 
	 // Logout
	 //http.logout().logoutUrl("/logout");
	 http.logout().logoutSuccessUrl("/principal");
	
	 }
*/
}
