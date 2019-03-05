package es.urjc.etsii.dad.scholarWeb.Controllers;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

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

import es.urjc.etsii.dad.scholarWeb.Alumno;
import es.urjc.etsii.dad.scholarWeb.Asignatura;
import es.urjc.etsii.dad.scholarWeb.Aula;
import es.urjc.etsii.dad.scholarWeb.Padre;
import es.urjc.etsii.dad.scholarWeb.Profesor;
import es.urjc.etsii.dad.scholarWeb.Repositories.AlumnoRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AsignaturaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AulaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.PadreRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.ProfesorRepository;


@Controller
public class AlumnoController {
	
	@Autowired
	private AlumnoRepository reposAl;
	
	@Autowired
	private AulaRepository reposAula;
	
	@Autowired
	private AsignaturaRepository asigRepo;
	
	@Autowired
	private PadreRepository padreRepo;
	
	@RequestMapping("/alumnos")
	public String verAlumnos(Model model) throws Exception {

		model.addAttribute("alumnos", reposAl.findAll());

		return "alumnos";
	}
		
	@RequestMapping("/insertar_alumno")
	public String insertar_alumno(Model model, @RequestParam String nombre,@RequestParam String apellido1, @RequestParam String apellido2, @RequestParam String nombreasig, @RequestParam Integer id) {	
		try {
			verAlumnos(model);
			Optional<Aula> aul = reposAula.findById(id);
			Asignatura asig = asigRepo.findBynombreEquals(nombreasig);
			Aula a = aul.get(); 
			Alumno alumno = new Alumno(nombre, apellido1, apellido2, asig, a);
			reposAl.save(alumno); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "administrador";
	}
		
	@RequestMapping("/eliminar_alumno" )
	public String eliminar_alumno(Model model, @RequestParam Integer nexp) {	
		try {
			verAlumnos(model);
			Optional<Alumno> alumno = reposAl.findById(nexp);
			Padre p = alumno.get().getPadre(); 
			if(p != null) {
				padreRepo.delete(p);
			}
			reposAl.deleteById(nexp); 
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "administrador";
	}
}
	
	