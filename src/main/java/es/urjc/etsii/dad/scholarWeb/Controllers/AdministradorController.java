package es.urjc.etsii.dad.scholarWeb.Controllers;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.client.RestTemplate;

import InternalService.Mail;
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
	
	private static final String RestService = "http://127.0.0.1:8070/send"; 
	
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
	public String administrador(Model model, HttpServletRequest request, HttpSession sesion) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		
    	Usuario user = repos.findByNombre(request.getUserPrincipal().getName());
		try {
			model.addAttribute("profesores", repos.findByRol("PROFESOR"));
			model.addAttribute("alumnos", repos.findByRol("ALUMNO"));
			model.addAttribute("padres", repos.findByRol("PADRE"));
			model.addAttribute("administrador", repos.findByRol("ADMIN"));
			model.addAttribute("asignaturas", asigRepo.findAll());
			model.addAttribute("noticias", notRepo.findAll());
			model.addAttribute("aulas", reposAula.findAll());
			model.addAttribute("admin", adminrepo.findAll());
	
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
				
				RestTemplate servInterno = new RestTemplate(); 
				
				String from = "scholar.web.dad@gmail.com"; // dirección de correo remitente -> usuario Administrador
				String to = adminis.getCorreo(); // dirección del correo de destino -> nuevo usuario
				String body = "Hola " + nombre + ", has sido registrado como " + adminis.getRol() + " en Scholarweb con las siguientes credenciales: \nLogin : " + adminis.getCorreo() +"\nContraseña: " +contrasena+"\n Un saludo ScholarWeb.";
				
				// AL INVOCAR ESTE MÉTODO LE PASO COMO PARÁMETROS LA URL DEL CONTROLADOR REST Y EL CORREO QUE QUIERO ENVIAR AL DESTINATARIO
				servInterno.postForLocation(RestService, new Mail(from,from,"Alta Usuario",body));
				
				
				return "formularioAceptAdmin";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "formularioError";
	}
	
}
