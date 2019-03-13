package es.urjc.etsii.dad.scholarWeb.Controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.etsii.dad.scholarWeb.Administrador;
import es.urjc.etsii.dad.scholarWeb.Alumno;
import es.urjc.etsii.dad.scholarWeb.Asignatura;
import es.urjc.etsii.dad.scholarWeb.Repositories.AdminRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AlumnoRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AsignaturaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AulaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.NoticiaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.PadreRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.ProfesorRepository;


@Controller
@RequestMapping("/login")
class LoginController {
	
	@Autowired
	private AdminRepository adminRepo;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("admin", adminRepo.findAll());
		
		return "login";
	}
	
	@RequestMapping(value="/{nombre}", method=RequestMethod.POST)
	public String loginPrivado(Model model, @RequestParam String correo, @RequestParam String contraseña) {
		try {
			/*Administrador administrador = adminRepo.findByCorreo(correo);
			if(administrador.getPass().equals(contraseña)) {*/
				return "/login_privado"; 
//			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "loginError";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(Model model, HttpServletRequest request) {
		try {
			request.logout();
			return "/login";
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return "/";
		
	}

}
