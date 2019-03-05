package es.urjc.etsii.dad.scholarWeb.Controllers;

import java.util.List;

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

import es.urjc.etsii.dad.scholarWeb.Noticia;
import es.urjc.etsii.dad.scholarWeb.Repositories.NoticiaRepository;

@Controller
public class NoticiaController {
	
	@Autowired
	private NoticiaRepository notRepo;

	@RequestMapping("/noticias")
	public String verNoticia(Model model) throws Exception {

		model.addAttribute("noticia", notRepo.findAll());

		return "noticias";
	}
	
	@RequestMapping("/insertar_noticia")
	public String insertar_noticia(Model model, @RequestParam String titulo,@RequestParam String cuerpo) {
		try {
			verNoticia(model);
			Noticia noticia = new Noticia( titulo, cuerpo);
			notRepo.save(noticia); 
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return "administrador";
	}
	
	@RequestMapping("/eliminar_noticia")
	public String eliminar_noticia(Model model,@RequestParam String titulo) {
		try {
			verNoticia(model);
			Noticia noticia = new Noticia( titulo);
			notRepo.delete(notRepo.findBytituloEquals(noticia.gettitulo()));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "administrador";
	}
}
