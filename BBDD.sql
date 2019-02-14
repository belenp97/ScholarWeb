-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema ScholarWeb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ScholarWeb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ScholarWeb` DEFAULT CHARACTER SET utf8 ;
USE `ScholarWeb` ;

-- -----------------------------------------------------
-- Table `ScholarWeb`.`Aula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ScholarWeb`.`Aula` (
  `idAula` INT NOT NULL,
  `Curso` INT(1) NOT NULL,
  `Letra` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`idAula`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ScholarWeb`.`Padre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ScholarWeb`.`Padre` (
  `idPadre` INT NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  `Correo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPadre`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ScholarWeb`.`Alumno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ScholarWeb`.`Alumno` (
  `NExpediente` INT NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido1` VARCHAR(45) NOT NULL,
  `Apellido2` VARCHAR(45) NOT NULL,
  `Aula_idAula` INT NOT NULL,
  `Padre_idPadre` INT NOT NULL,
  `Faltas` INT NOT NULL,
  PRIMARY KEY (`NExpediente`),
  INDEX `fk_Alumno_Aula1_idx` (`Aula_idAula` ASC),
  INDEX `fk_Alumno_Padre1_idx` (`Padre_idPadre` ASC),
  CONSTRAINT `fk_Alumno_Aula1`
    FOREIGN KEY (`Aula_idAula`)
    REFERENCES `ScholarWeb`.`Aula` (`idAula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Alumno_Padre1`
    FOREIGN KEY (`Padre_idPadre`)
    REFERENCES `ScholarWeb`.`Padre` (`idPadre`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ScholarWeb`.`Profesor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ScholarWeb`.`Profesor` (
  `IdProfesor` INT NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido1` VARCHAR(45) NOT NULL,
  `Apellido2` VARCHAR(45) NOT NULL,
  `Correo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`IdProfesor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ScholarWeb`.`Relacion_Profesor_Alumno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ScholarWeb`.`Relacion_Profesor_Alumno` (
  `Alumno_NExp` INT NOT NULL,
  `Profesor_DNI` INT NOT NULL,
  PRIMARY KEY (`Alumno_NExp`, `Profesor_DNI`),
  INDEX `fk_Alumno_has_Profesor_Profesor1_idx` (`Profesor_DNI` ASC),
  INDEX `fk_Alumno_has_Profesor_Alumno_idx` (`Alumno_NExp` ASC),
  CONSTRAINT `fk_Alumno_has_Profesor_Alumno`
    FOREIGN KEY (`Alumno_NExp`)
    REFERENCES `ScholarWeb`.`Alumno` (`NExpediente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Alumno_has_Profesor_Profesor1`
    FOREIGN KEY (`Profesor_DNI`)
    REFERENCES `ScholarWeb`.`Profesor` (`IdProfesor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ScholarWeb`.`Asignatura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ScholarWeb`.`Asignatura` (
  `idAsignatura` INT NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Profesor_IdProfesor` INT NOT NULL,
  `Nota` INT NOT NULL,
  PRIMARY KEY (`idAsignatura`),
  INDEX `fk_Asignatura_Profesor1_idx` (`Profesor_IdProfesor` ASC),
  CONSTRAINT `fk_Asignatura_Profesor1`
    FOREIGN KEY (`Profesor_IdProfesor`)
    REFERENCES `ScholarWeb`.`Profesor` (`IdProfesor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ScholarWeb`.`Relacion_Alumno_ASignatura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ScholarWeb`.`Relacion_Alumno_ASignatura` (
  `Alumno_NExpediente` INT NOT NULL,
  `Asignatura_idAsignatura` INT NOT NULL,
  PRIMARY KEY (`Alumno_NExpediente`, `Asignatura_idAsignatura`),
  INDEX `fk_Alumno_has_Asignatura_Asignatura1_idx` (`Asignatura_idAsignatura` ASC),
  INDEX `fk_Alumno_has_Asignatura_Alumno1_idx` (`Alumno_NExpediente` ASC),
  CONSTRAINT `fk_Alumno_has_Asignatura_Alumno1`
    FOREIGN KEY (`Alumno_NExpediente`)
    REFERENCES `ScholarWeb`.`Alumno` (`NExpediente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Alumno_has_Asignatura_Asignatura1`
    FOREIGN KEY (`Asignatura_idAsignatura`)
    REFERENCES `ScholarWeb`.`Asignatura` (`idAsignatura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ScholarWeb`.`Relacion_Aula_Profesor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ScholarWeb`.`Relacion_Aula_Profesor` (
  `Aula_idAula` INT NOT NULL,
  `Profesor_IdProfesor` INT NOT NULL,
  PRIMARY KEY (`Aula_idAula`, `Profesor_IdProfesor`),
  INDEX `fk_Aula_has_Profesor_Aula1_idx` (`Aula_idAula` ASC),
  INDEX `fk_Relacion_Aula_Profesor_Profesor1_idx` (`Profesor_IdProfesor` ASC),
  CONSTRAINT `fk_Aula_has_Profesor_Aula1`
    FOREIGN KEY (`Aula_idAula`)
    REFERENCES `ScholarWeb`.`Aula` (`idAula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Relacion_Aula_Profesor_Profesor1`
    FOREIGN KEY (`Profesor_IdProfesor`)
    REFERENCES `ScholarWeb`.`Profesor` (`IdProfesor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ScholarWeb`.`Admininstrador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ScholarWeb`.`Admininstrador` (
  `idAdmininstrador` VARCHAR(9) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAdmininstrador`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ScholarWeb`.`Noticia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ScholarWeb`.`Noticia` (
  `Titulo` VARCHAR(150) NOT NULL,
  `Cuerpo` VARCHAR(500) NOT NULL)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
