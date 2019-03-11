package es.urjc.etsii.dad.scholarWeb.Controllers;

import java.util.List;
import java.util.Optional;

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

import es.urjc.etsii.dad.scholarWeb.Alumno;
import es.urjc.etsii.dad.scholarWeb.Asignatura;
import es.urjc.etsii.dad.scholarWeb.Aula;
import es.urjc.etsii.dad.scholarWeb.Profesor;
import es.urjc.etsii.dad.scholarWeb.Repositories.AlumnoRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AsignaturaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AulaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.NoticiaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.PadreRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.ProfesorRepository;


@Controller
public class ProfesorController {
	
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
	
	private void modelos(Model model) {
		model.addAttribute("alumnos", reposAl.findAll());
		model.addAttribute("padres", padreRepo.findAll());
		model.addAttribute("asignaturas", asigRepo.findAll());
		model.addAttribute("noticias", notRepo.findAll());
		model.addAttribute("aulas", reposAula.findAll());
		model.addAttribute("profesores", profeRepo.findAll());
	}
	
	@RequestMapping("/profesores")
	public String verProfesores(Model model,  HttpServletRequest request) {

		modelos(model);

		return "profesores";
	}
	
	@RequestMapping("/insertar_profesor")
	public String insertar_profesor(Model model, @RequestParam String nombre,@RequestParam String apellido1,@RequestParam String apellido2, @RequestParam String correo, /*@RequestParam cont, */@RequestParam String asignatura, @RequestParam Integer id_alumno, @RequestParam Integer id_aula, @RequestParam String rol, @RequestParam String roles) {
		try {
			modelos(model);
			Optional<Aula> aula = reposAula.findById(id_aula);
			Aula aul = aula.get();
			Optional<Alumno> alumno = reposAl.findById(id_alumno);
			Alumno a = alumno.get(); 
			Asignatura asig = asigRepo.findBynombreEquals(asignatura);

			Profesor profe = profeRepo.findBycorreoEquals(correo);
			if(profe.getCorreo() != correo) {
				/*Profesor profesor = new Profesor(nombre, correo, cont, rol, roles);
				profesor.setApellido1(apellido1);
				profesor.setApellido2(apellido2);
				profeRepo.save(profesor); */
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "administrador";
	}
	
	@RequestMapping("/eliminar_profesor")
	public String eliminar_profesor(Model model, @RequestParam Integer id_profesor) {
		try {
			modelos(model);
			Optional<Profesor> profe = profeRepo.findById(id_profesor); 
			if(profe.get() != null) {
				if(profe.get().getid_profesor() == id_profesor) {
					profeRepo.deleteById(id_profesor);
				}else {
					return "administrador";
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return "administrador";
	}
	
}
