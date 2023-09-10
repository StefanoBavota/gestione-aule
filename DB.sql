CREATE DATABASE  IF NOT EXISTS `aule-web` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `aule-web`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: aule-web
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `asset_room`
--

DROP TABLE IF EXISTS `asset_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asset_room` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `asset_id` bigint NOT NULL,
  `room_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhn8l22ogx65goha4aimsue1kv` (`room_id`),
  KEY `FKkmg1kq8el0ahji526sycw8w7h` (`asset_id`),
  CONSTRAINT `FKhn8l22ogx65goha4aimsue1kv` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`),
  CONSTRAINT `FKkmg1kq8el0ahji526sycw8w7h` FOREIGN KEY (`asset_id`) REFERENCES `assets` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asset_room`
--

LOCK TABLES `asset_room` WRITE;
/*!40000 ALTER TABLE `asset_room` DISABLE KEYS */;
INSERT INTO `asset_room` (`id`, `asset_id`, `room_id`) VALUES (1,1,11);
/*!40000 ALTER TABLE `asset_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assets`
--

DROP TABLE IF EXISTS `assets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assets` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assets`
--

LOCK TABLES `assets` WRITE;
/*!40000 ALTER TABLE `assets` DISABLE KEYS */;
INSERT INTO `assets` (`id`, `name`) VALUES (1,'proiettore');
INSERT INTO `assets` (`id`, `name`) VALUES (2,'schermo motorizzato');
INSERT INTO `assets` (`id`, `name`) VALUES (3,'schermo manuale');
INSERT INTO `assets` (`id`, `name`) VALUES (4,'imp.audio');
INSERT INTO `assets` (`id`, `name`) VALUES (5,'pc fisso');
INSERT INTO `assets` (`id`, `name`) VALUES (6,'mic.a filo');
INSERT INTO `assets` (`id`, `name`) VALUES (7,'mic. senza filo');
INSERT INTO `assets` (`id`, `name`) VALUES (8,'lavagna luminosa');
INSERT INTO `assets` (`id`, `name`) VALUES (9,'visual presenter');
INSERT INTO `assets` (`id`, `name`) VALUES (10,'imp. elettrico');
INSERT INTO `assets` (`id`, `name`) VALUES (11,'allestimento');
INSERT INTO `assets` (`id`, `name`) VALUES (12,'lavagna');
/*!40000 ALTER TABLE `assets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_event`
--

DROP TABLE IF EXISTS `course_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_event` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `course_id` bigint NOT NULL,
  `event_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK3w0sj0m1m26wupj6l4mc762a7` (`course_id`,`event_id`,`id`),
  UNIQUE KEY `unique_course_event_id` (`course_id`,`event_id`),
  KEY `FK1bbb1j8w9ulpsohs1my0jdjbj` (`event_id`),
  CONSTRAINT `FK1bbb1j8w9ulpsohs1my0jdjbj` FOREIGN KEY (`event_id`) REFERENCES `events` (`id`),
  CONSTRAINT `FKeabnkbeptwp45dtvg0y2x4nd3` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_event`
--

LOCK TABLES `course_event` WRITE;
/*!40000 ALTER TABLE `course_event` DISABLE KEYS */;
INSERT INTO `course_event` (`id`, `course_id`, `event_id`) VALUES (58,2,45);
INSERT INTO `course_event` (`id`, `course_id`, `event_id`) VALUES (59,3,45);
INSERT INTO `course_event` (`id`, `course_id`, `event_id`) VALUES (61,4,45);
/*!40000 ALTER TABLE `course_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courses` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` (`id`, `name`) VALUES (1,'Advanced database system (basi di dati II)');
INSERT INTO `courses` (`id`, `name`) VALUES (2,'Advanced probability');
INSERT INTO `courses` (`id`, `name`) VALUES (3,'Web engineering');
INSERT INTO `courses` (`id`, `name`) VALUES (4,'Sviluppo web avanzato');
INSERT INTO `courses` (`id`, `name`) VALUES (5,'Analisi 1');
INSERT INTO `courses` (`id`, `name`) VALUES (6,'Ricerca Operativa');
INSERT INTO `courses` (`id`, `name`) VALUES (7,'Fisica');
INSERT INTO `courses` (`id`, `name`) VALUES (8,'Basi di dati laboratorio');
INSERT INTO `courses` (`id`, `name`) VALUES (9,'Fondamenti di programmazione');
INSERT INTO `courses` (`id`, `name`) VALUES (10,'CPU');
INSERT INTO `courses` (`id`, `name`) VALUES (11,'Seminario CyberSecurity');
INSERT INTO `courses` (`id`, `name`) VALUES (12,'Seminario Ingegneria del software');
INSERT INTO `courses` (`id`, `name`) VALUES (13,'Seminario sensibilizzazione igiene personale');
INSERT INTO `courses` (`id`, `name`) VALUES (14,'Matematica Discreta 1 e 2');
INSERT INTO `courses` (`id`, `name`) VALUES (15,'Teoria della calcolabilità e della complessità');
INSERT INTO `courses` (`id`, `name`) VALUES (16,'Web engineering');
INSERT INTO `courses` (`id`, `name`) VALUES (17,'Inglese B2');
INSERT INTO `courses` (`id`, `name`) VALUES (18,'Ottimizzazione combinatoria');
INSERT INTO `courses` (`id`, `name`) VALUES (19,'Laboratorio di algoritmica avanzata');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `events` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `description` varchar(255) NOT NULL,
  `end_time` time(6) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `start_time` time(6) DEFAULT NULL,
  `room_id` bigint NOT NULL,
  `supervisor_id` bigint NOT NULL,
  `typology_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK55v6kmb6lp5eeymlbtufcre7h` (`typology_id`),
  KEY `FK9y6cg48fwu0b5gqsnis471k7a` (`supervisor_id`),
  KEY `FKi4qc07gqilyboc4ueat9mtkn1` (`room_id`),
  CONSTRAINT `FK55v6kmb6lp5eeymlbtufcre7h` FOREIGN KEY (`typology_id`) REFERENCES `typologies` (`id`),
  CONSTRAINT `FK9y6cg48fwu0b5gqsnis471k7a` FOREIGN KEY (`supervisor_id`) REFERENCES `supervisors` (`id`),
  CONSTRAINT `FKi4qc07gqilyboc4ueat9mtkn1` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` (`id`, `date`, `description`, `end_time`, `name`, `start_time`, `room_id`, `supervisor_id`, `typology_id`) VALUES (1,'2023-09-10','Esame Basi di dati laboratorio','16:30:00.000000','E001','14:30:00.000000',1,3,2);
INSERT INTO `events` (`id`, `date`, `description`, `end_time`, `name`, `start_time`, `room_id`, `supervisor_id`, `typology_id`) VALUES (2,'2023-09-10','Esame Basi di dati laboratorio','16:30:00.000000','E002','14:30:00.000000',1,3,2);
INSERT INTO `events` (`id`, `date`, `description`, `end_time`, `name`, `start_time`, `room_id`, `supervisor_id`, `typology_id`) VALUES (3,'2023-09-10','Esame laboratorio di algoritmica avanzata','10:30:00.000000','E004','08:30:00.000000',1,3,2);
INSERT INTO `events` (`id`, `date`, `description`, `end_time`, `name`, `start_time`, `room_id`, `supervisor_id`, `typology_id`) VALUES (4,'2023-09-10','Esame Web engineering','18:30:00.000000','E005','18:00:00.000000',1,2,2);
INSERT INTO `events` (`id`, `date`, `description`, `end_time`, `name`, `start_time`, `room_id`, `supervisor_id`, `typology_id`) VALUES (5,'2023-09-10','Seminario CyberSecurity','13:30:00.000000','S009','10:00:00.000000',1,1,4);
INSERT INTO `events` (`id`, `date`, `description`, `end_time`, `name`, `start_time`, `room_id`, `supervisor_id`, `typology_id`) VALUES (6,'2023-09-10','Esame Basi di dati laboratorio','16:30:00.000000','TEST','14:30:00.000000',1,3,2);
INSERT INTO `events` (`id`, `date`, `description`, `end_time`, `name`, `start_time`, `room_id`, `supervisor_id`, `typology_id`) VALUES (7,'2023-09-10','Seminario ingegneria del software','10:30:00.000000','I2I007','09:00:00.000000',4,2,4);
INSERT INTO `events` (`id`, `date`, `description`, `end_time`, `name`, `start_time`, `room_id`, `supervisor_id`, `typology_id`) VALUES (8,'2023-08-02','Esame Parziale Matematica discreta 1 e 2','12:30:00.000000','E013','10:00:00.000000',8,2,4);
INSERT INTO `events` (`id`, `date`, `description`, `end_time`, `name`, `start_time`, `room_id`, `supervisor_id`, `typology_id`) VALUES (9,'2023-08-03','Esame Ottimizzazione combinatoria','13:30:00.000000','E016','10:00:00.000000',16,2,2);
INSERT INTO `events` (`id`, `date`, `description`, `end_time`, `name`, `start_time`, `room_id`, `supervisor_id`, `typology_id`) VALUES (10,'2023-08-04','Lezione Analisi','17:30:00.000000','L010','14:30:00.000000',8,1,3);
INSERT INTO `events` (`id`, `date`, `description`, `end_time`, `name`, `start_time`, `room_id`, `supervisor_id`, `typology_id`) VALUES (28,'2023-07-04','Esame Basi di dati laboratorio','16:30:00.000000','PROVA MODIFICA','14:30:00.000000',5,3,2);
INSERT INTO `events` (`id`, `date`, `description`, `end_time`, `name`, `start_time`, `room_id`, `supervisor_id`, `typology_id`) VALUES (30,'2023-07-04','Esame Basi di dati laboratorio','16:30:00.000000','TEST PROVA','14:30:00.000000',5,3,2);
INSERT INTO `events` (`id`, `date`, `description`, `end_time`, `name`, `start_time`, `room_id`, `supervisor_id`, `typology_id`) VALUES (31,'2023-07-04','Esame Basi di dati laboratorio','16:30:00.000000','TEST PROVA','14:30:00.000000',5,3,2);
INSERT INTO `events` (`id`, `date`, `description`, `end_time`, `name`, `start_time`, `room_id`, `supervisor_id`, `typology_id`) VALUES (32,'2023-07-04','Esame Basi di dati laboratorio','16:30:00.000000','TEST','14:30:00.000000',5,3,2);
INSERT INTO `events` (`id`, `date`, `description`, `end_time`, `name`, `start_time`, `room_id`, `supervisor_id`, `typology_id`) VALUES (33,'2023-07-04','Esame Basi di dati laboratorio','16:30:00.000000','TEST PROVA','14:30:00.000000',5,3,2);
INSERT INTO `events` (`id`, `date`, `description`, `end_time`, `name`, `start_time`, `room_id`, `supervisor_id`, `typology_id`) VALUES (34,'2023-07-04','Esame Basi di dati laboratorio','16:30:00.000000','TEST PROVA','14:30:00.000000',5,3,2);
INSERT INTO `events` (`id`, `date`, `description`, `end_time`, `name`, `start_time`, `room_id`, `supervisor_id`, `typology_id`) VALUES (35,'2023-07-04','Esame Basi di dati laboratorio','16:30:00.000000','TEST PROVA','14:30:00.000000',5,3,2);
INSERT INTO `events` (`id`, `date`, `description`, `end_time`, `name`, `start_time`, `room_id`, `supervisor_id`, `typology_id`) VALUES (36,'2023-07-04','Esame Basi di dati laboratorio','16:30:00.000000','TEST','14:30:00.000000',5,3,2);
INSERT INTO `events` (`id`, `date`, `description`, `end_time`, `name`, `start_time`, `room_id`, `supervisor_id`, `typology_id`) VALUES (37,'2023-07-04','Esame Basi di dati laboratorio','16:30:00.000000','TEST PROVA','14:30:00.000000',5,3,2);
INSERT INTO `events` (`id`, `date`, `description`, `end_time`, `name`, `start_time`, `room_id`, `supervisor_id`, `typology_id`) VALUES (38,'2023-07-04','Esame Basi di dati laboratorio','16:30:00.000000','TEST','14:30:00.000000',5,3,2);
INSERT INTO `events` (`id`, `date`, `description`, `end_time`, `name`, `start_time`, `room_id`, `supervisor_id`, `typology_id`) VALUES (39,'2023-07-04','Esame Basi di dati laboratorio','16:30:00.000000','TEST PROVA','14:30:00.000000',5,3,2);
INSERT INTO `events` (`id`, `date`, `description`, `end_time`, `name`, `start_time`, `room_id`, `supervisor_id`, `typology_id`) VALUES (40,'2023-08-02','Esame Basi di dati laboratorio','16:30:00.000000','TEST','14:30:00.000000',19,3,2);
INSERT INTO `events` (`id`, `date`, `description`, `end_time`, `name`, `start_time`, `room_id`, `supervisor_id`, `typology_id`) VALUES (41,'2023-08-02','Esame Basi di dati laboratorio','16:30:00.000000','TEST','14:30:00.000000',18,3,2);
INSERT INTO `events` (`id`, `date`, `description`, `end_time`, `name`, `start_time`, `room_id`, `supervisor_id`, `typology_id`) VALUES (42,'2023-08-02','Esame Basi di dati laboratorio','22:30:00.000000','TEST','21:50:00.000000',18,3,2);
INSERT INTO `events` (`id`, `date`, `description`, `end_time`, `name`, `start_time`, `room_id`, `supervisor_id`, `typology_id`) VALUES (43,'2023-08-03','TEST integration','12:10:00.000000','TEST integration','11:10:00.000000',1,3,5);
INSERT INTO `events` (`id`, `date`, `description`, `end_time`, `name`, `start_time`, `room_id`, `supervisor_id`, `typology_id`) VALUES (44,'2023-08-04','prova','12:21:00.000000','prova','10:18:00.000000',2,2,2);
INSERT INTO `events` (`id`, `date`, `description`, `end_time`, `name`, `start_time`, `room_id`, `supervisor_id`, `typology_id`) VALUES (45,'2023-08-04','prova 2','12:21:00.000000','prova 2','10:18:00.000000',1,3,2);
/*!40000 ALTER TABLE `events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locations`
--

DROP TABLE IF EXISTS `locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locations` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `building` varchar(255) NOT NULL,
  `floor` varchar(255) NOT NULL,
  `place` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` (`id`, `building`, `floor`, `place`) VALUES (1,'Alan Touring (Coppito 0)','terra','Coppito');
INSERT INTO `locations` (`id`, `building`, `floor`, `place`) VALUES (2,'Alan Touring (Coppito 0)','primo','Coppito');
INSERT INTO `locations` (`id`, `building`, `floor`, `place`) VALUES (3,'Coppito 1','terra','Coppito');
INSERT INTO `locations` (`id`, `building`, `floor`, `place`) VALUES (4,'Coppito 1','primo','Coppito');
INSERT INTO `locations` (`id`, `building`, `floor`, `place`) VALUES (5,'Coppito 1','secondo','Coppito');
INSERT INTO `locations` (`id`, `building`, `floor`, `place`) VALUES (6,'Coppito 2','terra','Coppito');
INSERT INTO `locations` (`id`, `building`, `floor`, `place`) VALUES (7,'Coppito 2','primo','Coppito');
INSERT INTO `locations` (`id`, `building`, `floor`, `place`) VALUES (8,'Coppito 2','secondo','Coppito');
INSERT INTO `locations` (`id`, `building`, `floor`, `place`) VALUES (9,'11 A','terra','Coppito');
INSERT INTO `locations` (`id`, `building`, `floor`, `place`) VALUES (10,'11 A','primo','Coppito');
INSERT INTO `locations` (`id`, `building`, `floor`, `place`) VALUES (11,'11 A','secondo','Coppito');
INSERT INTO `locations` (`id`, `building`, `floor`, `place`) VALUES (12,'11 A','terzo','Coppito');
INSERT INTO `locations` (`id`, `building`, `floor`, `place`) VALUES (13,'11 B','terra','Coppito');
INSERT INTO `locations` (`id`, `building`, `floor`, `place`) VALUES (14,'11 B','primo','Coppito');
INSERT INTO `locations` (`id`, `building`, `floor`, `place`) VALUES (15,'11 B','secondo','Coppito');
INSERT INTO `locations` (`id`, `building`, `floor`, `place`) VALUES (16,'Blocco Pontieri','terra','Roio');
INSERT INTO `locations` (`id`, `building`, `floor`, `place`) VALUES (17,'Blocco Pontieri','primo','Roio');
INSERT INTO `locations` (`id`, `building`, `floor`, `place`) VALUES (18,'Blocco Pontieri','secondo','Roio');
INSERT INTO `locations` (`id`, `building`, `floor`, `place`) VALUES (19,'Blocco Pontieri','terzo','Roio');
INSERT INTO `locations` (`id`, `building`, `floor`, `place`) VALUES (20,'Rettorato','terra','L\'Aquila Centro');
INSERT INTO `locations` (`id`, `building`, `floor`, `place`) VALUES (21,'Rettorato','primo','L\'Aquila Centro');
INSERT INTO `locations` (`id`, `building`, `floor`, `place`) VALUES (22,'Rettorato','sacondo','L\'Aquila Centro');
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `my_groups`
--

DROP TABLE IF EXISTS `my_groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `my_groups` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `link` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_groups`
--

LOCK TABLES `my_groups` WRITE;
/*!40000 ALTER TABLE `my_groups` DISABLE KEYS */;
INSERT INTO `my_groups` (`id`, `description`, `link`, `name`) VALUES (1,'Dipartimento di Ingegneria e Scienze dell\'Informazione e Matematica','https://aule.univaq.it/images_structures/diceaa.png','DISIM');
INSERT INTO `my_groups` (`id`, `description`, `link`, `name`) VALUES (2,'Aule senza dipartimento','https://aule.univaq.it/images_structures/diceaa.png','ATENEO');
INSERT INTO `my_groups` (`id`, `description`, `link`, `name`) VALUES (3,'Centro linguistico di ateneo','https://aule.univaq.it/images_structures/diceaa.png','CLA');
INSERT INTO `my_groups` (`id`, `description`, `link`, `name`) VALUES (4,'Polo laboratoriale didattico biologico-chimico','https://aule.univaq.it/images_structures/diceaa.png','COSBE');
INSERT INTO `my_groups` (`id`, `description`, `link`, `name`) VALUES (5,'Dipartimento Ingegneria civile edile-architettura-ambiente','https://aule.univaq.it/images_structures/diceaa.png','DICEAA');
INSERT INTO `my_groups` (`id`, `description`, `link`, `name`) VALUES (6,'Dipartimento di ingegneria industriale e dell\'informazione e di economia','https://aule.univaq.it/images_structures/diceaa.png','DIIIE aule Roio');
INSERT INTO `my_groups` (`id`, `description`, `link`, `name`) VALUES (7,'Dipartimento di ingegneria industriale e dell\'informazione e di economia','https://aule.univaq.it/images_structures/diceaa.png','DIIIE aule Acquasanta');
INSERT INTO `my_groups` (`id`, `description`, `link`, `name`) VALUES (8,'Dipartimento scienze chimiche applicate e biotecnologiche','https://aule.univaq.it/images_structures/diceaa.png','DISCAB');
INSERT INTO `my_groups` (`id`, `description`, `link`, `name`) VALUES (9,'Dipartimento di scienze fisiche e chimiche','https://aule.univaq.it/images_structures/diceaa.png','DSFC');
INSERT INTO `my_groups` (`id`, `description`, `link`, `name`) VALUES (10,'Dipartimento di scienze umane','https://aule.univaq.it/images_structures/diceaa.png','DSU');
INSERT INTO `my_groups` (`id`, `description`, `link`, `name`) VALUES (11,'Medicina clinica sanità pubblica scienze della vita e dell\'ambiente','https://aule.univaq.it/images_structures/diceaa.png','MESVA');
INSERT INTO `my_groups` (`id`, `description`, `link`, `name`) VALUES (12,'Centro di miscroscopia','https://aule.univaq.it/images_structures/diceaa.png','MICROSCOPIA');
INSERT INTO `my_groups` (`id`, `description`, `link`, `name`) VALUES (17,'Lorem','https://aule.univaq.it/images_structures/diceaa.png','PROVA');
INSERT INTO `my_groups` (`id`, `description`, `link`, `name`) VALUES (18,'Lorem','https://aule.univaq.it/images_structures/diceaa.png','PROVA');
INSERT INTO `my_groups` (`id`, `description`, `link`, `name`) VALUES (19,'Lorem','https://aule.univaq.it/images_structures/diceaa.png','PROVA');
INSERT INTO `my_groups` (`id`, `description`, `link`, `name`) VALUES (20,'Lorem','https://aule.univaq.it/images_structures/diceaa.png','TEST');
INSERT INTO `my_groups` (`id`, `description`, `link`, `name`) VALUES (21,'Lorem','https://aule.univaq.it/images_structures/diceaa.png','PROVA');
INSERT INTO `my_groups` (`id`, `description`, `link`, `name`) VALUES (24,'Lorem','https://aule.univaq.it/images_structures/diceaa.png','TEST');
/*!40000 ALTER TABLE `my_groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rooms` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `capacity` int NOT NULL,
  `description` varchar(255) NOT NULL,
  `electrical_outlets` int NOT NULL,
  `ethernet_ports` int NOT NULL,
  `link` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `group_id` bigint NOT NULL,
  `location_id` bigint NOT NULL,
  `supervisor_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK59197vn8qawqh7yjg8jc3ouyc` (`supervisor_id`),
  KEY `FK63x2nmd4esdnjrmlnxosq5of9` (`group_id`),
  KEY `FKn44nnd0bt5f0gwkdtw5ub1esg` (`location_id`),
  CONSTRAINT `FK59197vn8qawqh7yjg8jc3ouyc` FOREIGN KEY (`supervisor_id`) REFERENCES `supervisors` (`id`),
  CONSTRAINT `FK63x2nmd4esdnjrmlnxosq5of9` FOREIGN KEY (`group_id`) REFERENCES `my_groups` (`id`),
  CONSTRAINT `FKn44nnd0bt5f0gwkdtw5ub1esg` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rooms`
--

LOCK TABLES `rooms` WRITE;
/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;
INSERT INTO `rooms` (`id`, `capacity`, `description`, `electrical_outlets`, `ethernet_ports`, `link`, `name`, `group_id`, `location_id`, `supervisor_id`) VALUES (1,46,'',4,1,'https://material.angular.io/assets/img/examples/shiba1.jpg','C1.16',1,6,3);
INSERT INTO `rooms` (`id`, `capacity`, `description`, `electrical_outlets`, `ethernet_ports`, `link`, `name`, `group_id`, `location_id`, `supervisor_id`) VALUES (2,12,'i ragazzi tendono a perdersi',4,3,'https://material.angular.io/assets/img/examples/shiba1.jpg','0.6',1,3,3);
INSERT INTO `rooms` (`id`, `capacity`, `description`, `electrical_outlets`, `ethernet_ports`, `link`, `name`, `group_id`, `location_id`, `supervisor_id`) VALUES (3,24,'',4,3,'https://material.angular.io/assets/img/examples/shiba1.jpg','1.1',1,4,3);
INSERT INTO `rooms` (`id`, `capacity`, `description`, `electrical_outlets`, `ethernet_ports`, `link`, `name`, `group_id`, `location_id`, `supervisor_id`) VALUES (4,100,'',4,5,'https://material.angular.io/assets/img/examples/shiba1.jpg','1.7 (Aula biancofiore]',1,4,3);
INSERT INTO `rooms` (`id`, `capacity`, `description`, `electrical_outlets`, `ethernet_ports`, `link`, `name`, `group_id`, `location_id`, `supervisor_id`) VALUES (5,100,'',4,3,'https://material.angular.io/assets/img/examples/shiba1.jpg','2.5',1,5,3);
INSERT INTO `rooms` (`id`, `capacity`, `description`, `electrical_outlets`, `ethernet_ports`, `link`, `name`, `group_id`, `location_id`, `supervisor_id`) VALUES (6,100,'',4,1,'https://material.angular.io/assets/img/examples/shiba1.jpg','Aula Rossa',1,4,3);
INSERT INTO `rooms` (`id`, `capacity`, `description`, `electrical_outlets`, `ethernet_ports`, `link`, `name`, `group_id`, `location_id`, `supervisor_id`) VALUES (7,80,'',4,1,'https://material.angular.io/assets/img/examples/shiba1.jpg','C1.9',1,6,3);
INSERT INTO `rooms` (`id`, `capacity`, `description`, `electrical_outlets`, `ethernet_ports`, `link`, `name`, `group_id`, `location_id`, `supervisor_id`) VALUES (8,126,'',4,1,'https://material.angular.io/assets/img/examples/shiba1.jpg','C1.10',1,6,3);
INSERT INTO `rooms` (`id`, `capacity`, `description`, `electrical_outlets`, `ethernet_ports`, `link`, `name`, `group_id`, `location_id`, `supervisor_id`) VALUES (9,46,'',4,3,'https://material.angular.io/assets/img/examples/shiba1.jpg','A0.4',1,1,3);
INSERT INTO `rooms` (`id`, `capacity`, `description`, `electrical_outlets`, `ethernet_ports`, `link`, `name`, `group_id`, `location_id`, `supervisor_id`) VALUES (10,46,'',4,1,'https://material.angular.io/assets/img/examples/shiba1.jpg','A1.1',1,2,3);
INSERT INTO `rooms` (`id`, `capacity`, `description`, `electrical_outlets`, `ethernet_ports`, `link`, `name`, `group_id`, `location_id`, `supervisor_id`) VALUES (11,46,'tenda della finestra rotta',4,1,'https://material.angular.io/assets/img/examples/shiba1.jpg','A1.2',1,2,3);
INSERT INTO `rooms` (`id`, `capacity`, `description`, `electrical_outlets`, `ethernet_ports`, `link`, `name`, `group_id`, `location_id`, `supervisor_id`) VALUES (12,46,'',4,1,'https://material.angular.io/assets/img/examples/shiba1.jpg','A1.3',1,2,3);
INSERT INTO `rooms` (`id`, `capacity`, `description`, `electrical_outlets`, `ethernet_ports`, `link`, `name`, `group_id`, `location_id`, `supervisor_id`) VALUES (13,46,'tenda della finestra rotta',4,1,'https://material.angular.io/assets/img/examples/shiba1.jpg','A1.4',1,2,3);
INSERT INTO `rooms` (`id`, `capacity`, `description`, `electrical_outlets`, `ethernet_ports`, `link`, `name`, `group_id`, `location_id`, `supervisor_id`) VALUES (14,46,'',4,1,'https://material.angular.io/assets/img/examples/shiba1.jpg','A1.5',1,2,3);
INSERT INTO `rooms` (`id`, `capacity`, `description`, `electrical_outlets`, `ethernet_ports`, `link`, `name`, `group_id`, `location_id`, `supervisor_id`) VALUES (15,100,'',4,1,'https://material.angular.io/assets/img/examples/shiba1.jpg','A1.6',1,2,3);
INSERT INTO `rooms` (`id`, `capacity`, `description`, `electrical_outlets`, `ethernet_ports`, `link`, `name`, `group_id`, `location_id`, `supervisor_id`) VALUES (16,100,'infestazione di formiche all\'ingresso',4,1,'https://material.angular.io/assets/img/examples/shiba1.jpg','A1.7',1,2,3);
INSERT INTO `rooms` (`id`, `capacity`, `description`, `electrical_outlets`, `ethernet_ports`, `link`, `name`, `group_id`, `location_id`, `supervisor_id`) VALUES (17,20,'',4,1,'https://material.angular.io/assets/img/examples/shiba1.jpg','Digital Class',1,1,3);
INSERT INTO `rooms` (`id`, `capacity`, `description`, `electrical_outlets`, `ethernet_ports`, `link`, `name`, `group_id`, `location_id`, `supervisor_id`) VALUES (18,40,'',4,1,'https://material.angular.io/assets/img/examples/shiba1.jpg','B1.1',3,16,2);
INSERT INTO `rooms` (`id`, `capacity`, `description`, `electrical_outlets`, `ethernet_ports`, `link`, `name`, `group_id`, `location_id`, `supervisor_id`) VALUES (19,25,'',5,2,'https://material.angular.io/assets/img/examples/shiba1.jpg','B1.2',3,17,1);
INSERT INTO `rooms` (`id`, `capacity`, `description`, `electrical_outlets`, `ethernet_ports`, `link`, `name`, `group_id`, `location_id`, `supervisor_id`) VALUES (20,100,'',4,2,'https://material.angular.io/assets/img/examples/shiba1.jpg','F1.1',4,18,1);
INSERT INTO `rooms` (`id`, `capacity`, `description`, `electrical_outlets`, `ethernet_ports`, `link`, `name`, `group_id`, `location_id`, `supervisor_id`) VALUES (21,25,'',5,2,'https://material.angular.io/assets/img/examples/shiba1.jpg','F1.2',4,19,1);
INSERT INTO `rooms` (`id`, `capacity`, `description`, `electrical_outlets`, `ethernet_ports`, `link`, `name`, `group_id`, `location_id`, `supervisor_id`) VALUES (22,75,'',5,2,'https://material.angular.io/assets/img/examples/shiba1.jpg','D1.1',8,20,2);
INSERT INTO `rooms` (`id`, `capacity`, `description`, `electrical_outlets`, `ethernet_ports`, `link`, `name`, `group_id`, `location_id`, `supervisor_id`) VALUES (23,50,'',5,2,'https://material.angular.io/assets/img/examples/shiba1.jpg','D1.2',8,21,3);
INSERT INTO `rooms` (`id`, `capacity`, `description`, `electrical_outlets`, `ethernet_ports`, `link`, `name`, `group_id`, `location_id`, `supervisor_id`) VALUES (24,1,'DescTest',2,3,'LinkTest','TEST CHANGE',1,3,2);
INSERT INTO `rooms` (`id`, `capacity`, `description`, `electrical_outlets`, `ethernet_ports`, `link`, `name`, `group_id`, `location_id`, `supervisor_id`) VALUES (25,1,'DescTest',2,3,'LinkTest','nameTest',1,3,2);
INSERT INTO `rooms` (`id`, `capacity`, `description`, `electrical_outlets`, `ethernet_ports`, `link`, `name`, `group_id`, `location_id`, `supervisor_id`) VALUES (26,1,'DescTest',2,3,'LinkTest','nameTest',1,3,2);
INSERT INTO `rooms` (`id`, `capacity`, `description`, `electrical_outlets`, `ethernet_ports`, `link`, `name`, `group_id`, `location_id`, `supervisor_id`) VALUES (27,1,'DescTest',2,3,'LinkTest','TEST CHANGE',1,3,2);
INSERT INTO `rooms` (`id`, `capacity`, `description`, `electrical_outlets`, `ethernet_ports`, `link`, `name`, `group_id`, `location_id`, `supervisor_id`) VALUES (28,1,'DescTest',2,3,'LinkTest','TEST CHANGE',1,3,2);
INSERT INTO `rooms` (`id`, `capacity`, `description`, `electrical_outlets`, `ethernet_ports`, `link`, `name`, `group_id`, `location_id`, `supervisor_id`) VALUES (29,14,'TEST integration',15,16,'TEST integration','TEST integration Change',3,3,3);
/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supervisors`
--

DROP TABLE IF EXISTS `supervisors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supervisors` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supervisors`
--

LOCK TABLES `supervisors` WRITE;
/*!40000 ALTER TABLE `supervisors` DISABLE KEYS */;
INSERT INTO `supervisors` (`id`, `email`, `name`) VALUES (1,'lorenzo.bosica1@student.univaq.it','Lorenzo');
INSERT INTO `supervisors` (`id`, `email`, `name`) VALUES (2,'stefano.bavota@student.univaq.it','Stefano');
INSERT INTO `supervisors` (`id`, `email`, `name`) VALUES (3,'denis.ciammaricone@student.univaq.it','Denis');
/*!40000 ALTER TABLE `supervisors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `typologies`
--

DROP TABLE IF EXISTS `typologies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `typologies` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `typologies`
--

LOCK TABLES `typologies` WRITE;
/*!40000 ALTER TABLE `typologies` DISABLE KEYS */;
INSERT INTO `typologies` (`id`, `name`) VALUES (1,'seminario');
INSERT INTO `typologies` (`id`, `name`) VALUES (2,'riunione');
INSERT INTO `typologies` (`id`, `name`) VALUES (3,'lauree');
INSERT INTO `typologies` (`id`, `name`) VALUES (4,'lezione');
INSERT INTO `typologies` (`id`, `name`) VALUES (5,'esame');
INSERT INTO `typologies` (`id`, `name`) VALUES (6,'parziale');
INSERT INTO `typologies` (`id`, `name`) VALUES (7,'altro');
/*!40000 ALTER TABLE `typologies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `email`, `name`, `password`) VALUES (1,'lorenzo@univaq.it','Lorenzo','password');
INSERT INTO `users` (`id`, `email`, `name`, `password`) VALUES (2,'stefano@univaq.it','Stefano','password');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-10 15:49:54
