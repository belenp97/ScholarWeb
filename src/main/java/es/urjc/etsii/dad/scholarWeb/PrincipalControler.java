package es.urjc.etsii.dad.scholarWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import es.urjc.etsii.dad.scholarWeb.Controllers.NoticiaController;

@Controller
public class PrincipalControler {
	
	@Autowired
	private NoticiaController nc; 
	
	public PrincipalControler() {
		
	}

	@GetMapping("/")
	public String principal(Model model) {

		return "principal";
	}

	@GetMapping("/noticias")
	public String verNoticia(Model model) {

		nc.init();
		
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
