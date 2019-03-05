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

import es.urjc.etsii.dad.scholarWeb.Asignatura;
import es.urjc.etsii.dad.scholarWeb.Repositories.AsignaturaRepository;

@Controller
public class AsignaturaController {
	
	@Autowired
	private AsignaturaRepository asigRepo;
	
	@RequestMapping("/asignaturas")
	public String verAsignaturas(Model model) throws Exception {

		model.addAttribute("padres", asigRepo.findAll());

		return "padres";
	}
	
	@RequestMapping("/insertar_asignatura")
	public String insertar_asignatura(Model model, @RequestParam String nombre,@RequestParam int curso) {
		
		try {
			
			Asignatura asignatura = new Asignatura( nombre, curso);
			asigRepo.save(asignatura); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "administrador";
	}
	
	@RequestMapping("/eliminar_asignatura")
	public String eliminar_asignatura(Model model, @RequestParam Integer id) {
		
		try {
			verAsignaturas(model);
			asigRepo.deleteById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "administrador";
	}
	
}
