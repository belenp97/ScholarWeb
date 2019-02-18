package es.urjc.etsii.dad.scholarWeb.Controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.urjc.etsii.dad.scholarWeb.Alumno;
import es.urjc.etsii.dad.scholarWeb.Aula;
import es.urjc.etsii.dad.scholarWeb.Repositories.AlumnoRepository;
import es.urjc.etsii.dad.scholarWeb.Repositories.AulaRepository;


@RestController
public class AlumnoController {
	
	@Autowired
	private AlumnoRepository repository;
	
	@Autowired
	private AulaRepository reposAl;
	
	/*@PostConstruct
	public void init() {
		Alumno a= new Alumno("Juan", "Perez", "Gomez");	
		Alumno a2= new Alumno("Ana", "Martin","Lopez");
		Alumno a3= new Alumno("Elena","Vazquez","Rodriguez");
		
		a.setAula(new Aula(1,'a'));
		reposAl.save(a.getAula());
			
		repository.save(a);
		repository.save(a2);
		repository.save(a3);
	}*/
	

	/*@RequestMapping(method = RequestMethod.GET)
	public List<Alumno> findItems() {
		return (List<Alumno>) repository.findAll();
	}*/

	//@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Alumno> addItem(@RequestBody Alumno item) {
		item.setNexpediente((Long) null);
		Alumno newItem = repository.saveAndFlush(item);
		return new ResponseEntity<>(newItem,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/updateItem", method = RequestMethod.PUT)
	public ResponseEntity<Alumno> updateItem(@RequestBody Alumno updatedItem,
			@PathVariable Integer id) {
		
		updatedItem.setNexpediente(id);
		Alumno item = repository.saveAndFlush(updatedItem);
		return new ResponseEntity<>(item,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/deleteItem", method = RequestMethod.DELETE)
	public void deleteItem(@PathVariable Integer id) {
		repository.deleteById(id);
	}
}
