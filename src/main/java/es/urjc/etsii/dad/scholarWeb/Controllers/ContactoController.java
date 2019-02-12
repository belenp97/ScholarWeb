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

import es.urjc.etsii.dad.scholarWeb.Contacto;
import es.urjc.etsii.dad.scholarWeb.Repositories.ContactoRepository;


@RestController
@RequestMapping("/contactos")
public class ContactoController {

	@Autowired
	private ContactoRepository repository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Contacto> findItems() {
		return repository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Contacto> addItem(@RequestBody Contacto item) {
		item.setnombre(null);
		Contacto newItem = repository.saveAndFlush(item);
		return new ResponseEntity<>(newItem,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{nombre}", method = RequestMethod.PUT)
	public ResponseEntity<Contacto> updateItem(@RequestBody Contacto updatedItem,
			@PathVariable String nombre) {
		
		updatedItem.setnombre(nombre);
		Contacto item = repository.saveAndFlush(updatedItem);
		return new ResponseEntity<>(item,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{nombre}", method = RequestMethod.DELETE)
	public void deleteItem(@PathVariable String nombre) {
		repository.deleteById(nombre);
	}
}
