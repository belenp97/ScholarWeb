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

import es.urjc.etsii.dad.scholarWeb.Aula;
import es.urjc.etsii.dad.scholarWeb.Repositories.AlumnoRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AsignaturaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AulaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.NoticiaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.PadreRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.ProfesorRepository;

@Controller
@RequestMapping("/aula")
public class AulaController {
	
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
	
	
	@RequestMapping("/insertar_aula")
	public String insertar_aula(Model model, HttpServletRequest request, @RequestParam Integer curso,@RequestParam Character letra) {
		
		try {
			model.addAttribute("administrador", request.isUserInRole("ADMIN"));
			
			Aula a =  reposAula.findByLetra(letra);
			Aula aula = new Aula(curso,letra);
			if(a==null || a.getCurso() == curso && a.getLetra() != letra || a.getCurso() != curso && a.getLetra() == letra) {
				reposAula.save(aula);
				model.addAttribute("id", aula.getIdAula());
				model.addAttribute("curso", curso);
				model.addAttribute("letra", letra);
				return "formularioAceptAula";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "formularioError";
	}
	

}
