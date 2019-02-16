package es.urjc.etsii.dad.scholarWeb.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
		return (List<Padre>) repository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Padre> addItem(@RequestBody Padre item) {
		item.setCorreo(null);
		Padre newItem = repository.saveAndFlush(item);
		return new ResponseEntity<>(newItem,HttpStatus.CREATED);
	}

	/*@RequestMapping(value = "/{Correo}", method = RequestMethod.PUT)
	public ResponseEntity<Padre> updateItem(@RequestBody Padre updatedItem,
			@PathVariable String correo) {
		
		updatedItem.setCorreo(correo);
		Padre item = repository.saveAndFlush(updatedItem);
		return new ResponseEntity<>(item,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{Correo}", method = RequestMethod.DELETE)
	public void deleteItem(@PathVariable String correo) {
		repository.deleteById(correo);
	}*/
}
