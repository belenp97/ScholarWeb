package es.urjc.etsii.dad.scholarWeb.Controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/contacto")
public class ContactoController {

	@RequestMapping(value="", method=RequestMethod.GET)
	public String newContacto(Model model) {

		return "contacto";// llamarlo como se llama el html
	}
	
	@RequestMapping(value="/recibido", method=RequestMethod.POST)
	public String contactoRecibido(Model model, HttpServletRequest request, @RequestParam String nombre, @RequestParam Integer telefono, @RequestParam String email, @RequestParam String cuerpo) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		
		
		
		return "contacto_recibido";
	}
	
}