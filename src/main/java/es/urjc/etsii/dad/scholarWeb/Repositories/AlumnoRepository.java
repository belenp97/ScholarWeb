package es.urjc.etsii.dad.scholarWeb.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.urjc.etsii.dad.scholarWeb.Alumno;
import es.urjc.etsii.dad.scholarWeb.Padre;
import es.urjc.etsii.dad.scholarWeb.Profesor;


public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

	Alumno saveAndFlush(Alumno updatedItem);
	//Alumno insertarAlumno(String Alumno);
	//Alumno findBynexpedienteEquals(long nexpediente);
	Alumno findBynombreEquals(String nombre);
	Alumno deleteByNexpediente(Integer nexp);
}
