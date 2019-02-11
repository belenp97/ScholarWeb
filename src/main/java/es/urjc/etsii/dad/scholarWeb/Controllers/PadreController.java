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

import es.urjc.etsii.dad.scholarWeb.Padre;
import es.urjc.etsii.dad.scholarWeb.Repositories.PadreRepository;

@RestController
@RequestMapping("/padres")
public class PadreController {

	@Autowired
	private PadreRepository repository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Padre> findItems() {
		return repository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Padre> addItem(@RequestBody Padre item) {
		//item.setId(null);
		Padre newItem = repository.saveAndFlush(item);
		return new ResponseEntity<>(newItem,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Padre> updateItem(@RequestBody Padre updatedItem,
			@PathVariable Integer id) {
		
		//updatedItem.setId(id);
		Padre item = repository.saveAndFlush(updatedItem);
		return new ResponseEntity<>(item,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteItem(@PathVariable Integer id) {
		//repository.delete(id);
	}
}
