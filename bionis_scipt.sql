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
  `name` varchar(25) DEFAULT NULL,
  `gender` varchar(25) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `race` varchar(25) DEFAULT NULL,
  `trade` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`tableId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colony9`
--

LOCK TABLES `colony9` WRITE;
/*!40000 ALTER TABLE `colony9` DISABLE KEYS */;
INSERT INTO `colony9` VALUES (1,'Giorgo','Male',41,'Homs','no'),(2,'Dorothy','Female',19,'Homs','yes'),(3,'Paola','Female',10,'Homs','no'),(4,'Miller','Male',25,'Homs','yes'),(5,'Lucas','Male',12,'Homs','yes'),(6,'Deki','Male',68,'Nopon','yes'),(7,'Lupa','Female',28,'Nopon','yes'),(8,'Rono','Male',18,'Nopon','no'),(9,'Nelo','Male',34,'Nopon','yes'),(10,'Kacha','Female',38,'Nopon','yes'),(11,'Jarack','Male',27,'Angel','yes'),(12,'Talia','Female',18,'Angel','yes'),(13,'Miriall','Female',19,'Angel','no'),(14,'Zain','Male',21,'Angel','yes'),(15,'Shalen','Female',44,'Angel','no'),(16,'Zilex','Male',29,'Machina','yes'),(17,'Rizaka','Female',46,'Machina','yes'),(18,'Kazat','Male',38,'Machina','no'),(19,'Eiz','Male',42,'Machina','no'),(20,'Bozatrox','Female',35,'Machina','yes');
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

-- Dump completed on 2024-03-22 10:50:41
