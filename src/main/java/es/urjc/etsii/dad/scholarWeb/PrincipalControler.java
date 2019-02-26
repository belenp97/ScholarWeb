package es.urjc.etsii.dad.scholarWeb;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


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

	// faltaría contacto.

	
	
	public PrincipalControler() {
	}

	@PostConstruct
	public void init() {
		
		/*Alumno alumn = new Alumno("Juan", "Perez", "Gomez");
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
		reposAl.save(alumn3);*/
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

	@RequestMapping("/alumnos")
	public String verAlumnos(Model model) throws Exception {

		model.addAttribute("alumno", reposAl.findAll());

		return "alumnos";
	}

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

		return "login";
	}

	@PostMapping("/login/privado")
	public String loginPrivado(Model model) {

		return "login_privado";
	}
	
	@RequestMapping(value="/administrador")
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
	public String insertar_alumno(Model model, @RequestParam String nombre,@RequestParam String apellido1,@RequestParam String apellido2) {
		//model.addAttribute("alumnos", reposAl.findAll());
		modelos(model);
		
		Alumno alumno = new Alumno( nombre, apellido1, apellido2);
		reposAl.save(alumno); 
		
		return "administrador";
	}
	
	@RequestMapping(value= "/eliminar_alumno" )
	public String eliminar_alumno(Model model, @RequestParam String nombre, @RequestParam String apellido1, @RequestParam String apellido2) {
		//model.addAttribute("alumnos", reposAl.findAll());
		modelos(model);
		
		try {
			Alumno alumno = new Alumno(nombre, apellido1, apellido2);
				reposAl.delete(reposAl.findBynombreEquals(alumno.getNombre()));
			
		}catch(Exception e) {
			e.printStackTrace();
		}

		return "administrador";
	}

	@RequestMapping(value="/insertar_padre")
	public String insertar_padre(Model model, @RequestParam String correo,@RequestParam String apellido,@RequestParam String nombre, String nombreA /*long nexpediente*/) {
		//alumno = (Alumno) reposAl.findAll(); 
		modelos(model);
		try {
			Padre padre = new Padre( correo, apellido, nombre);
			//Alumno a= reposAl.findBynexpedienteEquals(nexpediente);
			Alumno a= reposAl.findBynombreEquals(nombreA);
			padre.getAlumno().add(a);
			a.setPadre(padre);
			padreRepo.save(padre); 
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return "administrador";
	}
	
	@RequestMapping(value="/eliminar_padre")
	public String eliminar_padre(Model model, @RequestParam String correo,@RequestParam String apellido,@RequestParam String nombre) {
		//alumno = (Alumno) reposAl.findAll(); 
		modelos(model);
		try {
			Padre p = new Padre(correo, apellido, nombre);
			padreRepo.delete(padreRepo.findBycorreoEquals(p.getCorreo()));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "administrador";
	}

	@RequestMapping(value="/insertar_profesor")
	public String insertar_profesor(Model model, @RequestParam String nombre,@RequestParam String apellido1,@RequestParam String apellido2, @RequestParam String correo) {
		modelos(model);
		try {
			Profesor profesor = new Profesor( nombre, apellido1, apellido2, correo);
			profeRepo.save(profesor); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "administrador";
	}
	
	@RequestMapping(value="/eliminar_profesor")
	public String eliminar_profesor(Model model, @RequestParam String nombre,@RequestParam String apellido1,@RequestParam String apellido2, @RequestParam String correo) {
		//alumno = (Alumno) reposAl.findAll(); 
		modelos(model);
		try {
			Profesor profesor = new Profesor( nombre, apellido1, apellido2, correo);
			profeRepo.delete(profeRepo.findBynombreEquals(profesor.getNombre()));
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return "administrador";
	}
	
	@RequestMapping(value="/insertar_aula")
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
	
	@RequestMapping(value="/insertar_asignatura")
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
	
	@RequestMapping(value="/eliminar_asignatura")
	public String eliminar_asignatura(Model model, @RequestParam String nombre,@RequestParam int curso) {
		modelos(model);
		try {
			Asignatura asignatura = new Asignatura( nombre, curso);
			asigRepo.delete(asigRepo.findBynombreEquals(asignatura.getNombre())); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "administrador";
	}
	
	@RequestMapping(value="/insertar_noticia")
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
	
	@RequestMapping(value="/eliminar_noticia")
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
