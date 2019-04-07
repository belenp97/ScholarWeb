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
import es.urjc.etsii.dad.scholarWeb.Repositories.UsuarioRepository;

@Controller
@RequestMapping("/padre")
public class PadreController {

	@Autowired
	private UsuarioRepository repos;

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

	@RequestMapping(value = "/insertar_padre", method = RequestMethod.POST)
	public String insertar_padre(Model model, HttpServletRequest request, @RequestParam String nombre,
			@RequestParam String apellido, @RequestParam Integer idalumno) {

		Usuario user = repos.findByNombre(request.getUserPrincipal().getName());

		model.addAttribute("administrador", request.isUserInRole("ADMIN"));
		model.addAttribute("username", user.getNombre());

//		Alumno al = (Alumno) reposAl.findByid(idalumno);
		Alumno a = (Alumno) reposAl.findByid(idalumno);

		String correo = nombre.toLowerCase() + "." + apellido.toLowerCase() + "@gmail.com";
		String contrasena = "@" + nombre.toLowerCase() + "." + apellido.toLowerCase() + "_"
				+ a.getNombre().toLowerCase() + "." + a.getApellido1().toLowerCase() + "";

		try {
			Padre padre = null;
			Padre pa = padreRepo.findBycorreo(correo);
			if (pa == null || (pa.getCorreo() != correo)) {
				a.setPadre((Padre) padre);
				padre = (Padre) new Padre(nombre, apellido, correo, a, contrasena, "ROLE_PADRE", "ROLE_USER");
				repos.save(padre);

				model.addAttribute("id_padre", padre.getId());
				model.addAttribute("nombrePadre", padre.getNombre() + " " + ((Padre) padre).getApellido() + " ");
				model.addAttribute("correo", padre.getCorreo());

				return "formularioAceptPadre";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "formularioError";
	}

	@RequestMapping(value = "/eliminar_padre", method = RequestMethod.POST)
	public String eliminar_padre(Model model, HttpServletRequest request, @RequestParam Integer id_padre) {
		Usuario user = repos.findByNombre(request.getUserPrincipal().getName());

		model.addAttribute("administrador", request.isUserInRole("ADMIN"));
		model.addAttribute("username", user.getNombre());

		try {

			Padre padre = (Padre) padreRepo.findByid(id_padre);

			if (id_padre > 0) {

				repos.delete(id_padre);

				model.addAttribute("id_padre", id_padre);
				model.addAttribute("nombrePadre", padre.getNombre() + " " + padre.getApellido() + " ");
				model.addAttribute("correo", padre.getCorreo());

				return "formularioAceptPadre";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "formularioError";
	}

}
