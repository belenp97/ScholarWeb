package es.urjc.etsii.dad.scholarWeb.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Padre;
import es.urjc.etsii.dad.scholarWeb.Profesor;

public interface PadreRepository extends JpaRepository<Padre, Integer> {

	//Padre saveAndFlush(Padre item);
	Padre findBycorreoEquals(String correo);
	Padre findByNombreEquals(String nombre);
}
