package es.urjc.etsii.dad.scholarWeb.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Administrador;

public interface AdminRepository extends JpaRepository<Administrador, Integer>{
	
	Administrador saveAndFlush(Administrador updatedItem);
	Administrador findByCorreo(String correo);
	
	

}
