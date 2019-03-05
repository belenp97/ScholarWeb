package es.urjc.etsii.dad.scholarWeb;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import es.urjc.etsii.dad.scholarWeb.Repositories.AdminRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AlumnoRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AsignaturaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AulaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.NoticiaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.PadreRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.ProfesorRepository;

@Controller
public class PrincipalControler {
	
	
	@Autowired
	private NoticiaRepository notRepo;

	@Autowired
	private AlumnoRepository reposAl;

	@Autowired
	private AsignaturaRepository asigRepo;

	@Autowired
	private AulaRepository reposAula;

	@Autowired
	private PadreRepository padreRepo;

	@Autowired
	private ProfesorRepository profeRepo;

	@Autowired
	private AdminRepository adminRepo;

	
	
	public PrincipalControler() {
	}

	@PostConstruct
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
	}
	
	//clase con los model 
	public void modelos(Model model) {
		model.addAttribute("alumnos", reposAl.findAll());
		model.addAttribute("padres", padreRepo.findAll());
		model.addAttribute("asignaturas", asigRepo.findAll());
		model.addAttribute("noticias", notRepo.findAll());
		model.addAttribute("aulas", reposAula.findAll());
		model.addAttribute("profesores", profeRepo.findAll());
	}

	@GetMapping("/")
	public String principal(Model model) {

		return "principal";
	}

	@RequestMapping("/noticias")
	public String verNoticia(Model model, @RequestParam(required = false) String name) throws Exception {

		model.addAttribute("noticia", notRepo.findAll());

		return "noticias";
	}

