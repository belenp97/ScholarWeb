package es.urjc.etsii.dad.scholarWeb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PrincipalControler {

	private List<Noticia> noticias = new ArrayList<>();

	public PrincipalControler() {
		noticias.add(new Noticia("Saludos",
				"Bienvenidos a Scholar Web, un colegio a las afueras de Madrid que quiere implantar una nueva mentalidad dentro de los colegios de la comunidad. Esperamos que para cualquier problema o mejora, nos lo hagan llegar mediante pagina de contacto. Un saludo y gracias"));
		noticias.add(
				new Noticia("Ultimas Noticias", "Todos los padres recibiran por mensaje, las notas de los alumnos"));
	}

	@GetMapping("/")
	public String principal(Model model) {

		return "principal";
	}

	@GetMapping("/noticias")
	public String verNoticia(Model model) {

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