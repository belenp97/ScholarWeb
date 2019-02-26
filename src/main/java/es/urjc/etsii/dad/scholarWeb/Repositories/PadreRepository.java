package es.urjc.etsii.dad.scholarWeb.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Padre;

public interface PadreRepository extends JpaRepository<Padre, String> {

	Padre saveAndFlush(Padre item);
	Padre findBycorreoEquals(String correo);

}
