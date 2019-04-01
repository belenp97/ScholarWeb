package es.urjc.etsii.dad.scholarWeb.Controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.etsii.dad.scholarWeb.Asignatura;
import es.urjc.etsii.dad.scholarWeb.Repositories.AsignaturaRepository;


@Controller
@RequestMapping("/asignatura")
public class AsignaturaController {
	
	
	@Autowired
	private AsignaturaRepository asigRepo;
	
	@RequestMapping(value="/insertar_asignatura", method=RequestMethod.POST)
	public String insertar_asignatura(Model model, HttpServletRequest request, @RequestParam String nombre,@RequestParam int curso) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			model.addAttribute("token", token.getToken());
		try {
			Asignatura asignatura = new Asignatura(nombre, curso);
			Asignatura asig = asigRepo.findBynombreEquals(nombre); 
			if(asignatura != asig) {
				asigRepo.save(asignatura);
			
				model.addAttribute("nombre", asig.getNombre());
				model.addAttribute("curso", asig.getCurso());
				

				return "formularioAceptAsignatura";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "formularioError";
	}
	
	@RequestMapping(value="/eliminar_asignatura", method=RequestMethod.POST)
	public String eliminar_asignatura(Model model, HttpServletRequest request, @RequestParam Integer id) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			model.addAttribute("token", token.getToken());
			
		try {
			Asignatura a = asigRepo.findByid(id);
			Asignatura asig = asigRepo.findBynombreEquals(a.getNombre()); 
		
			model.addAttribute("nombre", asig.getNombre());
			model.addAttribute("curso", asig.getCurso());
			
			asigRepo.deleteByid(id);
			
			return "formularioAceptAsignatura";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "formularioError";
	}
	
}
