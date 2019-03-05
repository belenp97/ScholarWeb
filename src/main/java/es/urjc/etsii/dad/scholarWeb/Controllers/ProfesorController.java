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
import es.urjc.etsii.dad.scholarWeb.Profesor;
import es.urjc.etsii.dad.scholarWeb.Repositories.AlumnoRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AsignaturaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AulaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.ProfesorRepository;


@Controller
public class ProfesorController {
	
	@Autowired
	private ProfesorRepository profeRepo;
	
	@Autowired
	private AulaRepository reposAula;
	
	@Autowired
	private AlumnoRepository reposAl;
	
	@Autowired
	private AsignaturaRepository asigRepo;

	@RequestMapping("/profesores")
	public String verProfesores(Model model) {

		model.addAttribute("profe", profeRepo.findAll());

		return "profesores";
	}
	
	@RequestMapping("/insertar_profesor")
	public String insertar_profesor(Model model, @RequestParam String nombre,@RequestParam String apellido1,@RequestParam String apellido2, @RequestParam String correo, @RequestParam String asignatura, @RequestParam Integer id_alumno, @RequestParam Integer id_aula) {
		try {
			verProfesores(model);
			Optional<Aula> aula = reposAula.findById(id_aula);
			Aula aul = aula.get();
			Optional<Alumno> alumno = reposAl.findById(id_alumno);
			Alumno a = alumno.get(); 
			Asignatura asig = asigRepo.findBynombreEquals(asignatura);
			Profesor profesor = new Profesor( nombre, apellido1, apellido2, correo, asig, a, aul);
			profeRepo.save(profesor); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "administrador";
	}
	
	@RequestMapping("/eliminar_profesor")
	public String eliminar_profesor(Model model, @RequestParam Integer id_profesor) {
		try {
			verProfesores(model);
			profeRepo.deleteById(id_profesor);
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return "administrador";
	}
	
}
