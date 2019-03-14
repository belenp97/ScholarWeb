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

import es.urjc.etsii.dad.scholarWeb.Alumno;
import es.urjc.etsii.dad.scholarWeb.Asignatura;
import es.urjc.etsii.dad.scholarWeb.Aula;
import es.urjc.etsii.dad.scholarWeb.Profesor;
import es.urjc.etsii.dad.scholarWeb.Usuario;
import es.urjc.etsii.dad.scholarWeb.Repositories.AlumnoRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AsignaturaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AulaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.NoticiaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.PadreRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.ProfesorRepository;


@Controller
@RequestMapping("/profesor")
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
	
//	private void modelos(Model model) {
//		model.addAttribute("alumnos", reposAl.findAll());
//		model.addAttribute("padres", padreRepo.findAll());
//		model.addAttribute("asignaturas", asigRepo.findAll());
//		model.addAttribute("noticias", notRepo.findAll());
//		model.addAttribute("aulas", reposAula.findAll());
//		model.addAttribute("profesores", profeRepo.findAll());
//	}
	
//	@RequestMapping(value="", method=RequestMethod.GET)
//	public String verProfesores(Model model, HttpServletRequest request) {
//		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
//		model.addAttribute("token", token.getToken());
//		modelos(model);
//
//		return "profesores";
//	}
	
	@RequestMapping(value="/insertar_profesor", method=RequestMethod.GET)
	public String insertar_profesor(Model model, HttpServletRequest request, @RequestParam String nombre,@RequestParam String apellido1,@RequestParam String apellido2, /*@RequestParam String correo, @RequestParam cont, */@RequestParam String asignatura, @RequestParam Integer id_alumno, @RequestParam Integer id_aula, @RequestParam String rol, @RequestParam String roles) {
		try {
//			modelos(model);
			CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			model.addAttribute("token", token.getToken());
			
			String correo = nombre.toLowerCase().charAt(0) +"" +apellido1.toLowerCase().charAt(0) +"" + apellido2.toLowerCase().charAt(0) +"" +"@gmail.com"; 
			
			Optional<Aula> aula = reposAula.findById(id_aula);
			Optional<Alumno> alumno = reposAl.findById(id_alumno);
			Asignatura asig = asigRepo.findBynombreEquals(asignatura);
			Profesor profe = profeRepo.findBynombreEquals(nombre);  
			if(profe ==null || profe.getCorreo() != correo) {
				
				Usuario profesor = (Profesor) new Profesor(nombre, apellido1, apellido2, asig, alumno.get(), aula.get(),correo, null, null);
				profeRepo.saveAndFlush((Profesor) profesor);
				
				model.addAttribute("id_profesor", profesor.getId()); 
				model.addAttribute("nombreProfe", profesor.getNombre() +" " +((Profesor) profesor).getApellido1() +" " +((Profesor) profesor).getApellido2() +" "); 
				model.addAttribute("correo", profesor.getCorreo()); 
				model.addAttribute("alumnos", ((Profesor) profesor).getAlumnos().toString()); 
				model.addAttribute("asignatura", ((Profesor) profesor).getAsignaturas().toString()); 
				
//				profeRepo.save(profesor);
				
				return "formularioAceptadoProfe";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "formularioError";
	}
	
	@RequestMapping(value="/eliminar_profesor", method=RequestMethod.GET)
	public String eliminar_profesor(Model model, HttpServletRequest request, @RequestParam Integer id_profesor) {
		try {
			CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			model.addAttribute("token", token.getToken());
//			modelos(model);
			Optional<Profesor> profe = profeRepo.findById(id_profesor); 
			if(profe.get() != null) {
				if(profe.get().getId() == id_profesor) {
					
					model.addAttribute("id_profesor", profe.get().getId()); 
					model.addAttribute("nombreProfe", profe.get().getNombre() +" " +((Profesor) profe.get()).getApellido1() +" " +((Profesor) profe.get()).getApellido2() +" "); 
					model.addAttribute("correo", profe.get().getCorreo()); 
					model.addAttribute("alumnos", ((Profesor) profe.get()).getAlumnos().toString()); 
					model.addAttribute("asignatura", ((Profesor) profe.get()).getAsignaturas().toString()); 
					profeRepo.deleteById(id_profesor);
					
					return "formularioAceptadoProfe";
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return "formularioError";
	}
	
}
