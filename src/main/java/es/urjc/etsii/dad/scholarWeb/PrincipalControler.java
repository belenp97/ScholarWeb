package es.urjc.etsii.dad.scholarWeb;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.etsii.dad.scholarWeb.Repositories.AlumnoRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AsignaturaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AulaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.NoticiaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.PadreRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.ProfesorRepository;

@Controller
public class PrincipalControler {
	
	@Autowired
	private NoticiaRepository notRepo;
	
	@Autowired
	private AlumnoRepository reposAl;
	
	@Autowired
	private AsignaturaRepository asigRepo;
	
	@Autowired
	private AulaRepository reposAula;
	
	@Autowired
	private PadreRepository padreRepo;
	
	@Autowired
	private ProfesorRepository profeRepo;
	
	//faltaría contacto.
	
	public PrincipalControler() {}
	
	@PostConstruct
	public void init() {
		Alumno a= new Alumno("Juan", "Perez", "Gomez");	
		Alumno a2= new Alumno("Ana", "Martin","Lopez");
		Alumno a3= new Alumno("Elena","Vazquez","Rodriguez");
		
		a.setAula(new Aula(1,'A'));		
		a2.setAula(a.getAula());
		a3.setAula(new Aula(1,'C'));

		a.getAula().getAlumnos_curso().add(a);
		a.getAula().getAlumnos_curso().add(a2);
		a3.getAula().getAlumnos_curso().add(a3);
				
		Asignatura asi1=new Asignatura("Matematicas",1);
		Asignatura asi2= new Asignatura("Ingles",1);
		Asignatura asi3= new Asignatura("Física",1);
		
		asigRepo.save(asi1);
		asigRepo.save(asi2);
		asigRepo.save(asi3);
		
		List<Asignatura> ass = asigRepo.findAll(); 
		a.setAsignaturas(ass);
		a2.setAsignaturas(ass);
		a3.setAsignaturas(ass);
		
		List<Profesor> pss = profeRepo.findAll(); 
		a.setProfesores(pss);
		a2.setProfesores(pss);
		a3.setProfesores(pss);
		
		/*a.getAsignaturas().add(asi1);
		a.getAsignaturas().add(asi2);
		a.getAsignaturas().add(asi3);
		a2.getAsignaturas().add(asi1);
		a2.getAsignaturas().add(asi2);
		a2.getAsignaturas().add(asi3);		
		a3.getAsignaturas().add(asi1);
		a3.getAsignaturas().add(asi2);
		a3.getAsignaturas().add(asi3);
		
		asi1.getAlumnos().add(a);
		asi1.getAlumnos().add(a2);
		asi1.getAlumnos().add(a3);
		asi2.getAlumnos().add(a);
		asi2.getAlumnos().add(a2);
		asi2.getAlumnos().add(a3);
		asi3.getAlumnos().add(a);
		asi3.getAlumnos().add(a2);
		asi3.getAlumnos().add(a3);*/
		
		Padre pa= new Padre("juan@gmail.com","Ortega","Juan");
		Padre pa2= new Padre("marisa@gmail.com","Ramos","Marisa");
		Padre pa3= new Padre("jpablo@gmail.com","Hernandez","Jose Pablo");
		
		a.setPadre(pa);
		a2.setPadre(pa2);
		a3.setPadre(pa3);
		
		Profesor p= new Profesor("Pedro","Gomez","Martin","pgm@gmail.com");
		Profesor p2=new Profesor("Felix","Lopez","Cid","flc@gmail.com");
		Profesor p3 = new Profesor("Agatha", "Garcia", "Lopez", "agl@gmail.com");
		
		p.getAsignaturas().add(asi1);
		p2.getAsignaturas().add(asi2);
		p3.getAsignaturas().add(asi3);
		
		
		/*a.getProfesores().add(p);
		a.getProfesores().add(p2);
		a2.getProfesores().add(p);
		a2.getProfesores().add(p2);
		a3.getProfesores().add(p);
		a3.getProfesores().add(p2);*/
		
		padreRepo.save(pa);
		padreRepo.save(pa2);
		padreRepo.save(pa3);
				
		profeRepo.save(p);
		profeRepo.save(p2);
		profeRepo.save(p3);
		
		reposAula.save(a.getAula());
		reposAula.save(new Aula(1,'B'));
		reposAula.save(a3.getAula());
		
		reposAl.save(a);
		reposAl.save(a2);
		reposAl.save(a3);
	}

	@GetMapping("/")
	public String principal(Model model) {

		return "principal";
	}

	@RequestMapping("/noticias")
	public String verNoticia(Model model, @RequestParam(required=false) String name) throws Exception{
		
		model.addAttribute("noticia", notRepo.findAll());
		
		return "noticias"; 
	}
	
	@RequestMapping("/alumnos")
	public String verAlumnos(Model model, @RequestParam(required=false) int n_exp) throws Exception{
		
		model.addAttribute("alumno",reposAl.findAll());
		
		return "alumnos";
	}
	
	@RequestMapping("/profesores")
	public String verprofesores(Model model) {
		
		model.addAttribute("profe", profeRepo.findAll());
		
		return "profesores";
	}
	
	@GetMapping("/contacto")
	public String newContacto(Model model) {

		return "contacto";// llamarlo como se llama el html
	}
	
	@PostMapping("/contacto/recibido")
	public String contactoRecibido(Model model) {

		return "contacto_recibido";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		
		return "login"; 
	}
	
	@PostMapping("/login/privado")
	public String loginPrivado(Model model) {

		return "login_privado";
	}
	
}
