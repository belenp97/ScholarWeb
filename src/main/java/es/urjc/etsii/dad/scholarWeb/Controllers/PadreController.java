package es.urjc.etsii.dad.scholarWeb.Controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.etsii.dad.scholarWeb.Alumno;
import es.urjc.etsii.dad.scholarWeb.Padre;
import es.urjc.etsii.dad.scholarWeb.Profesor;
import es.urjc.etsii.dad.scholarWeb.Usuario;
import es.urjc.etsii.dad.scholarWeb.Repositories.AlumnoRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AsignaturaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AulaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.NoticiaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.PadreRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.ProfesorRepository;

@Controller
@RequestMapping("/padre")
public class PadreController {
	
	@Autowired
	private AlumnoRepository reposAl;
	
	@Autowired
	private AulaRepository reposAula;
	
	@Autowired
	private PadreRepository padreRepo;
	
	@Autowired
	private AsignaturaRepository asigRepo;
	
	@Autowired
	private NoticiaRepository notRepo;
	
	@Autowired
	private ProfesorRepository profeRepo;
	
	
//	private void modelos(Model model) {
//		model.addAttribute("alumnos", reposAl.findAll());
//		model.addAttribute("padres", padreRepo.findAll());
//		model.addAttribute("asignaturas", asigRepo.findAll());
//		model.addAttribute("noticias", notRepo.findAll());
//		model.addAttribute("aulas", reposAula.findAll());
//		model.addAttribute("profesores", profeRepo.findAll());
//	}
	
//	@RequestMapping(value="", method=RequestMethod.GET)
//	public String verPadres(Model model,  HttpServletRequest request) throws Exception {
//		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
//		model.addAttribute("token", token.getToken());
//		
//		modelos(model);
//
//		return "padres";
//	}

	@RequestMapping(value="/insertar_padre", method=RequestMethod.GET)
	public String insertar_padre(Model model, HttpServletRequest request,  @RequestParam String nombre,@RequestParam String apellido, @RequestParam String correo, @RequestParam Integer idalumno , @RequestParam String contraseña, @RequestParam String rol, @RequestParam String... roles) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		try {
			
//			modelos(model);
			Optional<Alumno> a= reposAl.findById(idalumno);
			Padre pa = padreRepo.findBycorreoEquals(correo); 
			if(pa.getCorreo() == correo) {
				Usuario padre = (Padre)new Padre(nombre,apellido,correo, contraseña, rol, roles);
				a.get().setPadre((Padre) padre);
				padreRepo.saveAndFlush(padre); 
				
				model.addAttribute("id_padre", padre.getId()); 
				model.addAttribute("nombrePadre", padre.getNombre() +" " +((Padre) padre).getApellido() +" ") ; 
				model.addAttribute("correo", padre.getCorreo()); 
				model.addAttribute("alumnos", ((Padre) padre).getAlumno().toString()); 
				
				return "formularioAceptadoPadre";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return "formularioError";
	}
	
	@RequestMapping(value="/eliminar_padre", method=RequestMethod.GET)
	public String eliminar_padre(Model model,HttpServletRequest request, @RequestParam Integer id_padre){
		try {
			CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			model.addAttribute("token", token.getToken());
//			modelos(model);
			Optional<Padre> padre = padreRepo.findById(id_padre); 
			
			if(id_padre > 0) {
				padreRepo.deleteById(id_padre);
				model.addAttribute("id_padre", padre.get().getId()); 
				model.addAttribute("nombrePadre", padre.get().getNombre() +" " +((Padre) padre.get()).getApellido() +" "); 
				model.addAttribute("correo", padre.get().getCorreo()); 
				model.addAttribute("alumnos", ((Padre) padre.get()).getAlumno().toString()); 
				
				return "formularioAceptPadre";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "formularioError";
	}
	
}
