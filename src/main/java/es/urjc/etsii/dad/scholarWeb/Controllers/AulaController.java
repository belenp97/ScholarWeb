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

import es.urjc.etsii.dad.scholarWeb.Aula;
import es.urjc.etsii.dad.scholarWeb.Repositories.AulaRepository;

@RestController
@RequestMapping("/aulas")
public class AulaController {
	
	@Autowired
	private AulaRepository repository;
	
	/*@PostConstruct
	public void init() {
		repository.save(new Aula(1,'A'));
		repository.save(new Aula(1,'B'));
		repository.save(new Aula(1,'C'));
		repository.save(new Aula(2,'A'));
		repository.save(new Aula(2,'B'));
		repository.save(new Aula(2,'C'));
		repository.save(new Aula(3,'A'));
		repository.save(new Aula(3,'B'));
		repository.save(new Aula(3,'C'));
		repository.save(new Aula(4,'A'));
		repository.save(new Aula(4,'B'));
		repository.save(new Aula(4,'C'));
	}*/
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Aula> findItems() {
		return (List<Aula>) repository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Aula> addItem(@RequestBody Aula item) {
		item.setIdAula(null);
		Aula newItem = repository.saveAndFlush(item);
		return new ResponseEntity<>(newItem,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{IdAula}", method = RequestMethod.PUT)
	public ResponseEntity<Aula> updateItem(@RequestBody Aula updatedItem,
			@PathVariable Integer id) {
		
		updatedItem.setIdAula(id);
		Aula item = repository.saveAndFlush(updatedItem);
		return new ResponseEntity<>(item,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{IdAula}", method = RequestMethod.DELETE)
	public void deleteItem(@PathVariable Integer id) {
		repository.deleteById(id);
	}

}
