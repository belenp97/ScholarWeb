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
import org.springframework.web.client.RestTemplate;

import es.urjc.etsii.dad.scholarWeb.Alumno;
import es.urjc.etsii.dad.scholarWeb.Asignatura;
import es.urjc.etsii.dad.scholarWeb.Aula;
import es.urjc.etsii.dad.scholarWeb.Padre;
import es.urjc.etsii.dad.scholarWeb.Profesor;
import es.urjc.etsii.dad.scholarWeb.Usuario;
import es.urjc.etsii.dad.scholarWeb.Repositories.AlumnoRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AsignaturaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AulaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.PadreRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.ProfesorRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.UsuarioRepository;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
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
	private ProfesorRepository profeRepo;


	@RequestMapping(value = "/insertar_alumno", method = RequestMethod.POST)
	public String insertar_alumno(Model model, HttpServletRequest request, @RequestParam String nombre,
			@RequestParam String apellido1, @RequestParam String apellido2, @RequestParam Integer idasig,
			@RequestParam Integer idaula, @RequestParam Integer idprofesor, String contraseña, String rol,
			String... roles) {

		Usuario user = repos.findByNombre(request.getUserPrincipal().getName());

		model.addAttribute("administrador", request.isUserInRole("ADMIN"));
		model.addAttribute("username", user.getNombre());
		
		Usuario alumno = null;
		String contrasena = "@" + nombre.toLowerCase().charAt(0) + "_" + apellido1.toLowerCase().charAt(0) + "_"
				+ apellido2.toLowerCase().charAt(0);
		String correo = nombre.toLowerCase().charAt(0) + "" + apellido1.toLowerCase().charAt(0) + ""
				+ apellido2.toLowerCase().charAt(0) + "" + "@gmail.com";

		try {
			Profesor p = profeRepo.findByid(idprofesor);
			Profesor prof = profeRepo.findBynombreEquals(p.getNombre());

			Asignatura asig = asigRepo.findByid(idasig);
			Asignatura asignatura = asigRepo.findBynombreEquals(asig.getNombre());
			Aula a = reposAula.findByidAula(idaula);
//			Aula aul = reposAula.findByCurso(a.get().getCurso());
			contrasena = nombre.charAt(0) + apellido1.charAt(0) + apellido1.charAt(1) + "";

			if (prof == null) {
				alumno = new Alumno(nombre, apellido1, apellido2, asignatura, a, correo, contrasena,
						"ROLE_ALUMNO", "ROLE_USER");
			} else {
				alumno = new Alumno(nombre, apellido1, apellido2, asignatura, a, prof, correo, contrasena,
						"ROLE_ALUMNO", "ROLE_USER");
			}
			Alumno al = reposAl.findBynombreEquals(nombre);
			if (al == (null) || !al.equals(alumno)) {
				reposAl.save(alumno);

				model.addAttribute("nexp", alumno.getId());
				model.addAttribute("nombreAlum", alumno.getNombre() + " " + ((Alumno) alumno).getApellido1() + " "
						+ ((Alumno) alumno).getApellido2() + " ");
				model.addAttribute("aula",
						((Alumno) alumno).getAula().getCurso() + " " + ((Alumno) alumno).getAula().getLetra() + " ");
				model.addAttribute("nombreasig", ((Alumno) alumno).getAsignaturas().toString());
				model.addAttribute("nombreprofesor", ((Alumno) alumno).getProfesores().toString());
				model.addAttribute("correo", ((Alumno) alumno).getCorreo());

				return "formularioAceptAlumno";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "formularioError";
	}

	@RequestMapping(value = "/eliminar_alumno", method = RequestMethod.POST)
	public String eliminar_alumno(Model model, HttpServletRequest request, @RequestParam Integer nexp) {
		Usuario user = repos.findByNombre(request.getUserPrincipal().getName());

		model.addAttribute("administrador", request.isUserInRole("ADMIN"));
		model.addAttribute("username", user.getNombre());
		
		try {
			Alumno a = reposAl.findByid(nexp);
			Alumno alumno = reposAl.findBynombreEquals(a.getNombre());
			Padre p = alumno.getPadre();
			if (p != null) {
				padreRepo.delete(p);
			}

			model.addAttribute("nexp", alumno.getId());
			model.addAttribute("nombreAlum",
					alumno.getNombre() + " " + alumno.getApellido1() + " " + alumno.getApellido2() + " ");
			model.addAttribute("aula", alumno.getAula().getCurso() + " " + alumno.getAula().getLetra() + " ");
			model.addAttribute("nombreasig", alumno.getAsignaturas().toString());
			model.addAttribute("nombreprofesor", alumno.getProfesores().toString());
			model.addAttribute("correo", alumno.getCorreo());

			reposAl.delete(alumno);

			return "formularioAceptAlumno";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "formularioError";
	}
}
