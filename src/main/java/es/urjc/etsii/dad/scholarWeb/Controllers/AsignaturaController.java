package es.urjc.etsii.dad.scholarWeb.Controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@RequestMapping("/asignaturas")
	public String verAsignaturas(Model model,  HttpServletRequest request) throws Exception {

		modelos(model); 
		model.addAttribute("padres", asigRepo.findAll());

		return "padres";
	}
	
	@RequestMapping("/insertar_asignatura")
	public String insertar_asignatura(Model model, @RequestParam String nombre,@RequestParam int curso) {
		
		try {
			modelos(model);
			Asignatura asignatura = new Asignatura( nombre, curso);
			asigRepo.save(asignatura); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "administrador";
	}
	
	@RequestMapping("/eliminar_asignatura")
	public String eliminar_asignatura(Model model, @RequestParam Integer id) {
		
		try {
			modelos(model);
			asigRepo.deleteById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "administrador";
	}
	
}
