package es.urjc.etsii.dad.scholarWeb.Controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.urjc.etsii.dad.scholarWeb.Asignatura;
import es.urjc.etsii.dad.scholarWeb.Repositories.AsignaturaRepository;

@RestController
public class AsignaturaController {
	
	@Autowired
	private AsignaturaRepository repository;
	
	@PostConstruct
	public void init() {
		repository.save(new Asignatura("Matematicas",2));
		repository.save(new Asignatura("Ingles",1));
		repository.save(new Asignatura("Física",4));
	}

	public List<Asignatura> findItems() {
		return (List<Asignatura>) repository.findAll();
	}

	public ResponseEntity<Asignatura> addItem(@RequestBody Asignatura item) {
		item.setNombre(null);
		Asignatura newItem = repository.saveAndFlush(item);
		return new ResponseEntity<>(newItem,HttpStatus.CREATED);
	}

	/*@RequestMapping(value = "/{nombre}", method = RequestMethod.PUT)
	public ResponseEntity<Asignatura> updateItem(@RequestBody Asignatura updatedItem,
			@PathVariable String nombre) {
		
		updatedItem.setNombre(nombre);
		Asignatura item = repository.saveAndFlush(updatedItem);
		return new ResponseEntity<>(item,HttpStatus.CREATED);
	}*/

	/*@RequestMapping(value = "/{nombre}", method = RequestMethod.DELETE)
	public void deleteItem(@PathVariable String nombre) {
		repository.deleteById(nombre);
	}*/
}
