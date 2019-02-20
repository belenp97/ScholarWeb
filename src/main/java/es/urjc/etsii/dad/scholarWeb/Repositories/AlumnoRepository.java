package es.urjc.etsii.dad.scholarWeb.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.dad.scholarWeb.Alumno;


public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

	//Alumno saveAndFlush(Alumno updatedItem);
	//Alumno insertarAlumno(String Alumno);
	Alumno findBynombreEquals(String name);

}
