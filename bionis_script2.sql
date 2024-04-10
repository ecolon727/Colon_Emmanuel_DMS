CREATE DATABASE  IF NOT EXISTS `bionis` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bionis`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: bionis
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `colony9`
--

DROP TABLE IF EXISTS `colony9`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `colony9` (
  `tableId` int NOT NULL,
  `name` varchar(10) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `age` int NOT NULL,
  `race` varchar(7) NOT NULL,
  `trade` varchar(3) NOT NULL,
  PRIMARY KEY (`tableId`),
  CONSTRAINT `colony9_chk_1` CHECK (((`age` >= 1) and (`age` <= 100))),
  CONSTRAINT `colony9_chk_2` CHECK (((`trade` = _utf8mb4'on') or (`trade` = _utf8mb4'off'))),
  CONSTRAINT `colony9_chk_3` CHECK (((`race` = _utf8mb4'Homs') or (`race` = _utf8mb4'Nopon') or (`race` = _utf8mb4'Angel') or (`race` = _utf8mb4'Machina'))),
  CONSTRAINT `colony9_chk_4` CHECK (((`gender` = _utf8mb4'Male') or (`gender` = _utf8mb4'female')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colony9`
--

LOCK TABLES `colony9` WRITE;
/*!40000 ALTER TABLE `colony9` DISABLE KEYS */;
INSERT INTO `colony9` VALUES (1,'Giorgio','Male',41,'Homs','off'),(2,'Dorothy','Female',19,'Homs','on'),(3,'Paola','Female',10,'Homs','off'),(4,'Miller','Male',25,'Homs','on'),(5,'Lucas','Male',12,'Homs','on'),(6,'Deki','Male',68,'Nopon','on'),(7,'Lupa','Female',28,'Nopon','on'),(8,'Rono','Male',18,'Nopon','off'),(9,'Nelo','Male',34,'Nopon','on'),(10,'Kacha','Female',38,'Nopon','on'),(11,'Jarack','Male',27,'Angel','on'),(12,'Talia','Female',18,'Angel','on'),(13,'Miriall','Female',19,'Angel','off'),(14,'Zain','Male',21,'Angel','on'),(15,'Shalen','Female',44,'Angel','off'),(16,'Zilex','Male',29,'Machina','on'),(17,'Rizaka','Female',46,'Machina','off'),(18,'Kazat','Male',38,'Machina','off'),(19,'Eiz','Male',42,'Machina','on'),(20,'Bozatrox','Female',35,'Machina','on');
/*!40000 ALTER TABLE `colony9` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-10 17:37:05
