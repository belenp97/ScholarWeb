package es.urjc.etsii.dad.scholarWeb;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.etsii.dad.scholarWeb.Repositories.AlumnoRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AsignaturaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AulaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.PadreRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.ProfesorRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.UsuarioRepository;
import es.urjc.etsii.dad.scholarWeb.Usuario;

@Controller
public class PrincipalControler {
	
	//Cambiar el path según donde se encuentre el proyecto.
	private static final String EXTERNAL_FILE_PATH = "Users/jorgealonsovivar/Desktop/urjc/3 AÑO/2 cuatri/DAD";
//	private static final String EXTERNAL_FILE_PATH = "";
	
//
//	@Autowired
//	private AlumnoRepository reposAl;
//
//	@Autowired
//	private AsignaturaRepository asigRepo;
//
//	@Autowired
//	private AulaRepository reposAula;
//
//	@Autowired
//	private PadreRepository padreRepo;
//
//	@Autowired
//	private ProfesorRepository profeRepo;

	@Autowired
	private UsuarioRepository repos;


	/*@PostConstruct
	public void init() {
		
		Alumno alumn = new Alumno("Juan", "Perez", "Gomez");
		Alumno alumn2 = new Alumno("Ana", "Martin", "Lopez");
		Alumno alumn3 = new Alumno("Elena", "Vazquez", "Rodriguez");

		Profesor prof = new Profesor("Pedro", "Gomez", "Martin", "pgm@gmail.com");
		Profesor prof2 = new Profesor("Felix", "Lopez", "Cid", "flc@gmail.com");
		Profesor prof3 = new Profesor("Agatha", "Garcia", "Lopez", "agl@gmail.com");

		Asignatura asi1 = new Asignatura("Matematicas", 1);
		Asignatura asi2 = new Asignatura("Ingles", 1);
		Asignatura asi3 = new Asignatura("Física", 1);

		Padre pa = new Padre("juan@gmail.com", "Ortega", "Juan");
		Padre pa2 = new Padre("marisa@gmail.com", "Ramos", "Marisa");
		Padre pa3 = new Padre("jpablo@gmail.com", "Hernandez", "Jose Pablo");

		alumn.setAula(new Aula(1, 'A'));
		alumn2.setAula(alumn.getAula());
		alumn3.setAula(new Aula(1, 'C'));

		alumn.getAula().getAlumnos_curso().add(alumn);
		alumn.getAula().getAlumnos_curso().add(alumn2);
		alumn3.getAula().getAlumnos_curso().add(alumn3);

		List<Profesor> profs = profeRepo.findAll();
		alumn.setProfesores(profs);
		alumn2.setProfesores(profs);
		alumn3.setProfesores(profs);

		List<Asignatura> ass = asigRepo.findAll();
		alumn.setAsignaturas(ass);
		alumn2.setAsignaturas(ass);
		alumn3.setAsignaturas(ass);

		List<Profesor> pss = profeRepo.findAll();
		alumn.setProfesores(pss);
		alumn2.setProfesores(pss);
		alumn3.setProfesores(pss);

		List<Alumno> alumnos = reposAl.findAll();
		asi1.setAlumnos(alumnos);
		asi2.setAlumnos(alumnos);
		asi3.setAlumnos(alumnos);

		alumn.setPadre(pa);
		alumn2.setPadre(pa2);
		alumn3.setPadre(pa3);
		
		pa.getAlumno().add(alumn);
		pa2.getAlumno().add(alumn);
		pa3.getAlumno().add(alumn);

		prof.setAsignaturas(ass);
		prof2.setAsignaturas(ass);
		prof3.setAsignaturas(ass);

		asigRepo.save(asi1);
		asigRepo.save(asi2);
		asigRepo.save(asi3);

		padreRepo.save(pa);
		padreRepo.save(pa2);
		padreRepo.save(pa3);

		profeRepo.save(prof);
		profeRepo.save(prof2);
		profeRepo.save(prof3);

		reposAula.save(alumn.getAula());
		reposAula.save(new Aula(1, 'B'));
		reposAula.save(alumn3.getAula());

		reposAl.save(alumn);
		reposAl.save(alumn2);
		reposAl.save(alumn3);
	}*/

