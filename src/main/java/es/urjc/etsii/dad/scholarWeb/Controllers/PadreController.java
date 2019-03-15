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

import es.urjc.etsii.dad.scholarWeb.Alumno;
import es.urjc.etsii.dad.scholarWeb.Padre;
import es.urjc.etsii.dad.scholarWeb.Profesor;
import es.urjc.etsii.dad.scholarWeb.Usuario;
import es.urjc.etsii.dad.scholarWeb.Repositories.AlumnoRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AsignaturaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AulaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.NoticiaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.PadreRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.ProfesorRepository;

@Controller
@RequestMapping("/padre")
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
	
	@RequestMapping(value="/insertar_padre", method=RequestMethod.POST)
	public String insertar_padre(Model model, HttpServletRequest request,  @RequestParam String nombre,@RequestParam String apellido, @RequestParam Integer idalumno ) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		
		Optional<Alumno> a = reposAl.findById(idalumno); 
		
		String correo = nombre.toLowerCase() +"." +apellido.toLowerCase() +"@gmail.com"; 
		String contrasena = "@" +nombre.toLowerCase() +"." +apellido.toLowerCase()+"_" +a.get().getNombre().toLowerCase()+"." +a.get().getApellido1().toLowerCase()+"";
		
		try {
			Usuario padre = null; 
			Padre pa = padreRepo.findBycorreoEquals(correo); 
			if(pa == null || (pa.getCorreo() != correo) ) {
				if(a.isPresent()) {
					a= reposAl.findById(idalumno);
					a.get().setPadre((Padre) padre);
					padre = (Padre)new Padre(nombre,apellido,correo, a.get(), contrasena, "PADRE", "USER");
					
				}else {
					padre = (Padre)new Padre(nombre,apellido,correo, contrasena, "PADRE", "USER");
				}
				padreRepo.saveAndFlush(padre); 
				
				model.addAttribute("id_padre", padre.getId()); 
				model.addAttribute("nombrePadre", padre.getNombre() +" " +((Padre) padre).getApellido() +" ") ; 
				model.addAttribute("correo", padre.getCorreo()); 
				
				return "formularioAceptPadre";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return "formularioError";
	}
	
	@RequestMapping(value="/eliminar_padre", method=RequestMethod.POST)
	public String eliminar_padre(Model model,HttpServletRequest request, @RequestParam Integer id_padre){
		try {
			CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			model.addAttribute("token", token.getToken());
//			modelos(model);
			Optional<Padre> padre = padreRepo.findById(id_padre); 
			for(int i=0; i< padre.get().getAlumno().size(); i++) {
				Optional<Alumno> alumno = reposAl.findById(padre.get().getAlumno().get(i).getId()); 
				alumno.get().deletePadre(padre.get());
			}
			
			if(id_padre > 0) {
				
				padreRepo.deleteById(id_padre);
				
				model.addAttribute("id_padre", padre.get().getId()); 
				model.addAttribute("nombrePadre", padre.get().getNombre() +" " +padre.get().getApellido() +" ") ; 
				model.addAttribute("correo", padre.get().getCorreo()); 
				model.addAttribute("hijo", padre.get().getAlumno().toString()); 
				
				return "formularioAceptPadre";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "formularioError";
	}
	
}
