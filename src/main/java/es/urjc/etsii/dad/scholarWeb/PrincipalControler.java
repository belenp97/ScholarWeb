package es.urjc.etsii.dad.scholarWeb;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.etsii.dad.scholarWeb.Repositories.NoticiaRepository;

@Controller
public class PrincipalControler {
	
	@Autowired
	private NoticiaRepository repository;
	
	public PrincipalControler() {
		
	}
	
	@PostConstruct
	public void init() {
		repository.save(new Noticia("Importante","es una noticia importante para los padres"));
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
	
	@GetMapping("/profesores")
	public String verprofesores(Model model) {

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
