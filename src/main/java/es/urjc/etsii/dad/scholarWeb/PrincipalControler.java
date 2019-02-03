package es.urjc.etsii.dad.scholarWeb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalControler {

	@GetMapping("/")
	public String tablon(Model model) {


		return "principal";
	}
	
}
