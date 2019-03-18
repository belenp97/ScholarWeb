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
	
	@RequestMapping("")
	public String verProfesores(Model model, HttpServletRequest request) {
		
		model.addAttribute("profe", profeRepo.findAll());

		return "profesores";
	}
	
	
	@RequestMapping("/insertar_profesor" )
	public String insertar_profesor(Model model, HttpServletRequest request, @RequestParam String nombre,@RequestParam String apellido1,@RequestParam String apellido2, @RequestParam String asignatura,  @RequestParam Integer id_aula) {
			CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			model.addAttribute("token", token.getToken());
			
			String correo = nombre.toLowerCase() +"." +apellido1.toLowerCase()+"." +apellido2.toLowerCase() +"@gmail.com"; 
			String contrasena = "@" +nombre.toLowerCase() +"." +apellido1.toLowerCase()+"_" +"." +apellido1.toLowerCase()+"_";
			
		try {	
			Optional<Aula> aula = reposAula.findById(id_aula);
			Aula aul = aula.get() ;
			Asignatura asig = asigRepo.findBynombreEquals(asignatura);
			Profesor profe = profeRepo.findBynombreEquals(nombre);  
			if(profe ==null || profe.getCorreo() != correo) {
				
				Usuario profesor = (Profesor) new Profesor(nombre, apellido1, apellido2, asig, aul.getAlumnos_curso().get(0), aula.get(),correo,contrasena, "PROFESOR", "USER");
				profeRepo.saveAndFlush((Profesor) profesor);
				
				model.addAttribute("id_profesor", profesor.getId()); 
				model.addAttribute("nombreProfe", profesor.getNombre() +" " +((Profesor) profesor).getApellido1() +" " +((Profesor) profesor).getApellido2() +" "); 
				model.addAttribute("correo", profesor.getCorreo()); 
				model.addAttribute("alumnos", ((Profesor) profesor).getAlumnos().toString()); 
				model.addAttribute("asignatura", ((Profesor) profesor).getAsignaturas().toString()); 
				
//				profeRepo.save(profesor);
				
				return "formularioAceptProfe";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "formularioError";
	}
	
	@RequestMapping(value="/eliminar_profesor", method=RequestMethod.POST)
	public String eliminar_profesor(Model model, HttpServletRequest request, @RequestParam Integer id_profesor) {
		try {
			CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			model.addAttribute("token", token.getToken());

			Optional<Profesor> p = profeRepo.findById(id_profesor); 
			Usuario profesor = p.get();
			if(p.get() != null) {
				if(p.get().getId() == id_profesor) {
					model.addAttribute("id_profesor", profesor.getId()); 
					model.addAttribute("nombreProfe", profesor.getNombre() +" " +((Profesor) profesor).getApellido1() +" " +((Profesor) profesor).getApellido2() +" "); 
					model.addAttribute("correo", profesor.getCorreo()); 
					model.addAttribute("alumnos",((Profesor) profesor).getAlumnos().toString()); 
					model.addAttribute("asignatura", ((Profesor) profesor).getAsignaturas().toString()); 
					profeRepo.deleteById(id_profesor);
					
					return "formularioAceptProfesor";
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return "formularioError";
	}
	
}
