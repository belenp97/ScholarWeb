package es.urjc.etsii.dad.scholarWeb;

import java.util.ArrayList;

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
	private NoticiaRepository repository;
	
	@Autowired
	private AlumnoRepository AlumnoRepo;
	
	@Autowired
	private AsignaturaRepository AsigRepo;
	
	@Autowired
	private AulaRepository AulaRepo;
	
	@Autowired
	private PadreRepository PadreRepo;
	
	@Autowired
	private ProfesorRepository ProfeRepo;
	
	//faltaría contacto.
	
	public PrincipalControler() {
		
	}
	
	@PostConstruct
	public void init() {
		
		Profesor p=new Profesor("Pedro","Gomez","Martin","pgm@gmail.com");
		ProfeRepo.save(p);
		AulaRepo.save(new Aula(1,'A'));		
		
	}

	@GetMapping("/")
	public String principal(Model model) {

		return "principal";
	}

	@RequestMapping("/noticias")
	public String verNoticia(Model model, @RequestParam(required=false) String name) throws Exception{
		
		model.addAttribute("noticia", repository.findAll());	
		
		return "noticias"; 
	}
	
	@RequestMapping("/alumnos")
	public String verAlumnos(Model model, @RequestParam(required=false) int n_exp) throws Exception{
		
		model.addAttribute("alumno",AlumnoRepo.findAll());
		
		return "alumnos";
	}
	
	@RequestMapping("/profesores")
	public String verprofesores(Model model) {
		
		model.addAttribute("profesor", ProfeRepo.findAll());
		
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
}
