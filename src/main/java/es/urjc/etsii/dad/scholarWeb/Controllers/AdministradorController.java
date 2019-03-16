package es.urjc.etsii.dad.scholarWeb.Controllers;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.etsii.dad.scholarWeb.Administrador;
import es.urjc.etsii.dad.scholarWeb.Alumno;
import es.urjc.etsii.dad.scholarWeb.Asignatura;
import es.urjc.etsii.dad.scholarWeb.Aula;
import es.urjc.etsii.dad.scholarWeb.Profesor;
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
@RequestMapping("/administrador")
public class AdministradorController {	
	
	@Autowired
	private UsuarioRepository repos;
	
	@Autowired
	private AdminRepository adminrepo;
	
	@Autowired
	private AsignaturaRepository asigRepo;

	@Autowired
	private AulaRepository reposAula;
	
	
	@Autowired
	private NoticiaRepository notRepo;
		
	@RequestMapping("")
	public String administrador(Model model, HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		try {
			model.addAttribute("profesores", repos.findByRol("PROFESOR"));
			model.addAttribute("alumnos", repos.findByRol("ALUMNO"));
			model.addAttribute("padres", repos.findByRol("PADRE"));
			model.addAttribute("admin", request.isUserInRole("ADMIN"));
			model.addAttribute("asignaturas", asigRepo.findAll());
			model.addAttribute("noticias", notRepo.findAll());
			model.addAttribute("aulas", reposAula.findAll());
	
			return "administrador";
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "formularioError";
	}
	
	@RequestMapping("/insertar_admin")
	public String insertar_admin(Model model, HttpServletRequest request, @RequestParam String nombre,@RequestParam String apellido) {
			CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			model.addAttribute("token", token.getToken());
			
			String correo = nombre.toLowerCase() +"." +apellido.toLowerCase() +"@gmail.com"; 
			String contrasena = "@" +nombre.toLowerCase() +"." +apellido.toLowerCase() +"_";
			
		try {	
			Administrador admin = adminrepo.findByCorreo(correo);
			if(admin ==null || admin.getCorreo() != correo) {
				
				Usuario adminis = (Administrador) new Administrador(nombre, apellido,correo,contrasena, "ADMIN", "ADMIN");
				adminrepo.saveAndFlush((Administrador) adminis);
				
				model.addAttribute("id", adminis.getId()); 
				model.addAttribute("nombre", adminis.getNombre() +" " +((Administrador) adminis).getApellido() +" " ); 
				model.addAttribute("correo", adminis.getCorreo() +" " ); 
				
//				profeRepo.save(profesor);
				
				return "formularioAceptAdmin";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "formularioError";
	}
	
}
