package es.urjc.etsii.dad.scholarWeb;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.Optional;

import javax.servlet.annotation.WebFilter;
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
import org.springframework.web.bind.annotation.RequestMethod;
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
	private static final String EXTERNAL_FILE_PATH = "./";

	@Autowired
	private UsuarioRepository repos;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String principal(Model model, HttpServletRequest request, HttpSession sesion) {
		if(request.isUserInRole("ROLE_")) {
    		Usuario user = repos.findByNombre(request.getUserPrincipal().getName());
    		model.addAttribute("username", user.getNombre());
    		model.addAttribute("administrador", request.isUserInRole("ADMIN"));
    		model.addAttribute("profes", request.isUserInRole("PROFESOR"));
		}
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
