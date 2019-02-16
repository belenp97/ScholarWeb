package es.urjc.etsii.dad.scholarWeb;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.urjc.etsii.dad.scholarWeb.Repositories.AlumnoRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AsignaturaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AulaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.NoticiaRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.PadreRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.ProfesorRepository;

@SpringBootApplication
public class ScholarWebApplication{
	
	@Autowired
	AlumnoRepository alumnRepo; 
	
	@Autowired
	AsignaturaRepository asignaturaRepo; 
	
	@Autowired
	AulaRepository aulaRepo; 
	
	@Autowired
	NoticiaRepository noticeRepo; 
	
	@Autowired
	PadreRepository padreRepo; 
	
	@Autowired
	ProfesorRepository profeRepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ScholarWebApplication.class, args);
	}

	public void run(String...arg0) throws Exception{
		mostrarDatos();
	}
	
	
    @Transactional
    private void mostrarDatos() {
    	
    	alumnRepo.findAll(); 
    	asignaturaRepo.findAll(); 
    	aulaRepo.findAll(); 
    	noticeRepo.findAll(); 
    	padreRepo.findAll(); 
    	profeRepo.findAll(); 
	}

}