//	@RequestMapping("/alumnos")
//	public String verAlumnos(Model model) throws Exception {
//
//		model.addAttribute("alumno", reposAl.findAll());
//
//		return "alumnos";
//	}

	@RequestMapping("/profesores")
	public String verprofesores(Model model) {

		model.addAttribute("profe", profeRepo.findAll());

		return "profesores";
	}

	@GetMapping("/contacto")
	public String newContacto(Model model) {

		return "contacto";// llamarlo como se llama el html
	}

	@PostMapping("/contacto/recibido")
	public String contactoRecibido(Model model) {

		return "contacto_recibido";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("admin", adminRepo.findAll());
		
		return "login";
	}

	@PostMapping("/login/{nombre}")
	public String loginPrivado(Model model, @RequestParam String correo, @RequestParam String contraseña) {
		try {
			Administrador administrador = adminRepo.findByCorreo(correo);
			if(administrador.getContraseña().equals(contraseña)) {
				return "/login_privado"; 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "loginError";
	}
	
	@RequestMapping("/administrador")
	public String administrador(Model model) {
		
		modelos(model);
		/*model.addAttribute("alumnos", reposAl.findAll());
		model.addAttribute("padres", padreRepo.findAll());
		model.addAttribute("asignaturas", asigRepo.findAll());
		model.addAttribute("noticias", notRepo.findAll());
		model.addAttribute("aulas", reposAula.findAll());
		model.addAttribute("profesores", profeRepo.findAll());*/

		return "administrador";
	}
	
	@RequestMapping("/insertar_alumno")
	public String insertar_alumno(Model model, @RequestParam String nombre,@RequestParam String apellido1, @RequestParam String apellido2, @RequestParam String idasig, @RequestParam Integer id) {
		//model.addAttribute("alumnos", reposAl.findAll());
		modelos(model);
		try {
			Optional<Aula> aul = reposAula.findById(id);
			Optional<Asignatura> asig = asigRepo.findById(id);
			Asignatura asignatura = asig.get(); 
			Aula a = aul.get(); 
			Alumno alumno = new Alumno(nombre, apellido1, apellido2, asignatura, a);
			reposAl.save(alumno); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "administrador";
	}
	
	@RequestMapping("/eliminar_alumno" )
	public String eliminar_alumno(Model model, @RequestParam Integer nexp) {
		modelos(model);
		try {
			Optional<Alumno> alumno = reposAl.findById(nexp);
			Padre p = alumno.get().getPadre(); 
			if(p != null) {
				padreRepo.delete(p);
			}
			reposAl.deleteById(nexp); 
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "administrador";
	}

	@RequestMapping("/insertar_padre")
	public String insertar_padre(Model model, @RequestParam String correo,@RequestParam String apellido, @RequestParam String nombre, String nombreA ) {
		modelos(model);
		
		try {
			Alumno a= reposAl.findBynombreEquals(nombreA);
			Padre padre = new Padre( correo, apellido, nombre, a);
			a.setPadre(padre);
			padreRepo.saveAndFlush(padre); 
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return "administrador";
	}
	
	@RequestMapping("/eliminar_padre")
	public String eliminar_padre(Model model, @RequestParam Integer id_padre) {
		modelos(model);
		try {
			if(id_padre < 0) {
				padreRepo.deleteById(id_padre);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "administrador";
	}

	@RequestMapping("/insertar_profesor")
	public String insertar_profesor(Model model, @RequestParam String nombre,@RequestParam String apellido1,@RequestParam String apellido2, @RequestParam String correo, @RequestParam String asignatura, @RequestParam Integer id_alumno, @RequestParam Integer id_aula) {
		modelos(model);
		try {
			Optional<Aula> aula = reposAula.findById(id_aula);
			Aula aul = aula.get();
			Optional<Alumno> alumno = reposAl.findById(id_alumno);
			Alumno a = alumno.get(); 
			Asignatura asig = asigRepo.findBynombreEquals(asignatura);
			Profesor profesor = new Profesor( nombre, apellido1, apellido2, correo, asig, a, aul);
			profeRepo.save(profesor); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "administrador";
	}
	
	@RequestMapping("/eliminar_profesor")
	public String eliminar_profesor(Model model, @RequestParam Integer id_profesor) {
		modelos(model);
		try {
			profeRepo.deleteById(id_profesor);
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return "administrador";
	}
	
	@RequestMapping("/insertar_aula")
	public String insertar_aula(Model model, @RequestParam Integer curso,@RequestParam Character letra) {
		modelos(model);
		try {
			Aula aula = new Aula(curso,letra);
			reposAula.save(aula); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "administrador";
	}
	
	/*@RequestMapping(value="/eliminar_aula")
	public String eliminar_aula(Model model, @RequestParam int curso,@RequestParam char letra) {
		modelos(model);
		try {
			//Aula aula = new Aula(curso,letra);
			//reposAula.delete(reposAula.findBycursoEquals(aula.getCurso())); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "administrador";
	}*/
	
	@RequestMapping("/insertar_asignatura")
	public String insertar_asignatura(Model model, @RequestParam String nombre,@RequestParam int curso) {
		modelos(model);
		try {
			Asignatura asignatura = new Asignatura( nombre, curso);
			asigRepo.save(asignatura); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "administrador";
	}
	
	@RequestMapping("/eliminar_asignatura")
	public String eliminar_asignatura(Model model, @RequestParam Integer id) {
		modelos(model);
		try {
			asigRepo.deleteById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "administrador";
	}
	
	@RequestMapping("/insertar_noticia")
	public String insertar_noticia(Model model, @RequestParam String titulo,@RequestParam String cuerpo) {
		modelos(model);
		try {
			Noticia noticia = new Noticia( titulo, cuerpo);
			notRepo.save(noticia); 
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return "administrador";
	}
	
	@RequestMapping("/eliminar_noticia")
	public String eliminar_noticia(Model model,@RequestParam String titulo) {
		//alumno = (Alumno) reposAl.findAll(); 
		modelos(model);
		try {
			Noticia noticia = new Noticia( titulo);
			notRepo.delete(notRepo.findBytituloEquals(noticia.gettitulo()));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "administrador";
	}
}
