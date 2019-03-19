package es.urjc.etsii.dad.scholarWeb.Controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import es.urjc.etsii.dad.scholarWeb.Administrador;
import es.urjc.etsii.dad.scholarWeb.Noticia;
import es.urjc.etsii.dad.scholarWeb.Repositories.NoticiaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.UsuarioRepository;

@Controller
public class NoticiaController {
	
	@Autowired
	private NoticiaRepository notRepo;
	
	@Autowired
	private UsuarioRepository repos;
	
	@RequestMapping(value="/noticias", method=RequestMethod.GET)
	public String verNoticia(Model model, HttpServletRequest request, HttpSession sesion) throws Exception {

		model.addAttribute("noticia", notRepo.findAll());
		model.addAttribute("administrador", request.isUserInRole("ADMIN"));

		return "noticias";
	}
	
	@RequestMapping(value="/insertar_noticia")
	public String insertar_noticia(Model model, HttpServletRequest request, @RequestParam String titulo,@RequestParam String cuerpo) {
		try {
			CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			model.addAttribute("token", token.getToken());

//	    	model.addAttribute("administrador", request.isUserInRole("ADMIN"));
			model.addAttribute("administrador", repos.findByRol("ADMIN"));
			
			model.addAttribute("noticia", notRepo.findAll());
			Noticia noticia = new Noticia(titulo, cuerpo);
			if(noticia != null) {
				
				notRepo.save(noticia); 
				model.addAttribute("titulo", noticia.gettitulo()); 
				model.addAttribute("cuerpo", noticia.getcuerpo()); 
				
				return "formularioAceptNoticia";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return "formularioError";
	}
	
	@RequestMapping(value="/eliminar_noticia")
	public String eliminar_noticia(Model model, HttpServletRequest request, HttpSession sesion,@RequestParam String titulo) {
		try {
			CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			model.addAttribute("token", token.getToken());
			
			model.addAttribute("administrador", repos.findByRol("ADMIN"));
			
			model.addAttribute("noticia", notRepo.findAll());
			Noticia noticia = notRepo.findBytituloEquals(titulo);
			if(noticia != null) {
				
				model.addAttribute("titulo", noticia.gettitulo()); 
				model.addAttribute("cuerpo", noticia.getcuerpo()); 
				
				notRepo.delete(notRepo.findBytituloEquals(noticia.gettitulo()));
				
				return "formularioAceptNoticia";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "formularioError";
	}
}
