CREATE DATABASE  IF NOT EXISTS `school_database` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `school_database`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: school_database
-- ------------------------------------------------------
-- Server version	5.6.14

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `ID` bigint(20) NOT NULL DEFAULT '0',
  `Name` varchar(20) DEFAULT NULL,
  `Sex` varchar(8) NOT NULL,
  `Bir` date DEFAULT NULL,
  `Class` varchar(10) DEFAULT NULL,
  `Adr` varchar(60) DEFAULT NULL,
  `Remarks` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (0,'YiLi','F','1989-12-11','04_JG','123 LaoDongLu','da cai bi'),(222,'Baoo','F','1888-01-01','06_PE','456 Townplace Dr.','triple B student'),(333,'old man','M','1975-12-12','05_EE','White house','lalalala'),(555,'niu geng','F','1987-01-01','10_PE','1501 Harvey Rd','dota cai bi'),(1111,'Tracy','M','1998-02-02','06_KEY','1101 Ellendala Pl. ','This is a mix boy'),(2143,'bear','M','2001-01-01','05_CS','123 Star Ave.','check this'),(3333,'hpPlayer','M','1990-01-01','Dota_Pro','Mars','Pro dotaer'),(4444,'liang diao','F','1992-07-21','13_cs','123  Apt.','JavaScript'),(123456,'Allen','M','1988-08-29','06_CS','123 harvey rd','triple-A student'),(261302,'Cat','M','2006-01-02','05_MaiMeng','No.1 Forest  Apt.','meow meow meow'),(261302010,'X-man','M','2000-05-06','06_hero','Mars','Biu Biu Biu');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-07-15 14:13:55
