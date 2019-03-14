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
import es.urjc.etsii.dad.scholarWeb.Padre;
import es.urjc.etsii.dad.scholarWeb.PrincipalControler;
import es.urjc.etsii.dad.scholarWeb.Profesor;
import es.urjc.etsii.dad.scholarWeb.Usuario;
import es.urjc.etsii.dad.scholarWeb.Repositories.AlumnoRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AsignaturaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AulaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.NoticiaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.PadreRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.ProfesorRepository;


@RestController
@RequestMapping("/alumno")
public class AlumnoController {
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
	
//	@RequestMapping("")
//	public String verAlumnos(Model model, HttpServletRequest request) throws Exception {
////		modelos(model);
//		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
//		model.addAttribute("token", token.getToken());
//		
//		model.addAttribute("alumnos", reposAl.findAll());
//		model.addAttribute("padres", padreRepo.findAll());
//		model.addAttribute("asignaturas", asigRepo.findAll());
//		model.addAttribute("noticias", notRepo.findAll());
//		model.addAttribute("aulas", reposAula.findAll());
//		model.addAttribute("profesores", profeRepo.findAll());
//		
//		return "alumnos";
//	}
		
	@RequestMapping(value="/insertar_alumno", method=RequestMethod.GET)
	public String insertar_alumno(Model model,HttpServletRequest request,  @RequestParam String nombre,@RequestParam String apellido1, @RequestParam String apellido2, @RequestParam Integer idprofe, @RequestParam Integer idasig, @RequestParam Integer idaula,String contraseña, String rol, String... roles) {	
		try {
			CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			model.addAttribute("token", token.getToken());
			
			Optional<Aula> aul = reposAula.findById(idaula);
			Optional<Asignatura> asig = asigRepo.findById(idasig);
			Optional<Profesor> prof = profeRepo.findById(idprofe);
			Usuario alumno = new Alumno(nombre, apellido1, apellido2,asig.get().getNombre(), aul.get().toString(), null, null, null, null);
			Alumno al = reposAl.findBynombreEquals(nombre); 
			if(al==(null) || !al.equals(alumno) ) {
//				reposAl.save(alumno); 
				model.addAttribute("nexp", alumno.getId()); 
				model.addAttribute("nombreAlum", alumno.getNombre() +" " +((Alumno) alumno).getApellido1() +" " +((Alumno) alumno).getApellido2() +" "); 
				model.addAttribute("curso", ((Alumno) alumno).getAula().getCurso() +" " +((Alumno) alumno).getAula().getLetra() +" "); 
				model.addAttribute("nombreasig", ((Alumno) alumno).getAsignaturas().toString()); 
				model.addAttribute("nombreprofesor", ((Alumno) alumno).getProfesores().toString()); 
				
				reposAl.saveAndFlush(alumno); 
				return "formularioAceptadoAlum";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "formularioError";
	}
		
	@RequestMapping(value="/eliminar_alumno" , method=RequestMethod.GET)
	public String eliminar_alumno(Model model,HttpServletRequest request , @RequestParam Integer nexp) {	
		try {
//			modelos(model);
			CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			model.addAttribute("token", token.getToken());
			
			Optional<Alumno> alumno = reposAl.findById(nexp);
			Padre p = alumno.get().getPadre(); 
			if(p != null) {
				padreRepo.delete(p);
			}
			model.addAttribute("nexp", alumno.get().getId()); 
			model.addAttribute("nombreAlum", alumno.get().getNombre() +" " + alumno.get().getApellido1() +" " + alumno.get().getApellido2() +" "); 
			model.addAttribute("curso", alumno.get().getAula().getCurso() +" " +alumno.get().getAula().getLetra() +" "); 
			model.addAttribute("nombreasig", alumno.get().getAsignaturas().toString()); 
			model.addAttribute("nombreprofesor", alumno.get().getProfesores().toString()); 
			
			reposAl.deleteById(nexp); 

			return "formularioAceptadoAlum";
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "formularioError";
	}
}
	
	