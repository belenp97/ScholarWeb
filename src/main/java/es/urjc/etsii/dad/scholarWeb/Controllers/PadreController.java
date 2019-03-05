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

import es.urjc.etsii.dad.scholarWeb.Alumno;
import es.urjc.etsii.dad.scholarWeb.Padre;
import es.urjc.etsii.dad.scholarWeb.Repositories.AlumnoRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.PadreRepository;

@Controller
public class PadreController {
	
	@Autowired
	private PadreRepository padreRepo;
	
	@Autowired
	private AlumnoRepository reposAl;
	
	@RequestMapping("/padres")
	public String verPadres(Model model) throws Exception {

		model.addAttribute("padres", padreRepo.findAll());

		return "padres";
	}

	@RequestMapping("/insertar_padre")
	public String insertar_padre(Model model, @RequestParam String correo,@RequestParam String apellido, @RequestParam String nombre, String nombreA ) {

		try {
			verPadres(model);
			Alumno a= reposAl.findBynombreEquals(nombreA);
			Padre padre = new Padre( correo, apellido, nombre, a);
			a.setPadre(padre);
			padreRepo.saveAndFlush(padre); 
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return "administrador";
	}
	
	@RequestMapping("/eliminar_padre")
	public String eliminar_padre(Model model, @RequestParam Integer id_padre) {
		try {
			verPadres(model);
			if(id_padre < 0) {
				padreRepo.deleteById(id_padre);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "administrador";
	}
	
}
