/*package es.urjc.etsii.dad.scholarWeb.Seguridad;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter  {

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			 throws Exception {

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
	 // Private pages (all other pages)
	 http.authorizeRequests().antMatchers("/admin").hasAnyRole("ADMIN");
	 http.authorizeRequests().antMatchers("login/alumno").hasAnyRole("ALUMNO");
	 http.authorizeRequests().antMatchers("login/profesor").hasAnyRole("PROFESOR");
	 http.authorizeRequests().antMatchers("login/padre").hasAnyRole("PADRE");
	 // Login form
	 
	 // Logout
	 
	 }

}*/
