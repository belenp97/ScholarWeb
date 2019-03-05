package es.urjc.etsii.dad.scholarWeb.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.etsii.dad.scholarWeb.Alumno;
import es.urjc.etsii.dad.scholarWeb.Padre;
import es.urjc.etsii.dad.scholarWeb.Repositories.AlumnoRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AsignaturaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AulaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.NoticiaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.PadreRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.ProfesorRepository;

@Controller
public class PadreController {
	
	@Autowired
	private AlumnoRepository reposAl;
	
	@Autowired
	private AulaRepository reposAula;
	
	@Autowired
	private PadreRepository padreRepo;
	
	@Autowired
	private AsignaturaRepository asigRepo;
	
	@Autowired
	private NoticiaRepository notRepo;
	
	@Autowired
	private ProfesorRepository profeRepo;
	
	
	private void modelos(Model model) {
		model.addAttribute("alumnos", reposAl.findAll());
		model.addAttribute("padres", padreRepo.findAll());
		model.addAttribute("asignaturas", asigRepo.findAll());
		model.addAttribute("noticias", notRepo.findAll());
		model.addAttribute("aulas", reposAula.findAll());
		model.addAttribute("profesores", profeRepo.findAll());
	}
	
	@RequestMapping("/padres")
	public String verPadres(Model model) throws Exception {
		modelos(model);

		return "padres";
	}

	@RequestMapping("/insertar_padre")
	public String insertar_padre(Model model, @RequestParam String correo,@RequestParam String apellido, @RequestParam String nombre, Integer idalumno ) {

		try {
			modelos(model);
			Optional<Alumno> a= reposAl.findById(idalumno);
			Alumno alum = a.get();
			Padre pa = padreRepo.findBycorreoEquals(correo); 
			if(pa.getCorreo() == correo) {
				Padre padre = new Padre( correo, apellido, nombre, alum);
				alum.setPadre(padre);
				padreRepo.saveAndFlush(padre); 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return "administrador";
	}
	
	@RequestMapping("/eliminar_padre")
	public String eliminar_padre(Model model, @RequestParam Integer id_padre){
		try {
			modelos(model);
			if(id_padre > 0) {
				padreRepo.deleteById(id_padre);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "administrador";
	}
	
}
