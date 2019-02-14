package es.urjc.etsii.dad.scholarWeb.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.urjc.etsii.dad.scholarWeb.Profesor;
import es.urjc.etsii.dad.scholarWeb.Repositories.ProfesorRepository;


@RestController
@RequestMapping("/profesores")
public class ProfesorController {

	@Autowired
	private ProfesorRepository repository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Profesor> findItems() {
		return (List<Profesor>) repository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Profesor> addItem(@RequestBody Profesor item) {
		item.setIdentificador(null);
		Profesor newItem = repository.saveAndFlush(item);
		return new ResponseEntity<>(newItem,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{identificador}", method = RequestMethod.PUT)
	public ResponseEntity<Profesor> updateItem(@RequestBody Profesor updatedItem,
			@PathVariable Integer id) {
		
		updatedItem.setIdentificador(id);
		Profesor item = repository.saveAndFlush(updatedItem);
		return new ResponseEntity<>(item,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{identificador}", method = RequestMethod.DELETE)
	public void deleteItem(@PathVariable Integer id) {
		repository.deleteById(id);
	}
}
