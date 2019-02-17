-- MySQL dump 10.13  Distrib 8.0.15, for macos10.14 (x86_64)
--
-- Host: localhost    Database: scholarweb
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `administrador` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `alumnos` (
  `nexpediente` int(11) NOT NULL AUTO_INCREMENT,
  `apellido1` varchar(255) DEFAULT NULL,
  `apellido2` varchar(255) DEFAULT NULL,
  `faltas` int(11) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `aula` int(11) DEFAULT NULL,
  `padre_alumno` int(11) DEFAULT NULL,
  PRIMARY KEY (`nexpediente`),
  KEY `FKr3tignrsfaexh4rib5ikj0l0a` (`aula`),
  KEY `FKcy17tjd11kiawaefx6kxgwufw` (`padre_alumno`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos`
--

LOCK TABLES `alumnos` WRITE;
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` VALUES (1,'Perez','Gomez',0,'Juan',NULL,NULL);
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumnos_profesore_por_alumno`
--

DROP TABLE IF EXISTS `alumnos_profesore_por_alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `alumnos_profesore_por_alumno` (
  `alumnos_por_profesor` int(11) NOT NULL,
  `profesore_por_alumno` int(11) NOT NULL,
  KEY `FKlvd551sk5ug2e3rb9ffia45oe` (`profesore_por_alumno`),
  KEY `FK4kcw0scaapb4qnbe49xppgmso` (`alumnos_por_profesor`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos_profesore_por_alumno`
--

LOCK TABLES `alumnos_profesore_por_alumno` WRITE;
/*!40000 ALTER TABLE `alumnos_profesore_por_alumno` DISABLE KEYS */;
/*!40000 ALTER TABLE `alumnos_profesore_por_alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asignatura`
--

DROP TABLE IF EXISTS `asignatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `asignatura` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `curso` int(11) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `notas` int(11) DEFAULT NULL,
  `profesor_por_asignatura` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkl9lvv5gwl2y4lcbg6mahvgu1` (`profesor_por_asignatura`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignatura`
--

LOCK TABLES `asignatura` WRITE;
/*!40000 ALTER TABLE `asignatura` DISABLE KEYS */;
INSERT INTO `asignatura` VALUES (1,2,'Matematicas',0,NULL),(2,1,'Ingles',0,NULL),(3,4,'Física',0,NULL);
/*!40000 ALTER TABLE `asignatura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asignatura_alumno`
--

DROP TABLE IF EXISTS `asignatura_alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `asignatura_alumno` (
  `asignaturas` int(11) NOT NULL,
  `alumno` int(11) NOT NULL,
  KEY `FKdsnihbgshe383vgo9s674nsew` (`alumno`),
  KEY `FK305l4f0sy1391isoc5g5l3eha` (`asignaturas`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignatura_alumno`
--

LOCK TABLES `asignatura_alumno` WRITE;
/*!40000 ALTER TABLE `asignatura_alumno` DISABLE KEYS */;
/*!40000 ALTER TABLE `asignatura_alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aula`
--

DROP TABLE IF EXISTS `aula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `aula` (
  `id_aula` int(11) NOT NULL AUTO_INCREMENT,
  `curso` int(11) DEFAULT NULL,
  `letra` char(1) DEFAULT NULL,
  PRIMARY KEY (`id_aula`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aula`
--

LOCK TABLES `aula` WRITE;
/*!40000 ALTER TABLE `aula` DISABLE KEYS */;
INSERT INTO `aula` VALUES (1,1,'A');
/*!40000 ALTER TABLE `aula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aula_profesores_curso`
--

DROP TABLE IF EXISTS `aula_profesores_curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `aula_profesores_curso` (
  `aulas` int(11) NOT NULL,
  `profesores_curso` int(11) NOT NULL,
  KEY `FKi2wuowl1awm6j6vonha7hdy6m` (`profesores_curso`),
  KEY `FKaqkj681o5t2ll068aw5g6g85` (`aulas`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aula_profesores_curso`
--

LOCK TABLES `aula_profesores_curso` WRITE;
/*!40000 ALTER TABLE `aula_profesores_curso` DISABLE KEYS */;
/*!40000 ALTER TABLE `aula_profesores_curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `noticia`
--

DROP TABLE IF EXISTS `noticia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `noticia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cuerpo` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `noticia`
--

LOCK TABLES `noticia` WRITE;
/*!40000 ALTER TABLE `noticia` DISABLE KEYS */;
INSERT INTO `noticia` VALUES (1,'es una noticia importante para los padres','Importante'),(2,'cada alumno tendra un menu especializado, respecto a sus intolerancias','Padres');
/*!40000 ALTER TABLE `noticia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `padre`
--

DROP TABLE IF EXISTS `padre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `padre` (
  `id_padre` int(11) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_padre`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `padre`
--

LOCK TABLES `padre` WRITE;
/*!40000 ALTER TABLE `padre` DISABLE KEYS */;
/*!40000 ALTER TABLE `padre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `profesor` (
  `identificador` int(11) NOT NULL AUTO_INCREMENT,
  `apellido1` varchar(255) DEFAULT NULL,
  `apellido2` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`identificador`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (1,'Gomez','Martin','pgm@gmail.com','Pedro');
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-17 12:29:39
