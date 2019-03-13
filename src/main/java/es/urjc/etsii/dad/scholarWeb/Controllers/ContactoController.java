package es.urjc.etsii.dad.scholarWeb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/contacto")
public class ContactoController {

	@RequestMapping(value="", method=RequestMethod.GET)
	public String newContacto(Model model) {

		return "contacto";// llamarlo como se llama el html
	}
	
	@RequestMapping(value="/recibido", method=RequestMethod.POST)
	public String contactoRecibido(Model model) {

		return "contacto_recibido";
	}
	
}