	@RequestMapping("/")
	public String principal(Model model, HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		
		HttpSession sesion = request.getSession(true); 
		
		return "principal";
	}
	
	@RequestMapping("/comida")
	public void download (HttpServletRequest request, HttpServletResponse response,
			@RequestParam(defaultValue="comedor.pdf") String fileName ) throws IOException
	{
		File file = new File(EXTERNAL_FILE_PATH +"/"+ fileName);
			if (file.exists()) {

				//get the mimetype
				String mimeType = URLConnection.guessContentTypeFromName(file.getName());
				if (mimeType == null) {
					//unknown mimetype so set the mimetype to application/octet-stream
					mimeType = "application/pdf";
				}

				response.setContentType(mimeType);

				

				/**
				 * Mencionamos el inline (si no está comentado el archivo se abrirá sin descargarse)
				 */
				response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

				//en este caso tenemos attachment que descargrá directamente el pdf.
				response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));

				response.setContentLength((int) file.length());

				InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

				FileCopyUtils.copy(inputStream, response.getOutputStream());

			}
		
	}
	
	@RequestMapping("/deportes")
	public void download2 (HttpServletRequest request, HttpServletResponse response,
			@RequestParam(defaultValue="deportes.pdf") String fileName ) throws IOException
	{
		File file = new File(EXTERNAL_FILE_PATH +"/"+ fileName);
			if (file.exists()) {

				//get the mimetype
				String mimeType = URLConnection.guessContentTypeFromName(file.getName());
				if (mimeType == null) {
					//unknown mimetype so set the mimetype to application/octet-stream
					mimeType = "application/pdf";
				}

				response.setContentType(mimeType);

				/**
				 * In a regular HTTP response, the Content-Disposition response header is a
				 * header indicating if the content is expected to be displayed inline in the
				 * browser, that is, as a Web page or as part of a Web page, or as an
				 * attachment, that is downloaded and saved locally.
				 * 
				 */

				/**
				 * Here we have mentioned it to show inline
				 */
				response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

				 //Here we have mentioned it to show as attachment
				 //response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));

				response.setContentLength((int) file.length());

				InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

				FileCopyUtils.copy(inputStream, response.getOutputStream());

			}
		
	}
	
	@RequestMapping("/horario")
	public void download3 (HttpServletRequest request, HttpServletResponse response,
			@RequestParam(defaultValue="horario.pdf") String fileName ) throws IOException
	{
		File file = new File(EXTERNAL_FILE_PATH +"/"+ fileName);
			if (file.exists()) {

				//get the mimetype
				String mimeType = URLConnection.guessContentTypeFromName(file.getName());
				if (mimeType == null) {
					//unknown mimetype so set the mimetype to application/octet-stream
					mimeType = "application/pdf";
				}

				response.setContentType(mimeType);

				/**
				 * In a regular HTTP response, the Content-Disposition response header is a
				 * header indicating if the content is expected to be displayed inline in the
				 * browser, that is, as a Web page or as part of a Web page, or as an
				 * attachment, that is downloaded and saved locally.
				 * 
				 */

				/**
				 * Here we have mentioned it to show inline
				 */
				response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

				 //Here we have mentioned it to show as attachment
				 //response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));

				response.setContentLength((int) file.length());

				InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

				FileCopyUtils.copy(inputStream, response.getOutputStream());

			}
		
	}
	
//	public void modelos(Model model) {
//		model.addAttribute("alumnos", reposAl.findAll());
//		model.addAttribute("padres", padreRepo.findAll());
//		model.addAttribute("asignaturas", asigRepo.findAll());
//		model.addAttribute("aulas", reposAula.findAll());
//		model.addAttribute("profesores", profeRepo.findAll());
//	}

}
