package es.urjc.etsii.dad.scholarWeb.Controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.etsii.dad.scholarWeb.Administrador;
import es.urjc.etsii.dad.scholarWeb.Alumno;
import es.urjc.etsii.dad.scholarWeb.Asignatura;
import es.urjc.etsii.dad.scholarWeb.Usuario;
import es.urjc.etsii.dad.scholarWeb.Repositories.AdminRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AlumnoRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AsignaturaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AulaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.NoticiaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.PadreRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.ProfesorRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.UsuarioRepository;


@Controller
class LoginController {
	
	@Autowired
	private UsuarioRepository repos;
	
	@Autowired
	private AdminRepository adminrepo;
	
	@Autowired
	private ProfesorRepository proferepos;
	
	@Autowired
	private AlumnoRepository alrepos;
	
	@Autowired
	private PadreRepository padrerepos;
	
	@Autowired
	private AsignaturaRepository asigRepo;

	@Autowired
	private AulaRepository reposAula;
	
	@Autowired
	private NoticiaRepository notRepo;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model, HttpServletRequest request, HttpSession sesion) {
		
    	model.addAttribute("admin", request.isUserInRole("ADMIN"));
    	
		return "login";
	}
	
	@RequestMapping(value="/privado")
	public String loginPrivado(Model model, HttpServletRequest request) {
			 
			Usuario user = repos.findByNombre(request.getUserPrincipal().getName());
	    	
	    	model.addAttribute("admin", request.isUserInRole("ADMIN"));
	    	model.addAttribute("username", user.getNombre());
	    	
			System.out.println("El usuario logeado es: "+user.getCorreo());
			
//			sesion= request.getSession(true);
			
			model.addAttribute("administrador", request.isUserInRole("ADMIN"));
			if(request.isUserInRole("ADMIN")) {
				
				model.addAttribute("profesores", proferepos.findAll());
				model.addAttribute("alumnos", alrepos.findAll());
				model.addAttribute("padres", padrerepos.findAll());
				model.addAttribute("administrador", adminrepo.findAll());
				model.addAttribute("asignaturas", asigRepo.findAll());
				model.addAttribute("noticias", notRepo.findAll());
				model.addAttribute("aulas", reposAula.findAll());
				model.addAttribute("admin", adminrepo.findAll());
				
				return "administrador"; 
			}
			if(request.isUserInRole("PROFESOR")) {
				model.addAttribute("profesor", repos.findByRol("PROFESOR"));
			
				return "/profesor"; 
			}
			if(request.isUserInRole("PADRE")) {
				model.addAttribute("padre", repos.findByRol("PADRE"));
			
				return ""; 
			}
		
		return "loginError";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(Model model, HttpServletRequest request) {
		try {
			request.logout();
			return "/login";
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return "/";
		
	}

}
