package es.urjc.etsii.dad.scholarWeb.Controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import InternalService.Mail;
import es.urjc.etsii.dad.scholarWeb.Administrador;
import es.urjc.etsii.dad.scholarWeb.Usuario;
import es.urjc.etsii.dad.scholarWeb.Repositories.AdminRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AlumnoRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AsignaturaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AulaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.NoticiaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.PadreRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.ProfesorRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.UsuarioRepository;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {

	private static final String RestService = "http://127.0.0.1:8070/send";

	@Autowired
	private UsuarioRepository repos;

	@Autowired
	private AdminRepository admRepo;

	@Autowired
	private AlumnoRepository reposAl;

	@Autowired
	private PadreRepository padreRepo;

	@Autowired
	private AsignaturaRepository asigRepo;

	@Autowired
	private AulaRepository reposAula;

	@Autowired
	private NoticiaRepository notRepo;

	@Autowired
	private ProfesorRepository profeRepo;

	@RequestMapping("")
	public String administrador(Model model, HttpServletRequest request) {

		Usuario user = repos.findByNombre(request.getUserPrincipal().getName());

		model.addAttribute("administrador", request.isUserInRole("ADMIN"));
		model.addAttribute("profes", request.isUserInRole("PROFESOR"));
		model.addAttribute("username", user.getNombre());

		try {
			model.addAttribute("profesores", profeRepo.findAll());
			model.addAttribute("alumnos", reposAl.findAll());
			model.addAttribute("padres", padreRepo.findAll());
			model.addAttribute("asignaturas", asigRepo.findAll());
			model.addAttribute("not", notRepo.findAll());
			model.addAttribute("aulas", reposAula.findAll());
			model.addAttribute("admin", admRepo.findAll());

			return "administrador";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "formularioError";
	}

	@RequestMapping("/insertar_admin")
	public String insertar_admin(Model model, HttpServletRequest request, @RequestParam String nombre,
			@RequestParam String apellido) {
		Usuario user = repos.findByNombre(request.getUserPrincipal().getName());

		model.addAttribute("administrador", request.isUserInRole("ADMIN"));
		model.addAttribute("username", user.getNombre());

		String correo = nombre.toLowerCase() + "." + apellido.toLowerCase() + "@gmail.com";
		String contrasena = "@" + nombre.toLowerCase() + "." + apellido.toLowerCase() + "_";

		System.out.println("el usuario es: " + correo);

		try {
			Administrador admin = (Administrador) repos.findBycorreo(correo);
			if (admin == null || admin.getCorreo() != correo) {

				Usuario adminis = (Administrador) new Administrador(nombre, apellido, correo, contrasena, "ROLE_ADMIN", "ROLE_PROFESOR", "ROLE_PADRE");
				admRepo.save((Administrador) adminis);

//				model.addAttribute("id", adminis.getId());
				model.addAttribute("nombre", adminis.getNombre() + " " + ((Administrador) adminis).getApellido() + " ");
				model.addAttribute("correo", adminis.getCorreo() + " ");

				RestTemplate servInterno = new RestTemplate();

				String from = "scholar.web.dad@gmail.com"; // dirección de correo remitente -> usuario Administrador
				String to = adminis.getCorreo(); // dirección del correo de destino -> nuevo usuario
				String body = "Hola " + nombre + ", has sido registrado como " + adminis.getRol()
						+ " en Scholarweb con las siguientes credenciales: \nLogin : " + adminis.getCorreo()
						+ "\nContraseña: " + contrasena + "\n Un saludo ScholarWeb.";

				// AL INVOCAR ESTE MÉTODO LE PASO COMO PARÁMETROS LA URL DEL CONTROLADOR REST Y
				// EL CORREO QUE QUIERO ENVIAR AL DESTINATARIO
				servInterno.postForLocation(RestService, new Mail(from, from, "Alta Usuario", body));

				return "formularioAceptAdmin";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "formularioError";
	}

}
