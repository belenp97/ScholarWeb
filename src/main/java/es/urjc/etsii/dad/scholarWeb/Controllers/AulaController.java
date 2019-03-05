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

import es.urjc.etsii.dad.scholarWeb.Aula;
import es.urjc.etsii.dad.scholarWeb.Repositories.AulaRepository;

@Controller
public class AulaController {
	
	@Autowired
	private AulaRepository reposAula;
	
	@RequestMapping("/aulas")
	public String verAulas(Model model) throws Exception {

		model.addAttribute("aulas", reposAula.findAll());

		return "aulas";
	}
	
	@RequestMapping("/insertar_aula")
	public String insertar_aula(Model model, @RequestParam Integer curso,@RequestParam Character letra) {
		
		try {
			verAulas(model);
			Aula aula = new Aula(curso,letra);
			reposAula.save(aula); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "administrador";
	}
	
	/*@RequestMapping(value="/eliminar_aula")
	public String eliminar_aula(Model model, @RequestParam int curso,@RequestParam char letra) {
		modelos(model);
		try {
			//Aula aula = new Aula(curso,letra);
			//reposAula.delete(reposAula.findBycursoEquals(aula.getCurso())); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "administrador";
	}*/

}
