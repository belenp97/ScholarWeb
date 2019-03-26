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
import org.springframework.web.bind.annotation.RestController;

import es.urjc.etsii.dad.scholarWeb.Asignatura;
import es.urjc.etsii.dad.scholarWeb.Repositories.AlumnoRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AsignaturaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AulaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.NoticiaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.PadreRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.ProfesorRepository;

@Controller
@RequestMapping("/asignatura")
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
	
	@RequestMapping(value="/insertar_asignatura", method=RequestMethod.POST)
	public String insertar_asignatura(Model model, HttpServletRequest request, @RequestParam String nombre,@RequestParam int curso) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			model.addAttribute("token", token.getToken());
		try {
			Asignatura asignatura = new Asignatura(nombre, curso);
			Asignatura asig = asigRepo.findBynombreEquals(nombre); 
			if(asignatura != asig) {
				asigRepo.save(asignatura);
			
				model.addAttribute("nombre", asig.getNombre());
				model.addAttribute("curso", asig.getCurso());
				

				return "formularioAceptAsignatura";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "formularioError";
	}
	
	@RequestMapping(value="/eliminar_asignatura", method=RequestMethod.POST)
	public String eliminar_asignatura(Model model, HttpServletRequest request, @RequestParam Integer id) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			model.addAttribute("token", token.getToken());
			
		try {
			Asignatura asig = asigRepo.findById(id); 
		
			model.addAttribute("nombre", asig.getNombre());
			model.addAttribute("curso", asig.getCurso());
			
			asigRepo.deleteById(id);
			
			return "formularioAceptAsignatura";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "formularioError";
	}
	
}
