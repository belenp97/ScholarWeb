package es.urjc.etsii.dad.scholarWeb.Controllers;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.urjc.etsii.dad.scholarWeb.Alumno;
import es.urjc.etsii.dad.scholarWeb.Asignatura;
import es.urjc.etsii.dad.scholarWeb.Aula;
import es.urjc.etsii.dad.scholarWeb.Profesor;
import es.urjc.etsii.dad.scholarWeb.Usuario;
import es.urjc.etsii.dad.scholarWeb.Repositories.AlumnoRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AsignaturaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AulaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.NoticiaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.PadreRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.ProfesorRepository;

@Controller
@RequestMapping("/profesor")
public class ProfesorController {

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

	@RequestMapping("")
	public String verProfesores(Model model, HttpServletRequest request) {

		model.addAttribute("administrador", request.isUserInRole("ADMIN"));

		model.addAttribute("profe", profeRepo.findAll());
		return "profesores";
	}

	@RequestMapping("/insertar_profesor")
	public String insertar_profesor(Model model, HttpServletRequest request, @RequestParam String nombre,
			@RequestParam String apellido1, @RequestParam String apellido2, @RequestParam Integer asignatura,
			@RequestParam Integer id_aula) {

		String correo = nombre.toLowerCase() + "." + apellido1.toLowerCase() + "." + apellido2.toLowerCase()
				+ "@gmail.com";
		String contrasena = "@" + nombre.toLowerCase() + "." + apellido1.toLowerCase() + "_" + "."
				+ apellido1.toLowerCase() + "_";

		try {

			Aula a = reposAula.findByidAula(id_aula);
			Asignatura asig = asigRepo.findByid(asignatura);
			Profesor profe = profeRepo.findBynombreEquals(nombre);
			if (profe == null || profe.getCorreo() != correo) {

				Profesor profesor = new Profesor(nombre, apellido1, apellido2, asig,
						a.getAlumnos_curso().get(0), a, correo, contrasena, "ROLE_PROFESOR");
				profeRepo.saveAndFlush((Profesor) profesor);

				model.addAttribute("id_profesor", profesor.getId());
				model.addAttribute("nombreProfe", profesor.getNombre() + " " + profesor.getApellido1()
						+ " " + profesor.getApellido2() + " ");
				model.addAttribute("correo", profesor.getCorreo());
				model.addAttribute("alumnos", profesor.getAlumnos().toString());
				model.addAttribute("asignatura",profesor.getAsignaturas().toString());

//				profeRepo.save(profesor);

				return "formularioAceptProfe";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "formularioError";
	}

	@RequestMapping(value = "/eliminar_profesor", method = RequestMethod.POST)
	public String eliminar_profesor(Model model, HttpServletRequest request, @RequestParam Integer id_profesor) {
		try {
			CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			model.addAttribute("token", token.getToken());

			Profesor prof = profeRepo.findByid(id_profesor);
			if (prof != null) {
					model.addAttribute("id_profesor", prof.getId());
					model.addAttribute("nombreProfe",
							prof.getNombre() + " " + (prof.getApellido1() + " " + prof.getApellido2() + " "));
					model.addAttribute("correo", prof.getCorreo());
					model.addAttribute("alumnos", prof.getAlumnos().toString());
					model.addAttribute("asignatura", prof.getAsignaturas().toString());
					profeRepo.deleteByid(id_profesor);

					return "formularioAceptProfesor";
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "formularioError";
	}

}
