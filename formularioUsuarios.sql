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
-- Table structure for table `alumno_asignaturas`
--

DROP TABLE IF EXISTS `alumno_asignaturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `alumno_asignaturas` (
  `alumnos` int(11) NOT NULL,
  `asignaturas` int(11) NOT NULL,
  KEY `FKo5ubv9181a5iis9sh6rlyl8aa` (`asignaturas`),
  KEY `FKice4rphdleok6m9nm699csekn` (`alumnos`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno_asignaturas`
--

LOCK TABLES `alumno_asignaturas` WRITE;
/*!40000 ALTER TABLE `alumno_asignaturas` DISABLE KEYS */;
INSERT INTO `alumno_asignaturas` VALUES (2,1),(5,1),(8,1),(24,2);
/*!40000 ALTER TABLE `alumno_asignaturas` ENABLE KEYS */;
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
  `profesor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdru875ovqxlv83iuiwrpmc4nh` (`profesor`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignatura`
--

LOCK TABLES `asignatura` WRITE;
/*!40000 ALTER TABLE `asignatura` DISABLE KEYS */;
INSERT INTO `asignatura` VALUES (1,1,'Ingles',0,NULL),(2,1,'Frances',0,NULL),(3,1,'Tecnologia',0,NULL),(4,1,'Conocimiento del Medio',0,NULL);
/*!40000 ALTER TABLE `asignatura` ENABLE KEYS */;
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
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aula`
--

LOCK TABLES `aula` WRITE;
/*!40000 ALTER TABLE `aula` DISABLE KEYS */;
INSERT INTO `aula` VALUES (1,1,'A'),(2,1,'B');
/*!40000 ALTER TABLE `aula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (33);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
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
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `noticia`
--

LOCK TABLES `noticia` WRITE;
/*!40000 ALTER TABLE `noticia` DISABLE KEYS */;
/*!40000 ALTER TABLE `noticia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesores_por_alumno`
--

DROP TABLE IF EXISTS `profesores_por_alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `profesores_por_alumno` (
  `profesor` int(11) NOT NULL,
  `alumno` int(11) NOT NULL,
  KEY `FKa8gtwy4xi6401dfo7vyvjsr2l` (`alumno`),
  KEY `FKhcq1hrt2gfmirx76ijmyru64u` (`profesor`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesores_por_alumno`
--

LOCK TABLES `profesores_por_alumno` WRITE;
/*!40000 ALTER TABLE `profesores_por_alumno` DISABLE KEYS */;
INSERT INTO `profesores_por_alumno` VALUES (19,8),(20,8),(21,8),(22,8),(23,8),(29,24);
/*!40000 ALTER TABLE `profesores_por_alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesores_por_aula`
--

DROP TABLE IF EXISTS `profesores_por_aula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `profesores_por_aula` (
  `profesor` int(11) NOT NULL,
  `aula` int(11) NOT NULL,
  KEY `FKg4vfclpd8ymo70s0n0pw9f9u5` (`aula`),
  KEY `FKgchojgq5sa64xbkfc8jgntm2x` (`profesor`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesores_por_aula`
--

LOCK TABLES `profesores_por_aula` WRITE;
/*!40000 ALTER TABLE `profesores_por_aula` DISABLE KEYS */;
INSERT INTO `profesores_por_aula` VALUES (19,1),(20,1),(21,1),(22,1),(23,1),(29,2);
/*!40000 ALTER TABLE `profesores_por_aula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario` (
  `dtype` varchar(31) NOT NULL,
  `id` int(11) NOT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `pass` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  `apellido1` varchar(255) DEFAULT NULL,
  `apellido2` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `faltas` int(11) DEFAULT NULL,
  `aula` int(11) DEFAULT NULL,
  `padre` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK33kx3b1yegcik4qli8231g44y` (`aula`),
  KEY `FK90xwf4j1u6mqjxs4f02kqdyja` (`padre`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('Alumno',8,'jav@gmail.com','Jorge','$2a$10$MT/zd4rOwGbu0QmK7Hvbo.A//rn3Mj/.2ZTdwDaHw4SlKYl6C0IcK','ALUMNO','Alonso','Vivar',NULL,0,1,1),('Padre',1,'esteban.alonso@gmail.com','Esteban','$2a$10$GwGx7clVI.gzWWz7uY4I8e0mELDaN2Y6PDuuQGKajl01ey8b8b1SW','PADRE',NULL,NULL,'Alonso',NULL,NULL,NULL),('Padre',25,'mirian.lopez@gmail.com','Mirian','$2a$10$WwTqdwLL.u8Z9BSfJB4AK.uAywKgrtf.xsWUOhGzKtufeAJQhohSO','PADRE',NULL,NULL,'Lopez',NULL,NULL,NULL),('Profesor',23,'flor.ramirez@gmail.com','Flor','$2a$10$g3u0SuhARaXPflQZirDOHOHeSg6t9GKrzXH57ZZWBVbHIR6opxTfa','PROFESOR','Ramirez','Pereira',NULL,NULL,NULL,NULL),('Alumno',24,'plm@gmail.com','Pepe','$2a$10$UkmB45WdrrNhsQw37vG2yOFtdrn7Nv.YPXOT5SyOZrake0y2OdTDS','ALUMNO','Lopez','Martin',NULL,0,2,NULL),('Profesor',29,'juan.perez@gmail.com','Juan','$2a$10$H1jadsSXUvHeNbyaUtMXcuXlzWt1/QXVbMMewAj47XKnS266dBrzy','PROFESOR','Perez','Yuste',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_roles`
--

DROP TABLE IF EXISTS `usuario_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario_roles` (
  `usuario_id` int(11) NOT NULL,
  `roles` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`usuario_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_roles`
--

LOCK TABLES `usuario_roles` WRITE;
/*!40000 ALTER TABLE `usuario_roles` DISABLE KEYS */;
INSERT INTO `usuario_roles` VALUES (1,'USER'),(8,'USER'),(25,'USER'),(24,'USER'),(29,'USER');
/*!40000 ALTER TABLE `usuario_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-15 18:45:58
