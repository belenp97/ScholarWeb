package es.urjc.etsii.dad.scholarWeb.Controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.etsii.dad.scholarWeb.Asignatura;
import es.urjc.etsii.dad.scholarWeb.Usuario;
import es.urjc.etsii.dad.scholarWeb.Repositories.AsignaturaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.UsuarioRepository;


@Controller
@RequestMapping("/asignatura")
public class AsignaturaController {
	@Autowired
	private UsuarioRepository repos;
	
	@Autowired
	private AsignaturaRepository asigRepo;
	
	@RequestMapping(value="/insertar_asignatura", method=RequestMethod.POST)
	public String insertar_asignatura(Model model, HttpServletRequest request, @RequestParam String nombre,@RequestParam int curso) {
		Usuario user = repos.findByNombre(request.getUserPrincipal().getName());

		model.addAttribute("administrador", request.isUserInRole("ADMIN"));
		model.addAttribute("profes", request.isUserInRole("PROFESOR"));
		model.addAttribute("username", user.getNombre());

		try {
			Asignatura asig = new Asignatura(nombre, curso);
			Asignatura asign = asigRepo.findBynombreEquals(nombre); 
			if(asign != asig) {
			
				model.addAttribute("nombre", asig.getNombre());
				model.addAttribute("curso", asig.getCurso());

				asigRepo.save(asig);
				
				return "formularioAceptAsignatura";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "formularioError";
	}
	
	@RequestMapping(value="/eliminar_asignatura", method=RequestMethod.POST)
	public String eliminar_asignatura(Model model, HttpServletRequest request, @RequestParam Integer id) {
		Usuario user = repos.findByNombre(request.getUserPrincipal().getName());

		model.addAttribute("administrador", request.isUserInRole("ADMIN"));
		model.addAttribute("profes", request.isUserInRole("PROFESOR"));
		model.addAttribute("username", user.getNombre());

		try {
			Asignatura a = asigRepo.findByid(id);
			Asignatura asig = asigRepo.findBynombreEquals(a.getNombre()); 
		
			model.addAttribute("nombre", asig.getNombre());
			model.addAttribute("curso", asig.getCurso());
			
			asigRepo.delete(id);
			
			return "formularioAceptAsignatura";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "formularioError";
	}
	
}
