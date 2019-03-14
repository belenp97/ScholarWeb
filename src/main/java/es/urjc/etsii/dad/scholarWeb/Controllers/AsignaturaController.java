package es.urjc.etsii.dad.scholarWeb.Controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import es.urjc.etsii.dad.scholarWeb.Asignatura;
import es.urjc.etsii.dad.scholarWeb.Repositories.AlumnoRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AsignaturaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AulaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.NoticiaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.PadreRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.ProfesorRepository;

@Controller
@RequestMapping("/asignaturas")
public class AsignaturaController {
	
	@Autowired
	private AlumnoRepository reposAl;
	
	@Autowired
	private PadreRepository padreRepo;
	
	@Autowired
	private AsignaturaRepository asigRepo;

	@Autowired
	private AulaRepository reposAula;
	
	@Autowired
	private ProfesorRepository profeRepo;
	
	@Autowired
	private NoticiaRepository notRepo;
	
	public void modelos(Model model) {
		model.addAttribute("alumnos", reposAl.findAll());
		model.addAttribute("padres", padreRepo.findAll());
		model.addAttribute("asignaturas", asigRepo.findAll());
		model.addAttribute("noticias", notRepo.findAll());
		model.addAttribute("aulas", reposAula.findAll());
		model.addAttribute("profesores", profeRepo.findAll());
	}
	
//	@RequestMapping("")
//	public String verAsignaturas(Model model,  HttpServletRequest request) throws Exception {
//		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
//		model.addAttribute("token", token.getToken());
//		
//		modelos(model); 
//		model.addAttribute("padres", asigRepo.findAll());
//
//		return "padres";
//	}
	
	@RequestMapping(value="/insertar_asignatura", method=RequestMethod.GET)
	public String insertar_asignatura(Model model, HttpServletRequest request, @RequestParam String nombre,@RequestParam int curso) {
		
		try {
			CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			model.addAttribute("token", token.getToken());
			
			modelos(model);
			Asignatura asignatura = new Asignatura( nombre, curso);
			asigRepo.save(asignatura); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "administrador";
	}
	
	@RequestMapping(value="/eliminar_asignatura", method=RequestMethod.GET)
	public String eliminar_asignatura(Model model, HttpServletRequest request, @RequestParam Integer id) {
		
		try {
			CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			model.addAttribute("token", token.getToken());
			
			modelos(model);
			asigRepo.deleteById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "administrador";
	}
	
}
