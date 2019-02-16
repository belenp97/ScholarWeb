/*package es.urjc.etsii.dad.scholarWeb.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.urjc.etsii.dad.scholarWeb.Asignatura;
import es.urjc.etsii.dad.scholarWeb.Repositories.AsignaturaRepository;

@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {

	
	@Autowired
	private AsignaturaRepository repository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Asignatura> findItems() {
		return (List<Asignatura>) repository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Asignatura> addItem(@RequestBody Asignatura item) {
		item.setNombre(null);
		Asignatura newItem = repository.saveAndFlush(item);
		return new ResponseEntity<>(newItem,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{nombre}", method = RequestMethod.PUT)
	public ResponseEntity<Asignatura> updateItem(@RequestBody Asignatura updatedItem,
			@PathVariable String nombre) {
		
		updatedItem.setNombre(nombre);
		Asignatura item = repository.saveAndFlush(updatedItem);
		return new ResponseEntity<>(item,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{nombre}", method = RequestMethod.DELETE)
	public void deleteItem(@PathVariable String nombre) {
		repository.deleteById(nombre);
	}
}*/
