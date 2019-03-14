package es.urjc.etsii.dad.scholarWeb;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.urjc.etsii.dad.scholarWeb.Repositories.AlumnoRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AsignaturaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AulaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.PadreRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.ProfesorRepository;

@Controller
public class PrincipalControler {
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
	public String principal(Model model) {
		
		return "principal";
	}
	
//	public void modelos(Model model) {
//		model.addAttribute("alumnos", reposAl.findAll());
//		model.addAttribute("padres", padreRepo.findAll());
//		model.addAttribute("asignaturas", asigRepo.findAll());
//		model.addAttribute("aulas", reposAula.findAll());
//		model.addAttribute("profesores", profeRepo.findAll());
//	}

}
