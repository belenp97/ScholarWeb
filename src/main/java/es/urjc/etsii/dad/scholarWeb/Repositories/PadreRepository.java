package es.urjc.etsii.dad.scholarWeb.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Alumno;
import es.urjc.etsii.dad.scholarWeb.Padre;
import es.urjc.etsii.dad.scholarWeb.Profesor;
import es.urjc.etsii.dad.scholarWeb.Usuario;

public interface PadreRepository extends JpaRepository<Padre, Integer> {

	//Padre saveAndFlush(Padre item);
	Padre findBycorreoEquals(String correo);
	Padre findByNombreEquals(String nombre);
	Padre saveAndFlush(Usuario padre);
	Padre findById(Integer id);
	Padre deleteById(Integer id);
}
